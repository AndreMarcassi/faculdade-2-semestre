/*

12. Elabore um programa que leia um vetor de 12 elementos apresente na tela o 
produto dos elementos pares positivos (desconsiderar o zero). Exemplo: {0, 5, 8, 1, -
6, 4, -7, 9, 10, -14, 3, 12} = 8 * 4 * 10 * 12 = 3840

*/


public class Exercicio12 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler.");

        int[] Vet1 = new int[Limite];
        int[] Vet2 = new int[Limite];
        int Total=0, j=0;
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        for (int i = 0; i < Limite; i++) {

            if ((Vet1[i]%2)==0) {
                Vet2[j] = Vet1[i];
                j++;
            }
            
        }

        for (int i = 0; i < (j+1); i++) {

            Total *= Vet2[i];
            
        }

        Prompt.separador();

        Prompt.imprimir("O valor total é de: " + Total);

    }
    
}