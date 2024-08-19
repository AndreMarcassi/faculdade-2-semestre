<!--

6. A série de Fibonacci é formada pela sequência 1,1,2,3,5,8,13,21,34,55,...
Faça um programa capaz de gerar a série até o n-ésimo termo.

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
        <label for="Num">Digite quantos numero da sequencia de Fibonacci deseja ver</label>
        <input name="Num" id="Num" type="number">

        <button type="submit">Enviar</button>
    </form>

    <?php

    $Num = $_GET["Num"];
    $num1=0;
    $num2=1;
        
    for ($i=0; $i < $Num; $i++) { 
        $AUX=$num1+$num2;
        $Vet[$i]=$num1;
        $num1=$num2;
        $num2=$AUX;
    }

    for ($i=0; $i < $Num ; $i++) { 
        echo "{$Vet[$i]} , ";
    }
        
    ?>

</body>

</html>