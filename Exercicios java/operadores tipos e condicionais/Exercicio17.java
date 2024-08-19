/*

17. Elabore um algoritmo que receba três notas de um aluno os pesos referentes a 
cada nota e retorne a sua média ponderada. Veja o cálculo da média ponderada: 
Média ponderada = nota1 * peso1 + nota2 * peso2 + nota3 * peso3 
peso1 + peso2 + peso3 
 
Exemplo: nota1 = 10, nota2 = 5.5, nota3 = 8, peso1 = 5, peso2 = 3, peso3 = 2 
Média ponderada = 8.25

*/


import java.text.DecimalFormat;

public class Exercicio17 {
    public static void Executar(){
        
        double Nota1 = Prompt.lerDecimal("Digite a nota da primeira nota");
        double Nota2 = Prompt.lerDecimal("Digite a nota da segunda nota");
        double Nota3 = Prompt.lerDecimal("Digite a nota da terceira nota");

        int Peso1 = Prompt.lerInteiro("Digite o peso da primeira nota");
        int Peso2 = Prompt.lerInteiro("Digite o peso da segunda nota");
        int Peso3 = Prompt.lerInteiro("Digite o peso da terceira nota");

        double Media = ((Nota1*Peso1)+(Nota2*Peso2)+(Nota3*Peso3))/(Peso1+Peso2+Peso3);

        DecimalFormat df = new DecimalFormat("#.##");
        String mediaFormatada = df.format(Media);

        Prompt.imprimir("A media do aluno é " + mediaFormatada);

    }
}