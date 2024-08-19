/*

9. Leia dois números nas variáveis A e B e identifique se os valores são iguais ou 
diferentes. Caso eles sejam iguais imprima uma mensagem dizendo que são iguais. 
Caso sejam diferentes, informe que são diferentes e qual número é o maior.

*/


public class Exercicio09 {
    public static void Executar(){
        
        double A = Prompt.lerDecimal("Digite um numero para ser comparado");

        double B = Prompt.lerDecimal("Digite outro numero para ser comparado");

        if (A==B) {
            Prompt.imprimir("Os numeros digitados sao iguais.");
        }
        else{
            if (A>B) {
                Prompt.imprimir("O Valor de A (" + A + ") é maior que o valor de B (" + B + ").");
            }
            else{
                Prompt.imprimir("O Valor de B (" + B + ") é maior que o valor de A (" + A + ").");
            }
        }



    }
}