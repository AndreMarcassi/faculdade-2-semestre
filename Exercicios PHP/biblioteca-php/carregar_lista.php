<?php
    session_start();

    include 'Banco.php';    

    function loadLists($banco) {
        $_SESSION["listaUsuarios"] = array();
        $q = "SELECT nome, cpf FROM usuarios";
        $busca = $banco->query($q);
        while ($obj = $busca->fetch_object()) {
            $_SESSION["listaUsuarios"][] = "<li>Nome: $obj->nome Cpf: $obj->cpf </li>";
        }

        $_SESSION["listaTitulos"] = array();
        $q = "SELECT titulo FROM livros";
        $busca = $banco->query($q);
        while ($obj = $busca->fetch_object()) {
            $_SESSION["listaTitulos"][] = "<li>$obj->titulo</li>";
        }

        $_SESSION["listaCategoria"] = array();
        $q = "SELECT categoria FROM categorias";
        $busca = $banco->query($q);
        while ($obj = $busca->fetch_object()) {
            $_SESSION["listaCategoria"][] = "<li>$obj->categoria</li>";
        }
    }

    if ($_GET['lista'] === 'usuarios' || $_GET['lista'] === 'livros' || $_GET['lista'] === 'categorias') {
        loadLists($banco);

        if ($_GET['lista'] === 'usuarios') {
            echo implode("", $_SESSION["listaUsuarios"]);
        } elseif ($_GET['lista'] === 'livros') {
            echo implode("", $_SESSION["listaTitulos"]);
        } elseif ($_GET['lista'] === 'categorias') {
            echo implode("", $_SESSION["listaCategoria"]);
        }
    } else {
        echo 'Lista não encontrada';
    }
?>
