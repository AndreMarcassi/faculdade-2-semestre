/*

6.  Ler  uma  temperatura  em  graus  Celsius  e  apresentá-la  convertida  em  graus 
Fahrenheit. A fórmula de conversão é: F = (9 * C + 160) / 5 

*/


public class Exercicio06 {
    public static void Executar(){
        
    double C = Prompt.lerDecimal("Digite a temperatura em graus Celsius para ser convertifa para Fahrenheit: ");

    double F = (9*C+160)/5;

    Prompt.imprimir("a temperatura em Fahrenheit é: " + F);

    }
}