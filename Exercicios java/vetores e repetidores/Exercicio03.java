/*

3. Faça um programa que leia em um vetor uma sequência finita de números digitados 
pelo  usuário.  Crie  um  segundo  vetor  que  armazene  o  dobro  de  cada  número  do 
primeiro vetor e depois apresente os valores deste vetor.

*/


public class Exercicio03 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler: ");

        int[] Vet1 = new int[Limite];
        int[] Vet2 = new int[Limite];
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        for (int i = 0; i < Limite; i++) {
            
            Vet2[i] = 2*Vet1[i];

        }

        Prompt.separador();

        for (int i = 0; i < Limite; i++) {
            
            Prompt.imprimir(Vet2[i]);

        }
    }
}