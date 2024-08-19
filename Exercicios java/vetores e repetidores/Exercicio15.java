/*

15. Elabore um algoritmo que leia 5 números do teclado e preencha um vetor de 
acordo com a seguinte regra: com exceção do 1º número, só é permitido armazenar 
um número se ele for maior que o anterior. Ex.: se o primeiro valor lido for 5, o próximo 
valor lido só poderá ser maior que 5

*/


public class Exercicio15 {
    public static void Executar(){
        
        int J=0;

        boolean Var;

        int Limite = Prompt.lerInteiro("Digite quantos numeros deseja ler.");

        int[] Vet1 = new int[Limite];

        Vet1[0] = Prompt.lerInteiro("Digite o primeiro numero:");
        
        do {

            Var=false;

            int Num = Prompt.lerInteiro("Digite um numero");

            if (Num>Vet1[J]) {  

                J++;
                Vet1[J]=Num;


                if (J == (Limite-1)) {
                    Var = false;
                }

                else{
                    Var=true;
                }
                
            } 

            else {
                Prompt.Print("O numero digitado é menor do que o anterior, ");
                Var=true;
            }

        } while (Var==true);

        Prompt.separador();

        for (int i = 0; i < Limite; i++) {
            Prompt.Print(Vet1[i] + ", ");
        }

    }
}