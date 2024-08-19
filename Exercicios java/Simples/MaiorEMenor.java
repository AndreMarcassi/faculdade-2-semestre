import java.util.Scanner;

/*
    Exercício 03 
        Receber dois números inteiros e informar qual valor lido é o menor e qual é o maior.
*/

public class MaiorEMenor {
    public static void main(String[] args){

        Scanner imp = new Scanner(System.in);

        System.out.println("Escreva dois numeros para saber qual é maior e qual é menor: ");

        System.out.println("Primeiro numero: ");
        int Primeiro = imp.nextInt();
        
        System.out.println("Segundo numero: ");
        int Segundo = imp.nextInt();

        if(Primeiro>Segundo){
            System.out.println("O numero " + Primeiro + " é maior que o numero " + Segundo);
        }

        else{
            System.out.println("O numero " + Segundo + " é maior que o numero " + Primeiro);
        }

        imp.close();

    }
}