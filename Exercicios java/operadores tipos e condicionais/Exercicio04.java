/*

4. Escreva um algoritmo que leia dois números e ao final mostre a soma, subtração, 
multiplicação e a divisão dos números lidos.

 */


public class Exercicio04 {
    public static void Executar(){
        
        int Num1 = Prompt.lerInteiro("Digite um numero:");

        int Num2 = Prompt.lerInteiro("Digite outro numero:");

        Prompt.imprimir("A soma dos 2 numero é: " + (Num1+Num2));
        Prompt.imprimir("A subtração dos 2 numero é: " + (Num1-Num2));
        Prompt.imprimir("A multiplicação dos 2 numero é: " + (Num1*Num2));
        Prompt.imprimir("A divisão dos 2 numero é: " + (Num1/Num2));

    }
    
}