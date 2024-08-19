/*

7. Faça um programa que leia dois vetores de 5 elementos cada e verifique se eles 
são iguais ou não. Para serem iguais, todos os elementos dos dois vetores devem 
coincidir

*/


public class Exercicio07 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler.");

        int[] Vet1 = new int[Limite];
        int[] Vet2 = new int[Limite];

        int Diferente=0;
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero para o veto 1: ");
            
        }

        for (int i = 0; i < Limite; i++) {

            Vet2[i] = Prompt.lerInteiro("Digite um numero para o veto 2: ");
            
        }

        for (int i = 0; i < Limite; i++) {

            if (Vet1[i]!=Vet2[i]) {
                Diferente++;
            }
            
        }

        Prompt.separador();

        if (Diferente==0) {
            Prompt.imprimir("Os 2 vetores sao iguais");
        }
        else{
            Prompt.imprimir("Os 2 vetores sao diferentes");
        }
    }  
}