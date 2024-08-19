/*

10. Escreva um algoritmo que leia um número de 1 a 5 e escreva-o por extenso. Caso 
o usuário digite um valor que não esteja neste intervalo, exibir a mensagem: “Número 
inválido!”.

*/


public class Exercicio10 {
    public static void Executar(){

    boolean Var;
        
    do {

        Var=false;

        int Num = Prompt.lerInteiro("Digite um numero de 1 a 5: ");

        switch (Num) {
            case 1:
                Prompt.imprimir("Um");
                break;

            case 2:
                Prompt.imprimir("Dois");
                break;

            case 3:
                Prompt.imprimir("Tres");
                break;

            case 4:
                Prompt.imprimir("Quatro");
                break;

            case 5:
                Prompt.imprimir("Cinco");
                break;
        
            default:
                Prompt.imprimir("O numero digitado nao corresponde as especificaçoes.");
                Var=true;
                break;
        }
        
        } while (Var==true);

    }
}