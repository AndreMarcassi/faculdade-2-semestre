/*

5. Leia valores nas variáveis A e B, e efetue a troca dos valores de forma que o valor 
da variável A passe a ser o valor da variável B e o valor da variável B passe a ser o 
valor da variável A. Apresentar uma mensagem com o valor original de cada variável 
e outra com os valores trocados. 

*/


public class Exercicio05 {
    public static void Executar(){

        int NumA = Prompt.lerInteiro("Digite um numero para a variavel A:");

        int NumB = Prompt.lerInteiro("Digite um numero para a variavel B:");

        Prompt.imprimir("\nO valor original de A é: " + NumA);
        Prompt.imprimir("O valor original de B é: " + NumB);

        int AUX = NumB;
        NumB=NumA;
        NumA=AUX;

        Prompt.imprimir("\nO valor de A é: " + NumA);
        Prompt.imprimir("O valor de B é: " + NumB);
        
    }
}