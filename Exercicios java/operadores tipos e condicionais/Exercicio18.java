/*

18. Elabore um algoritmo que receba três notas de um aluno e retorne a sua média 
harmônica.  
Média harmônica = 
3 
1 + 1 + 1 
nota1 nota2 nota3  
 
Exemplo: nota1 = 10, nota2 = 5.5, nota3 = 8 
Média: 7.37

*/

import java.text.DecimalFormat;

public class Exercicio18 {
    public static void Executar(){
        
        double Nota1 = Prompt.lerDecimal("Digite a nota da primeira nota");
        double Nota2 = Prompt.lerDecimal("Digite a nota da segunda nota");
        double Nota3 = Prompt.lerDecimal("Digite a nota da terceira nota");

        double Media =  3/((1/Nota1)+(1/Nota2)+(1/Nota3));

        DecimalFormat df = new DecimalFormat("#.##");
        String mediaFormatada = df.format(Media);

        Prompt.imprimir("A media do aluno é " + mediaFormatada);

    }
}