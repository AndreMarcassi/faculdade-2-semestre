/*

5. Elabore um programa que leia 5 números do teclado e os armazene em um vetor. 
Em seguida, leia um número n qualquer e apresente na tela a quantidade de vezes 
que o número n aparece no vetor.

*/


public class Exercicio05 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler: ");

        int[] Vet1 = new int[Limite];

        int Total=0;
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        int N = Prompt.lerInteiro("Digite um numero para saber quantas vezes ele aparece: ");

        Prompt.separador();

        for (int i = 0; i < Limite; i++) {
            
            if (Vet1[i]==N) {
                Total++;
            }

        }

        Prompt.imprimir("O total de vezes que o numero " + N + " aparece é " + Total);

    }
}