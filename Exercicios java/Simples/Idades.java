import java.util.Scanner;

/*
    Exercício 04 
        Desenvolver um algoritmo para ler o valor inteiro da idade de uma pessoa e imprimir uma das mensagens: 
        se idade <= 13: Criança, se idade > 13 e <= 18: Adolescente, se idade > 18 e <= 60: Adulto e se idade > 60: 
        Idoso. 
*/

public class Idades {
    public static void main(String[] args){

        Scanner imp = new Scanner(System.in);

        System.out.println("Digite a sua idade: ");
        int Idade = imp.nextInt();

        if(Idade<=13){
            System.out.println("Criança");
        }

        else if ((Idade>13)&&(Idade<=18)){
            System.out.println("Adolescente");
        }

        else if ((Idade>18)&&(Idade<=60)){
            System.out.println("Adulto");
        }

        else{
            System.out.println("Idoso");
        }

        imp.close();

    }

}