<!--

3. Faça um programa que receba dois números inteiros e gere os números inteiros que estão no intervalo compreendido por eles.

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

        <label for="Num1">Digite um numero base</label>
        <input name="Num1" id="Num1" type="number">

        <label for="Num2">Digite um numero pra limitar a impreção</label>
        <input name="Num2" id="Num2" type="number">

        <button type="submit">Enviar</button>

    </form>

    <?php
        
        $Base = $_GET["Num1"];
        $Limite = $_GET["Num2"];

        echo "Os numeros presentes no intervalo entre {$Base}  e  {$Limite} são: ";

        for ($i=$Base+1; $i < $Limite; $i++) { 
            echo $i . ", ";
        }
        
    ?>

</body>

</html>