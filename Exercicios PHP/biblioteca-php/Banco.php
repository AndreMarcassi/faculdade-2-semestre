<?php 

    $password  = "home13"; // colocar a senha do mySQL se tiver
    $dbname  = "db_biblioteca_php"; // nome do banco

    $banco = new mysqli("localhost", "root", $password, $dbname);

    //verificando conexão
    if ($banco->connect_error){
        die("connection failed: " . $banco->connect_error);
    }

    //  FUNÇÕES PARA USUÁRIOS


    //  FUNÇÃO PARA VERIFICAR SE O CPF EXISTE
    function verificarCpf(string $cpf) : bool{
        global $banco;

        $q = "SELECT * FROM usuarios WHERE cpf='$cpf'";
        $busca = $banco->query($q);

        if($busca->num_rows == 0){
            return false;
        }else{
            return true;
        }

    }

    //  FUNÇÃO PARA PEGAR O NOME DO USUÁRIO
    function getUsuario(string $cpf, string $senha) : string{
        global $banco;

        $q = "SELECT nome, senha FROM usuarios WHERE cpf='$cpf'";
        $busca = $banco->query($q);
    
        if ($busca->num_rows > 0) {
            $obj = $busca->fetch_object();
            $hash = $obj->senha;
    
            if (password_verify($senha, $hash)) {
                return $obj->nome;
            }
        }

    }

    //  FUNÇÃO PARA PEGAR O ID DO USUARIO
    function getId(String $cpf) : string{
        global $banco;

        $q = "SELECT PK_id_usuario FROM usuarios where cpf='$cpf'";
        $busca = $banco->query($q);

        $obj = $busca->fetch_object();

        return $obj->PK_id_usuario;

    }

    //  FUNÇÃO PARA CADASTRAR UM NOVO USUÁRIO
    function cadastrarUsuario(string $nome, string $cpf, string $telefone, string $email, string $endereco, string $senha) : void {
        global $banco;
    
        if (verificarCpf($cpf) == true) {
    
        } else {

            $senhaHash = password_hash($senha, PASSWORD_DEFAULT);
            
            $q = "INSERT INTO usuarios (nome, cpf, telefone, email, endereco, senha) VALUES ('$nome', '$cpf', '$telefone', '$email', '$endereco', '$senhaHash')";
            $banco->query($q);
    
        }
    }

    //  FUNÇÃO PARA DELETAR UM USUÁRIO
    function deletarUsuario(string $cpf, bool $debug = true) : void {
        global $banco;

        $q = "DELETE FROM usuarios WHERE Cpf='$cpf'";
        $busca = $banco->query($q);

        if ($debug) {
            echo"
            <div class=\"fundo-debug\" id=\"debugMessage\">

                <div class=\"debug\">

                    <h3> Usuario deletado com sucesso! </h3>
                                    
                </div>

            </div>"; 
        }

    } 

    //  FUNÇÃO PARA ALTERAR UM USUÁRIO
    function alterarUsuario(string $cpf, string $telefone, string $email, string $endereco, string $senha, bool $debug = true) : void {
        global $banco;

        $q = "UPDATE usuarios SET Telefone = '$telefone', Email = '$email', Endereço = '$endereco', senha = '$senha' WHERE cpf = '$cpf'";
        $busca = $banco->query($q);

        if ($debug) {
            echo"
            <div class=\"fundo-debug\" id=\"debugMessage\">

                <div class=\"debug\">

                    <h3> Usuario alterado com sucesso! </h3>
                                    
                </div>

            </div>"; 
        }

    }



    //  FUNÇÕES PARA LIVROS


    //  FUNÇÃO PARA CADASTRAR UM NOVO LIVRO
    function cadastrarLivro(string $titulo, string $autor, string $editora, int $quantidade, string $categoria, bool $debug = true) : void {
        global $banco;
    
        $q = "SELECT PK_id_categoria FROM categorias WHERE categoria='$categoria'";
        $busca = $banco->query($q);
    
        if ($busca->num_rows > 0){ 
            $obj = $busca->fetch_object();
            $FK_id_categoria = $obj->PK_id_categoria;
    
            if (isset($_FILES["capa"]) && $_FILES["capa"]["error"] == 0) {
                $filename = preg_replace('/[^a-zA-Z0-9_-]/', '_', $titulo);
                $ext = pathinfo($_FILES["capa"]["name"], PATHINFO_EXTENSION);
    
                $newfilename = $filename . "." . $ext;
                $fileurl = "./src/img/" . $newfilename;
    
                if (move_uploaded_file($_FILES["capa"]["tmp_name"], $fileurl)) {

                    $q = "INSERT INTO livros (titulo, autor, editora, quantidade, capa, FK_id_categoria) VALUES ('$titulo', '$autor', '$editora', '$quantidade', '$fileurl', '$FK_id_categoria')";
                    $busca = $banco->query($q);
                    if ($busca) {
                        if ($debug) {
                            echo"
                            <div class=\"fundo-debug\" id=\"debugMessage\">

                                <div class=\"debug\">

                                    <h3> Livro cadastrado com sucesso! </h3>
                                    
                                </div>

                            </div>";
                        }
                    } else {
                        if ($debug) {
                            echo"
                            <div class=\"fundo-debug\" id=\"debugMessage\">

                                <div class=\"debug\">

                                    <h3> Erro ao cadastrar o livro: . $banco->error; </h3>
                                    
                                </div>

                            </div>";
                        }
                    }
                } else {
                    if ($debug) {
                        echo"
                        <div class=\"fundo-debug\" id=\"debugMessage\">

                            <div class=\"debug\">

                                <h3> Erro ao fazer upload da imagem. </h3>
                                
                            </div>

                        </div>";
                    }
                }
            } else {
                if ($debug) {
                    echo"
                    <div class=\"fundo-debug\" id=\"debugMessage\">

                        <div class=\"debug\">

                            <h3> Erro: Nenhum arquivo de imagem selecionado ou ocorreu um erro no upload. </h3>
                            
                        </div>

                    </div>";
                }
            }
        } else {
            if ($debug) {
                echo"
                <div class=\"fundo-debug\" id=\"debugMessage\">

                    <div class=\"debug\">

                        <h3> Categoria não encontrada. </h3>
                        
                    </div>

                </div>";
            }
        }
    }

    //  FUNÇÃO PARA DELETAR UM LIVRO
    function deletarLivro(string $titulo, bool $debug = true) : void {
        global $banco;

        $q = "DELETE FROM livros WHERE titulo='$titulo'";
        $busca = $banco->query($q);

        if ($debug) {
            echo"
            <div class=\"fundo-debug\" id=\"debugMessage\">

                <div class=\"debug\">

                    <h3> Livro deletado com sucesso! </h3>
                                    
                </div>

            </div>"; 
        }

    } 

    // FUNÇÃO PARA PEGAR LIVRO
    function listarLivros(int $id){
        global $banco;

        $q = "SELECT titulo, capa FROM livros WHERE PK_id_livro = '$id'";
        $busca = $banco->query($q);

        return $busca;

    }



    //  FUNÇÕES PARA CATEGORIAS


    //  FUNÇÃO PARA CADASTRAR UMA NOVA CATEGORIA
    function cadastrarCategoria(string $categoria, bool $debug = true) : void {
        global $banco;

        $q = "INSERT INTO categoria (categoria) VALUES ($categoria)";
        $busca = $banco->query($q);

        if ($debug) {
            echo"
            <div class=\"fundo-debug\" id=\"debugMessage\">

                <div class=\"debug\">

                    <h3> Categoria cadastrada com sucesso! </h3>
                                    
                </div>

            </div>"; 
        }

    }

    //  FUNÇÃO PARA DELETAR UMA CATEGORIA
    function deletarCategoria(string $categoria, bool $debug = true) : void {
        global $banco;

        $q = "DELETE FROM categorias WHERE categoria='$categoria'";
        $busca = $banco->query($q);

        if ($debug) {
            echo"
            <div class=\"fundo-debug\" id=\"debugMessage\">

                <div class=\"debug\">

                    <h3> Categoria deletado com sucesso! </h3>
                                    
                </div>

            </div>"; 
        }

    }
    

    //  FUNÇÕES PARA LOCAÇÕES


    //  FUNÇÃO PARA EFETUAR UMA LOCAÇÃO
    function adicionarLocacao(int $PK_id_livro, int $PK_id_usuario) {
        global $banco;
    
        $data_locacao = date('Y-m-d');
        $data_devolucao = date('Y-m-d', strtotime($data_locacao . ' + 10 days'));
    
        $q = "INSERT INTO locacao (FK_id_usuario, Data_locacao, Data_devolucao) VALUES ($PK_id_usuario, '$data_locacao', '$data_devolucao')";
        $banco->query($q);
    
        $PK_id_locacao = $banco->insert_id;
    
        $q = "INSERT INTO ligacao (FK_id_locacao, FK_id_livro) VALUES ($PK_id_locacao, $PK_id_livro)";
        $banco->query($q);
    }

    // FUNÇÃO PARA EFETUAR UMA DEVOLUÇÃO

    function efetuarDevolucao(int $PK_id_locacao) {
        global $banco;

        $q = "DELETE FROM locacao where PK_id_locacao = $PK_id_locacao";
        $banco->query($q);

    }
  
    // FUNÇÃO PARA LISTAR AS LOCAÇÕES DO USUARIO
    function listarLocacoes(int $PK_id_usuario){
        global $banco;

        $q = "SELECT livros.PK_id_livro, livros.titulo, livros.capa, locacao.data_locacao, locacao.data_devolucao, locacao.PK_id_locacao FROM livros
        JOIN ligacao ON livros.PK_id_livro = ligacao.FK_id_livro
        JOIN locacao ON ligacao.FK_id_locacao = locacao.PK_id_locacao
        JOIN usuarios ON locacao.FK_id_usuario = usuarios.PK_id_usuario
        WHERE usuarios.PK_id_usuario = $PK_id_usuario";

        $busca = $banco->query($q);

        return $busca;

    } 
    
?>