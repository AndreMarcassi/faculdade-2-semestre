/*

13. Escreva um algoritmo que leia valores REAIS nas variáveis A e B e o tipo de 
operador em outra variável do tipo CARACTERE. Imprima o resultado da operação 
de A por B se o operador aritmético for válido; caso contrário deve ser impresso uma 
mensagem de operador não definido. Tratar erro de divisão por zero.

*/


public class Exercicio13 {
    public static void Executar(){

    double Resultado = 0.0;
        
    double A = Prompt.lerDecimal("Digite o valor de A: ");
    double B = Prompt.lerDecimal("Digite o valor de B: ");
    
    char C = Prompt.lerChar("Digite um operador matematico: ");

    switch (C) {
            case '+':
                Resultado = A + B;
                break;
            case '-':
                Resultado = A - B;
                break;
            case '*':
                Resultado = A * B;
                break;
            case '/':
                if (B != 0) {
                    Resultado = A / B;
                }
                break;
            default: 
                Prompt.imprimir("O operador informado é invalido.");
        }

        Prompt.imprimir("O resultado da conta " + A  + C + B + " é " + Resultado);

    }
}