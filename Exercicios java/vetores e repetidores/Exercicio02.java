/*

2.  Escreva  um  algoritmo  que  leia  em  um  vetor  uma  sequência  finita  de  números 
digitados pelo usuário e, logo após, mostre o número de cada posição do vetor e se 
ele é positivo, negativo ou zero.

*/


public class Exercicio02 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quanto numeros voce deseja ler: ");

        int[] Vet1 = new int[Limite];

        String Veri;
        
        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero: ");
            
        }

        for (int i = 0; i < Limite; i++) {

            if (Vet1[i]>0) {
                Veri = "positivo";
            }

            else if (Vet1[i]<0) {
                Veri = "negativo";
            }

            else {
                Veri = "zero";
            }
            
            Prompt.imprimir(" o numero " + Vet1[i] + " esta dentro do vetor [" + i + "] e é " + Veri);

        }
    }
}