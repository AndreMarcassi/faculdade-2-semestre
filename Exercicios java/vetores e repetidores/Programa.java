public class Programa {
    public static void main(String[] args) {

        boolean Var1, Var2, Var3;

        do {

            Var1=false;

            do {

                Var2=false;
    
                int Num = Prompt.lerInteiro("Digite o número do exercício que deseja abrir:");
    
                switch (Num) {
    
                    case 1:
                        Exercicio01.Executar();
                        break;
    
                    case 2:
                        Exercicio02.Executar();
                        break;
    
                    case 3:
                        Exercicio03.Executar();
                        break;
    
                    case 4:
                        Exercicio04.Executar();
                        break;
    
                    case 5:
                        Exercicio05.Executar();
                        break;
    
                    case 6:
                        Exercicio06.Executar();
                        break;
    
                    case 7:
                        Exercicio07.Executar();
                        break;
    
                    case 8:
                        Exercicio08.Executar();
                        break;
    
                    case 9:
                        Exercicio09.Executar();
                        break;
    
                    case 10:
                        Exercicio10.Executar();
                        break;
    
                    case 11:
                        Exercicio11.Executar();
                        break;
    
                    case 12:
                        Exercicio12.Executar();
                        break;
    
                    case 13:
                        Exercicio13.Executar();
                        break;
    
                    case 14:
                        Exercicio14.Executar();
                        break;
    
                    case 15:
                        Exercicio15.Executar();
                        break;
                
                        default:
                            Prompt.imprimir("Numero digitado nao corresponde a um numero de exercicio:");
                            Var1=true;
                            break;
                }
    
            } while (Var2==true);

            Prompt.separador();

            do {

                Var3=false;

                Prompt.imprimir("Deseja executar outro exercico?");
                char Veri = Prompt.lerChar("     SIM = S       NÃO = N     ");
            
                switch (Veri) {
                    case 'S', 's':
                        Var1=true;
                        break;

                    case 'N', 'n':
                        Var1=false;
                        break;

                    default:
                        Prompt.imprimir("-----ERRO-----");
                        Var3=true;
                        break;
                    }
            } while (Var3==true);
        } while (Var1==true);
    }
} 