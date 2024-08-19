/*

2.  Escreva  um  algoritmo  que  leia  dois  números  digitados  pelo  usuário  e  exiba  o 
resultado da sua soma. 

*/


public class Exercicio02 {
    public static void Executar(){

        int Num1 = Prompt.lerInteiro("Digite um numero:");

        int Num2 = Prompt.lerInteiro("Digite outro numero:");

        Prompt.imprimir(Num1+Num2);

    }
    
}