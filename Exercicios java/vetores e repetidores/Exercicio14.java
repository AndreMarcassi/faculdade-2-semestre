/*

14. Faça um programa que leia um vetor de 5 elementos e, após a leitura, posicione 
o maior elemento na última posição do vetor. Nenhum número do vetor pode ser 
apagado ou duplicado. Apresente o vetor atualizado na tela.

*/


public class Exercicio14 {
    public static void Executar(){

        boolean Ver;

        int AUX;

        int Limite = Prompt.lerInteiro("Digite quantos Numeros deseja ordenar");

        int[] Vet1 = new int[Limite];

        for (int i = 0; i < Limite; i++) {

            Vet1[i] = Prompt.lerInteiro("Digite um numero");
            
        }

        do {

            Ver=false;

            for (int i = 0; i < Limite-1; i++) {

                if (Vet1[i]>Vet1[i+1]) {

                    AUX=Vet1[i];
                    Vet1[i]=Vet1[i+1];
                    Vet1[i+1]=AUX;
                    Ver=true;
                    
                }
                
            }

            
        } while (Ver==true);

        Prompt.separador();

        Prompt.imprimir("Vetor ordenado em ordem crescente");


        for (int i = 0; i < Limite; i++) {

            Prompt.Print(Vet1[i] + ", ");
            
        }

    }
    
}