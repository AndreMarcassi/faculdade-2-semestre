/*

4. Elabore um programa que leia um vetor de 5 números digitados pelo usuário e uma 
variável de um número n qualquer, depois mostre na tela o índice dos elementos que 
são inferiores a n.

*/


public class Exercicio04 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler: ");

        int[] Vet1 = new int[Limite];
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        int N = Prompt.lerInteiro("Digite um numero 'N' ");

        Prompt.separador();

        Prompt.imprimir("Os numeros menores que " + N + " são");

        for (int i = 0; i < Limite; i++) {
            
            if (Vet1[i]<N) {
                Prompt.imprimir(Vet1[i]);
            }

        }
    }
}