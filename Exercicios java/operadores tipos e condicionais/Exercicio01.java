/*

1.  Escreva  um  algoritmo  que  leia  um  número  digitado  pelo  usuário  e  mostre  a 
mensagem “Número maior do que 10!”, caso este número seja maior, ou “Número 
menor ou igual a 10!”, caso este número seja menor ou igual. 

 */


 public class Exercicio01 {
    public static void Executar(){

        int Num = Prompt.lerInteiro("Digite um numero:");

        if (Num>10) {
            Prompt.imprimir("Número maior do que 10");
        }
        else{
            Prompt.imprimir("Número menor ou igual a 10");
        }

    }
    
}