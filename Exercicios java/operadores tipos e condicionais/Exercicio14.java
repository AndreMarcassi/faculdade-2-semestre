/*

14.  A  expressão  an  =  a1  +  (n  –  1)  *  r  é  denominada  termo  geral  da  Progressão 
Aritmética (PA). Nesta fórmula, temos que an é o termo de ordem n (n-ésimo termo), 
r é a razão e a1 é o primeiro termo da Progressão Aritmética. Escreva um algoritmo 
que encontre o n-ésimo termo de uma progressão aritmética. Exemplo: a1 = 10, n = 
7, r = 3. Resultado: an = 28

*/


public class Exercicio14 {
    public static void Executar(){

        int A1 = Prompt.lerInteiro("Digite o primeiro numero da Progressão: ");

        int R = Prompt.lerInteiro("Digite a razão da Progressão");
        
        int N = Prompt.lerInteiro("Digite qual numero voce quer saber em uma PA (Progressão Aritmética)");

        int AN = A1 + ((N-1)*R);

        Prompt.imprimir("O " + N + "° numero da Progressão Aritmética é " + AN);

    }
}