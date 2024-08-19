/*

7. Escreva um algoritmo que leia um número e diga, através de uma mensagem, se 
este número está no intervalo entre 100 e 200. Caso o número esteja fora do intervalo 
o usuário também deverá ser informado

*/


public class Exercicio07 {
    public static void Executar(){

        int Num = Prompt.lerInteiro("Digite um numero: ");
        
        if (Num>=100 && Num<=200) {
            Prompt.imprimir("O numero digitado está no intervalo entre 100 e 200");
        }

        else{
            if (Num<100) {
                Prompt.imprimir("O numero digitado é menor do que 100");
            }

            else{
                Prompt.imprimir("O numero digitado é maior do que 200");
            }
        }
    }
}