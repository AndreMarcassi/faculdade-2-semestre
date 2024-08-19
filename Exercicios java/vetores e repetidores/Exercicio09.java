/*

9. Elabore um programa que leia os vetores A e B de 5 elementos e gere um vetor C 
de acordo com as seguintes regras: 
 
a. Os elementos das posições pares de C são os elementos das posições pares de A; 
b. Os elementos das posições ímpares de C são os elementos das posições ímpares de B;

*/


public class Exercicio09 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler.");

        int[] VetA = new int[Limite];
        int[] VetB = new int[Limite];
        int[] VetC = new int[2*Limite];

        Prompt.imprimir("1° vetor");
        
        for (int i = 0; i < Limite; i++) {

            VetA[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        Prompt.imprimir("2° vetor");

        for (int i = 0; i < Limite; i++) {

            VetB[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        for (int i = 0; i < 2*Limite; i++) {

            VetC[i] = VetA[i];
            VetC[i+1] = VetB[i];
            
        }

        for (int i = 0; i < 2*Limite; i++) {

            Prompt.imprimir(VetC[i]);
            
        }
    }
}