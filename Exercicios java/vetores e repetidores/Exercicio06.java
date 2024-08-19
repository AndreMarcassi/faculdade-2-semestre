/*

6. Elabore um programa que leia um vetor com 5 notas de um aluno e um outro vetor 
com 5 pesos e calcule a média ponderada do aluno.  
Média ponderada = nota1 * peso1 + nota2 * peso2 + nota3 * peso3 
peso1 + peso2 + peso3 
 
Ex.: notas: 7.5, 9.2 pesos: 6, 4. Média ponderada: (7.5 * 6 + 9.2 * 4) / (6 + 4) 

*/


public class Exercicio06 {
    public static void Executar(){

        int Limite = Prompt.lerInteiro("Digite quantas notas voce que para fazer a media ponderada.");

        double[] Vet1 = new double[Limite];
        double[] Vet2 = new double[Limite];

        double Pond=0, Div=0;
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerDecimal("Digite uma nota:");

            Vet2[i] = Prompt.lerDecimal("Digite o peso da nota:");
            
        }

        for (int i = 0; i < Limite; i++) {

            Pond += (Vet1[i]*Vet2[i]);
            Div += Vet2[i];
            
        }

        Double Media = Pond/Div;

        Prompt.imprimir("A média ponderada do aluno é: " + Media);

    }
}