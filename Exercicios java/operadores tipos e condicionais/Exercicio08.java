/*

8. Escreva um algoritmo que leia um número e mostre uma mensagem caso este 
número seja maior ou igual a 50, outra se ele for menor que 50. 

*/


public class Exercicio08 {
    public static void Executar(){
        
        int Num = Prompt.lerInteiro("Digite um numero: ");

        if (Num>=50) {
            Prompt.imprimir("numero digitado é maior ou igual a 50.");
        }
        else{
            Prompt.imprimir("numero maior que 50");
        }

    }
}