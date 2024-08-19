/*

3. Escreva um algoritmo que leia os valores de dois números inteiros distintos nas 
variáveis A e B e informe qual deles é o maior. Caso os números sejam iguais informar 
ao usuário que a sequência de números informados é inválida.

*/


public class Exercicio03 {
    public static void Executar(){

        int NumA, NumB;

        do {

            NumA = Prompt.lerInteiro("Digite um numero para atribuir ao A:");

            NumB = Prompt.lerInteiro("Digite um numero para atribuir ao B:");

            if (NumA==NumB) {
                Prompt.imprimir("A sequência de números informados é inválida");
            }
            else{
                Prompt.imprimir("A= " + NumA + "     " + "B= " + NumB + "\n");
            }
            
        } while (NumA==NumB);

        if (NumA > NumB) {
            Prompt.imprimir("O valor de A é maior que o valor de B");
        }

        else{
            Prompt.imprimir("O valor de B é maior que o valor de A");
        }

    }

}