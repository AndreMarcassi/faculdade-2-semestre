import java.util.Scanner;

/*
    Exercício 02 
        Crie um algoritmo que permita fazer três conversões monetárias.
        O algoritmo deve receber o valor em real (R$) e apresentar os valores convertidos em:

            1. Dólar (1 dólar = 5,17 reais) 
            2. Euro (1 euro = 6,14 reais) 
            3. Peso argentino (1 peso argentino = 0,05 reais)
*/

public class Conversao {

    public static void main(String[] args){

        Scanner imp = new Scanner(System.in);

        System.out.println("Digite um valor em real para converter para Dólar, Euro e Peso argentino: ");
        float Real = imp.nextInt();

        /*Dolar = (Real*5,17);
        Euro = (Real*6,14);
        Peso=(Real*0,05);*/

        System.out.printf("Valor em Dólar é $%.2f\n", (Real/5.17));
        System.out.printf("Valor em Euro é $%.2f\n", (Real/6.14));
        System.out.printf("Valor em Peso argentino é $%.2f\n", (Real/0.05));

        imp.close();

    }

}