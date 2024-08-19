/*

1. Construa um programa que leia em um vetor uma sequência de 5 números digitados 
pelo usuário, calcule a média destes valores em um outro vetor, e depois apresente 
na tela quais valores que são menores, iguais ou superiores à média.

*/


public class Exercicio01 {
    public static void Executar(){

        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler para fazer uma media.");

        int[] Vet1 = new int[Limite];

        int Total=0, Media;
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        for (int i = 0; i < Limite; i++) {

            Total += Vet1[i];
            
        }

        Media = Total/Limite;

        Prompt.separador();

        Prompt.imprimir("Media = " + Media);

        Prompt.separador();
        
        Prompt.imprimir("Os numeros acima da media são");

        for (int i = 0; i < Limite; i++) {
            
            if (Vet1[i]>Media) {
                Prompt.imprimir(Vet1[i]);
            }
        }
    }
}