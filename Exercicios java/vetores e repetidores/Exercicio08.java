/*

8. Dados dois vetores A e B de 5 elementos cada, criar um vetor C que representa a 
concatenação de A e B, ou seja, C contém os elementos de A seguidos dos elementos 
de B.

*/


public class Exercicio08 {
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

        for (int i = 0; i <Limite; i++) {  
            
            VetC[i]=VetA[i];
            
        }

        for (int i = 0; i <Limite; i++) {  
            
            VetC[i+Limite]=VetB[i];
            
        }

        Prompt.separador();

        for (int i = 0; i < VetC.length; i++) {
            
            Prompt.imprimir(VetC[i]);

        }

    }
    
}