<!--

1. Faça um programa que imprima na tela os números de 1 a 20, um abaixo do outro.
Depois modifique o programa para que ele mostre os números um ao lado do outro.

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

    echo "Numero: ";
        
    for ($i=0; $i < $Limite; $i++) { 
        echo $i . ", ";
    }

    echo "<br><br>";

    for ($i=0; $i < $Limite; $i++) { 
        echo "Numero: {$i} <br>";
    }

    ?>

</body>

</html>