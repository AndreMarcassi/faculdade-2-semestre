import java.util.Scanner;


/*
    Exercício 01 
        Escrever um algoritmo que receba a altura e a largura de um 
        retângulo e calcule a sua área.
*/

public class AreaDoRetangulo {

    public static void main(String[] args){

        Scanner imp = new Scanner(System.in);

        System.out.println("Digite a altura do retangulo: ");
        int Altura = imp.nextInt();

        System.out.println("Digite a largura do retangulo:");
        int Largura = imp.nextInt();

        System.out.println("A area do retangulo é: " + (Altura * Largura) + "m²");

        imp.close();

    }

}