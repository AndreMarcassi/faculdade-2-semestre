<!--

7. Faça um programa que calcule o fatorial de um número inteiro fornecido pelo usuário. Ex.: 5!=5.4.3.2.1=120

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
        <label for="Num">Digite um numero para faber o fatorial dele</label>
        <input name="Num" id="Num" type="number">

        <button type="submit">Enviar</button>
    </form>

    <?php
        
        $Fator = $_GET["Num"];
        $Total = $Fator;

        for ($i=$Fator-1; $i > 1 ; $i--) { 
            
            $Total*=$i;
        }

        echo "<br>O total do fatorial de {$Fator} ! é {$Total}";
        
    ?>

</body>

</html>