/*

12.  Escreva  um  algoritmo  que  receba  o  número  do  mês  e  mostre  o  mês 
correspondente. Valide mês inválido.

*/


public class Exercicio12 {
    public static void Executar(){

        boolean Var;

        int Mes;

        do {
            Mes = Prompt.lerInteiro("Digite o numero referente a um mês:");

            if (Mes>=1&&Mes<=12) {
                Var=false;
            }
            else{
                Var=true;
            }

        } while (Var==true);
        
        switch (Mes) {
            case 1:
                Prompt.imprimir("Janeiro");
                break;

            case 2:
                Prompt.imprimir("Fevereiro");
                break;

            case 3:
                Prompt.imprimir("Março");
                break;

            case 4:
                Prompt.imprimir("Abril");
                break;

            case 5:
                Prompt.imprimir("Maio");
                break;

            case 6:
                Prompt.imprimir("Junho");
                break;

            case 7:
                Prompt.imprimir("Julho");
                break;

            case 8:
                Prompt.imprimir("Agosto");
                break;

            case 9:
                Prompt.imprimir("Setembro");
                break;

            case 10:
                Prompt.imprimir("Outubro");
                break;

            case 11:
                Prompt.imprimir("Novembro");
                break;

            case 12:
                Prompt.imprimir("Dezembro");
                break;

            default:
                break;
        }

    }
}