/*

10. Crie um programa que leia um vetor A de 5 posições e, ao final da leitura, copie 
os elementos de A em B de forma invertida. Ou seja, o primeiro elemento de A é o 
último elemento de B, o segundo elemento de A é o penúltimo elemento de B, e assim 
por diante.

*/


public class Exercicio10 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler.");

        int[] VetA = new int[Limite];
        int[] VetB = new int[Limite];
        
        for (int i = 0; i < Limite; i++) {

            VetA[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        for (int i = 0, j=Limite-1; i<Limite; i++, j--) {

            VetB[j] = VetA[i];
            
        }

        Prompt.separador();

        for (int i = 0; i < Limite; i++) {
            Prompt.imprimir(VetB[i]);
        }

    }
    
}