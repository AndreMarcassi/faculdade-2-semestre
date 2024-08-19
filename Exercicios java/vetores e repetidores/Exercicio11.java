/*

11. Elabore um algoritmo que calcule o produto escalar entre dois vetores de inteiros 
de tamanho igual a 5. Exemplo: {0, 2, 4, 6, 8}, {1, 3, 5, 7, 9} = 0*1 + 2*3 + 4*5 + 6*7 + 
8*9 = 140 

*/


public class Exercicio11 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler.");

        int[] Vet1 = new int[Limite];
        int[] Vet2 = new int[Limite];
        int Total=0;

        Prompt.separador();

        Prompt.imprimir("numero para o 1° vetor");

        Prompt.separador();
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        Prompt.separador();

        Prompt.imprimir("numero para o 2° vetor");

        Prompt.separador();

        for (int i = 0; i < Limite; i++) {

            Vet2[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        for (int i = 0; i < Limite; i++) {

            Total += Vet1[i]*Vet2[i];
            
        }

        Prompt.separador();

        Prompt.imprimir("O total é de: " + Total);

    }
}