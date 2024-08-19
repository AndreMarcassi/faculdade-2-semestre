<!--

5. Desenvolva um gerador de tabuada, capaz de gerar a tabuada de qualquer número inteiro entre 1 a 10.
O usuário deve informar de qual numero ele deseja ver a tabuada. A saída deve ser conforme o exemplo abaixo:

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
        <label for="Num">Qual tabuada voce deseja ver.</label>
        <input name="Num" id="Num" type="number">

        <button type="submit">Enviar</button>
    </form>

    <?php

    $Base = $_GET["Num"];
        
    for ($i=1; $i <= 10; $i++) { 
        $Total=$i*$Base;
        echo "<br> {$Base} x {$i} = {$Total}";
    }
        
    ?>

</body>

</html>