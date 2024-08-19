/*

13. Elabore um algoritmo que receba um número n e retorne um vetor com os n 
primeiros termos da sequência de Fibonacci. Exemplo: n = 8, vetor = {1, 1, 2, 3, 5, 8, 
13, 21}.

*/


public class Exercicio13 {
    public static void Executar(){
        
        int Limite = Prompt.lerInteiro("Digite quantos numeros da sequencia de Fibonacci voce quer ver.");

        int[] Vet1 = new int[Limite];

        int A=0, B=1, C;
        
        for (int i = 0; i < Limite; i++) {

            C=A+B;
            Vet1[i]=A;
            A=B;
            B=C;

        }

        Prompt.separador();

        for (int i = 0; i < Limite; i++) {
            Prompt.Print(Vet1[i] + ", ");
        }

    }
}