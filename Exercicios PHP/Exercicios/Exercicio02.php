<!--

2. Faça um programa que imprima na tela apenas os números impares entre 1 e 50.

-->


<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercicio</title>
</head>

<body>

    <form action="" method="GET">

        <label for="Num">Digite um numero pra limitar a impreção</label>
        <input name="Num" id="Num" type="number">

        <button type="submit">Enviar</button>

    </form>

    <?php
        
    $Limite = $_GET["Num"];

    echo "Numero pares: ";
        
    for ($i=0; $i <= $Limite; $i++) { 
        
        if ($i%2==0) {
            echo $i . ", ";
        }
    }

    echo "<br>Numero impares: ";
        
    for ($i=0; $i < $Limite; $i++) { 
        
        if ($i%2!=0) {
            echo $i . ", ";
        }
    }
        
    ?>

</body>

</html>