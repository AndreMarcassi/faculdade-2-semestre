<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style.css">
    <title>Biblioteca</title>

</head>

<body class="flex" style="flex-wrap: wrap">

    <?php 

        session_start();

        if (!isset($_SESSION["usuario"])) {
           $_SESSION["usuario"] = "";
        }

        if (!isset($_SESSION["cpf"])) {
            $_SESSION["cpf"] = "";
        }

        if (!isset($_SESSION["locacoes"])) {
            $_SESSION["locacoes"] = [];
        }

        require_once "banco.php";  
        
        if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['botao'])) {

            switch ($_POST['botao']){

                case 'login':

                        echo"
                        <div class=\"fundo-login\">
    
                            <div class=\"login\">
    
                                <button class=\"close\" onclick=\"closeLogin()\" > X </button>";
    
                                    require_once "./src/forms/form-login.php";
                           
                                echo"
                                <form class=\"buttom-new\" method=\"post\">
                    
                                    <button class=\"buttom-new\" type=\"submit\" name=\"botao\" value=\"novo\"> Don't have an account? CREATE ONE </button>

                                </form>
                           
                            </div>
    
                        </div>";
                    
                    break;

                case 'novo':
                            
                        echo"
                        <div class=\"fundo-login\">
    
                            <div class=\"login\">
    
                                <button class=\"close\" onclick=\"closeLogin()\" > X </button>";
    
                                    require_once "./src/forms/form-criar-conta.php";

                            echo"
                            </div>
    
                        </div>";
                        
                    break;

                case 'Minhas_locações':

                    header('Location: locacoes.php');
                    exit;

                    break;

                case 'Pagina_de_ADM':

                    header('Location: administrador.php');
                    exit;

                    break;

                case 'logout':

                        $_SESSION["usuario"] = null;
                        $_SESSION["cpf"] = null;
                        $_SESSION["locacoes"] = null;

                        header('Location: index.php');
                        exit;

                    break;

                case 'efetuar-locacao':

                        $PK_id_usuario = getId($_SESSION['cpf']);

                        foreach ($_SESSION['locacoes'] as $locacao) {
                            adicionarLocacao($locacao, $PK_id_usuario);
                        }

                        $_SESSION['locacoes'] = null;

                    break;

            }

        }

        if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['nome-novo'])){

            $nome = $_POST['nome-novo'];
            $cpf = $_POST['cpf'];
            $telefone = isset($_POST['Telefone']) ? $_POST['Telefone'] : '';
            $email = isset($_POST['Email']) ? $_POST['Email'] : '';
            $endereco = isset($_POST['Endereco']) ? $_POST['Endereco'] : '';
            $senha = $_POST['Senha'];

            cadastrarUsuario($nome, $cpf, $telefone, $email, $endereco, $senha);

        }

        if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['cpf']) && isset($_POST['senha'])){

            $cpf = $_POST['cpf'] ?? null;
            $senha = $_POST['senha'] ?? null;

            if (verificarCpf($cpf, $senha)==true) {
                $_SESSION["usuario"] = getUsuario($cpf, $senha);
                $_SESSION["cpf"] = $cpf;
            }
 
        }

        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            if (isset($_POST['remove_id'])) {
                $remove_id = $_POST['remove_id'];
                $index = array_search($remove_id, $_SESSION['locacoes']);
                if ($index !== false) {
                    unset($_SESSION['locacoes'][$index]);
                }
            }
        }

        if ($_SERVER['REQUEST_METHOD'] == 'POST') {

            if (isset($_POST['addLivro'])) {
                $livroId = $_POST['addLivro'];

                if (!in_array($livroId, $_SESSION['locacoes'])){
                    $_SESSION['locacoes'][] = $livroId;
                }
            }
            
        }


    ?> 

    <header class="flex borda-teste" style="justify-content: space-between">

        <div class="div-header flex">

            <h2 class="logo flex"> " BIBLIOTECA PHP " </h2>

        </div>

        <form method="post" class="div-header flex" style="justify-content: space-between">

            <?php

                if ($_SESSION["locacoes"] !== null || $_SESSION["locacoes"] !== "") {
                    echo "

                    <div class=\"dropdown\">
                        <button class=\"butao-dropdown flex dropdown-toggle\" type=\"button\">LOCAÇÕES</button>
                        <div class=\"dropdown-content\" id=\"locacoes-list\" style=\"width: 200%;\">";

                        foreach ($_SESSION['locacoes'] as $locacao) {
                            $livros = listarLivros($locacao);
                            foreach ($livros as $livro) {
                                echo "

                                    <div class=\"lista-locacao flex\">

                                        <div class=\"locacao-capa flex\">
                                            <img src='" . htmlspecialchars($livro['capa']) . "' alt='Capa do livro'>
                                        </div>

                                        <div class=\"locacao-titulo flex\" style=\"flex-wrap: wrap\">

                                            <h4 class=\"titulo\">". htmlspecialchars($livro['titulo']) ."</h4>

                                            <button class=\"butao-remover\" type=\"submit\" name=\"remove_id\" value=\"" . $locacao . "\">Remover</button>

                                        </div>

                                    </div>
                                ";
                            }
                        }

                        echo "

                            <button class\"efetuar-locacao\" type=\"submit\" style=\"text-align: center;\" name=\"botao\" value=\"efetuar-locacao\">Efetuar locação</button>

                        </div>

                    </div>";

                }

                if ($_SESSION["usuario"] == null || $_SESSION["usuario"] == "") {
                    echo '<button class="butao flex" type="submit" name="botao" value="login">LOGIN</button>';
                } else {
                    if ($_SESSION["usuario"] == "ADM") {
                        echo "
                        <div class=\"dropdown\">

                            <button class=\"butao-dropdown flex dropdown-toggle\" type=\"button\">ADM</button>

                            <div class=\"dropdown-content\">

                                <button type=\"submit\" name=\"botao\" value=\"Pagina_de_ADM\">Pagina de ADM</button>
                                <button type=\"submit\" name=\"botao\" value=\"Minhas_locações\">Minhas locações</button>
                                <button type=\"submit\" name=\"botao\" value=\"logout\">logout</button>

                            </div>

                        </div>";

                    } else {
                        echo "
                        <div class=\"dropdown\">

                            <button class=\"butao-dropdown flex dropdown-toggle\" type=\"button\">" . $_SESSION["usuario"] . "</button>

                            <div class=\"dropdown-content\" style=\"background-color: #f1f1f1;\">

                                <button type=\"submit\" name=\"botao\" value=\"Minhas_locações\">Minhas locações</button>
                                <button type=\"submit\" name=\"botao\" value=\"logout\">logout</button>

                            </div>

                        </div>";
                    }
                }
            ?>

        </form>

    </header>

    <section class="flex borda-teste" style="flex-wrap: wrap; justify-content: space-evenly;">

        <?php

            $q = "SELECT capa, PK_id_livro FROM livros";
            $busca = $banco->query($q);

            while ($obj = $busca->fetch_object()) { 

                echo "<div class=\"livro\" style=\"background-image: url($obj->capa) ;\">

                    <form method=\"POST\" action=\"\" class=\"locacao\">

                        <button class=\"locacao\" type=\"submit\" name=\"addLivro\" value=\"" . $obj->PK_id_livro . "\"> locar </button>

                    </form>

                </div>";

            }

        ?>

    </section>

    <script src="scripts.js"></script>
    
</body>

</html>