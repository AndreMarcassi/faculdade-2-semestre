/*

11.  Escreva um algoritmo que leia três valores inteiros distintos e escreva-os em 
ordem crescente. 

*/


public class Exercicio11 {
    public static void Executar(){

        boolean Var;

        int AUX;

        int[] Num = new int[3];

        for (int i = 0; i < 3; i++) {
            Num[i] = Prompt.lerInteiro("Digite um numero: ");
        }

        Prompt.imprimir("\nValores em orden digitada");

        for (int i = 0; i < 3; i++) {
            Prompt.Print(Num[i] + " ");
        }

        do {

            Var=false;

            for (int j = 0; j < 2; j++) {
                
                if (Num[j]>Num[j+1]) {
                    AUX=Num[j];
                    Num[j]=Num[j+1];
                    Num[j+1]=AUX;
                    Var=true;
                }
                else{
                    break;
                }

            }
            
        } while (Var==true);

        Prompt.imprimir("\n\nos valores em orden crescente");

        for (int i = 0; i < 3; i++) {
            Prompt.Print(Num[i] + " ");
        }

    }
}