<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style.css">
    <title>Biblioteca-ADM</title>

    <script>
        function closeLogin() {
            document.querySelector('.fundo-login').style.display = 'none';
        }
    </script>

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

    require_once "banco.php";  

    if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['botao'])) {

        switch ($_POST['botao']){

            case 'login':
                        
                echo "<div class=\"fundo-login\">

                        <div class=\"login\">

                            <button class=\"close\" onclick=\"closeLogin()\" > X </button>";

                                require_once "form-login.php";

                echo        "<button class=\"buttom-new\"> Don't have an account? CREATE ONE </button>
                            
                        </div>

                    </div>";
                
                break;

            case 'Minhas_locações':


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

        }

    }

    if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['cpf']) && isset($_POST['senha'])){

        $cpf = $_POST['cpf'] ?? null;
        $senha = $_POST['senha'] ?? null;

        $busca = $banco->query("SELECT * FROM usuarios WHERE Cpf='$cpf'");

        $obj = $busca->fetch_object();

            if($busca->num_rows == 0){
                // ERRO usuario nao cadastrado 
            }else{

                if($senha == $obj->Senha){
                    $_SESSION["usuario"] = $obj->Nome;
                    $_SESSION["cpf"] = $obj->cpf;
                }

            }

        }

    ?> 

    <header class="flex borda-teste" style="justify-content: space-between">

        <div class="div-header flex">

            <a href="./index.php" class="logo flex"> " BIBLIOTECA PHP " </a>

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

    <section class="flex borda-teste" style="height: 558px; justify-content: space-evenly; padding: 20px;">

        <div class="div-55">

            <div class="flex div-butao">
                <button class="butao-adm" type="button" data-form="./src/forms/form-alterar-usuario.php">Alterar Usuário</button>
                <button class="butao-adm" type="button" data-form="./src/forms/form-cadastrar-livro.php">Cadastrar Livro</button>
                <button class="butao-adm" type="button" data-form="./src/forms/form-cadastrar-categoria.php">Cadastrar Categoria</button>
                <button class="butao-adm" type="button" data-form="./src/forms/form-deletar-usuario.php">Deletar Usuário</button>
                <button class="butao-adm" type="button" data-form="./src/forms/form-deletar-livro.php">Deletar Livro</button>
                <button class="butao-adm" type="button" data-form="./src/forms/form-deletar-categoria.php">Deletar Categoria</button>
            </div>

            <div class="flex div-display" id="display-form">Carregando...</div>

        </div>

        <div class="div-35 flex">

            <div class="flex div-butao">
                <button class="butao-adm" type="button" onclick="mostrarLista('usuarios')">listar usuarios</button>
                <button class="butao-adm" type="button" onclick="mostrarLista('livros')">listar livros</button>
                <button class="butao-adm" type="button" onclick="mostrarLista('categorias')">listar categorias</button>
            </div>

            <div class="div-display lista" id="display-list">Carregando...</div>

        </div>

        <?php

            if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['cpf-alterar'])){

                $cpf = $_POST['cpf-alterar'] ?? null;
                $telefone = $_POST['telefone'] ?? null;
                $email = $_POST['email'] ?? null;
                $endereco = $_POST['endereco'] ?? null;
                $senha = $_POST['senha'] ?? null;

                alterarUsuario($cpf, $telefone, $email, $endereco, $senha);

            }

            if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['titulo-cadastrar'])){

                $titulo = $_POST['titulo-cadastrar'] ?? null;
                $autor = $_POST['autor'] ?? null;
                $editora = $_POST['editora'] ?? null;
                $quantidade = $_POST['quantidade'] ?? null;
                $categoria = $_POST['categoria'] ?? null;

                cadastrarLivro($titulo, $autor, $editora, $quantidade, $categoria);

            }

            if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['categoria-cadastrar'])){

                $categoria = $_POST['categoria-cadastrar'];

                cadastrarCategoria($categoria);

            }

            if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['cpf-deletar'])){

                $cpf = $_POST['cpf-deletar'];

                deletarUsuario($cpf);

            }

            if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['titulo-deletar'])){

                $titulo = $_POST['titulo-deletar'];

                deletarLivro($titulo);

            }

            if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['categoria-deletar'])){

                $categoria = $_POST['categoria-deletar'];

                deletarCategoria($categoria);

            }
             

        ?>

    </section>

    <script src="scripts.js"></script>
    
</body>

</html>