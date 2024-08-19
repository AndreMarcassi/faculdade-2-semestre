<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style.css">
    <title>Calculadora PHP</title>
</head>

<body class="flex">

    <?php
        session_start();

        //echo print_r($_POST);

        // Inicializa o histórico se ainda não estiver definido na sessão
        if (!isset($_SESSION['historico'])) {
            $_SESSION['historico'] = array();
        }

        // isset verifica se as variáveis existem

        if (isset($_POST['n1']) && isset($_POST['tipo']) && isset($_POST['n2'])) {
            $n1 = $_POST['n1'];
            $tipo = $_POST['tipo'];
            $n2 = $_POST['n2'];

            switch ($tipo) {
                case '+':
                    $resultado = $n1 + $n2;
                    break;
                case '-':
                    $resultado = $n1 - $n2;
                    break;
                case '/':
                    if ($n2 != 0) {
                        $resultado = $n1 / $n2;
                        break;
                    } else {
                        $erro = "Erro: divisão por zero!";
                        break;
                    }
                    break;
                case '*':
                    $resultado = $n1 * $n2;
                    break;
                case '^':
                    $resultado = pow($n1, $n2);
                    break;
                case '!':

                    function fatorial($n1) {
                        if ($n1 === 0) {
                            return 1;
                        } else {
                            return $n1 * fatorial($n1 - 1);
                        }
                    }

                    $resultado = fatorial($n1);
                    break;   
            }

            if (isset($resultado)) {
                $_SESSION['historico'][] = "$n1 $tipo $n2 = $resultado";
            } else {
                $_SESSION['historico'][] = "$erro";
            }

        }

        function imprimirResultado() {

            global $n1, $tipo, $n2, $resultado, $erro;
            
            if (isset($resultado)) {
                echo "$n1 $tipo $n2 = $resultado";
            } else {
                echo $erro;
            }
        }

        function funcaoSalvar(){

            $_SESSION['total'] = end($_SESSION['historico']);

        }
        
        function funcaoPuxar(){

            if(isset($_SESSION['total'])) {
                    echo $_SESSION['total'];
            } else {
                echo "Nenhum valor salvo ainda.";
            }

        }

        function funcaoApagar() {

            if (isset($_SESSION['historico'])) {
                unset($_SESSION['historico']);
            }

            if (isset($_SESSION['total'])) {
                unset($_SESSION['total']);
            }

        }

    ?>

    <div class="caixa flex">

        <div class="cabecalho flex">

            <h1 style="color: #fff;">Calculadora PHP</h1>

        </div>

        <div class="corpo flex">

            <form class="flex" method="POST">

                <input class="inpleft" type="number" name="n1">

                <select id="tipo" name="tipo">
                    <option selected value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                    ]<option value="^">^</option>
                    <option value="!">!</option>
                </select>

                <input class="inpright" type="number" name="n2">

                <span style="width: 65%;" class="flex inpleft"> 
            
                    <?php 
                    
                        imprimirResultado();
                        
                        if ($_SERVER["REQUEST_METHOD"] == "POST") {
                            if(isset($_POST['botao'])) {

                                switch ($_POST['botao']) {
                                    case 'salvar':
                                        funcaoSalvar();
                                        break;
                                    case 'puxar':
                                        funcaoPuxar();
                                        break;
                                    case 'apagar':
                                        funcaoApagar();
                                        break;
                                }
                            }
                        }

                    ?> 
                    
                </span>

                <input style="width: 20%;" class="inpright" type="submit" name="calcular" value="submit">

            </form>

        </div>

        <form method="post" class="lala flex" style="justify-content: space-around;">

            <button type="submit" name="botao" value="salvar">Salvar</button>

            <button type="submit" name="botao" value="puxar">Puxar</button>

            <button type="submit" name="botao" value="apagar">Apagar Memória</button>

        </form>

        <div class="historico flex">

            <div class="historico-cabecalho flex">

                <h2>Histórico de Operações</h2>

            </div>

            <div class="historico-corpo flex">

                <ul>
                    <?php

                        if (isset($_SESSION['historico'])) {
                            foreach ($_SESSION['historico'] as $operacao) {
                                echo "<li>$operacao</li>";
                            }
                        }

                    ?>
                </ul>

            </div>

        </div>

    </div>

</body>

<script>
    // Função para rolar a barra de rolagem para baixo automaticamente
    function scrollDown() {
        var historicoCorpo = document.querySelector('.historico-corpo');
        historicoCorpo.scrollTop = historicoCorpo.scrollHeight;
    }

    // Chame a função scrollDown() sempre que houver uma alteração no histórico
    scrollDown();
</script>   

</html>