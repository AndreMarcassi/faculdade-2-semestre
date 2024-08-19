/*

16. Elabore um algoritmo que receba três notas de um aluno e retorne a sua média 
aritmética. Exemplo: nota1 = 10.0, nota2 = 5.5, nota3 = 8.0. Média: 7.83

*/


import java.text.DecimalFormat;

public class Exercicio16 {
    public static void Executar(){

        double Nota1 = Prompt.lerDecimal("Digite a nota da primeira nota");
        double Nota2 = Prompt.lerDecimal("Digite a nota da segunda nota");
        double Nota3 = Prompt.lerDecimal("Digite a nota da terceira nota");

        double Media = (Nota1+Nota2+Nota3)/3;

        DecimalFormat df = new DecimalFormat("#.##");
        String mediaFormatada = df.format(Media);

        Prompt.imprimir("A media do aluno é " + mediaFormatada);
        
    }
}