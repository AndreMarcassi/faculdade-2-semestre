package br.edu.up.View;

import br.edu.up.controllers.Controles;
import br.edu.up.models.Aeronave;
import br.edu.up.models.Comandante;
import br.edu.up.models.Comissario;
import br.edu.up.models.Passageiro;
import br.edu.up.models.Tripulante;
import br.edu.up.utils.Prompt;

public class Tela {

    Controles controle = new Controles();
    private boolean var;
    private int rg;
    private String nome;

    public void menu(){

        Prompt.separador();
        Prompt.imprimir("1 - Cadastrar voo");
        Prompt.imprimir("2 - Mostrar voos disponiveis");
        Prompt.imprimir("3 - Registrar Passageiro/Tripulação");
        Prompt.imprimir("4 - Consultar Informações de Passageiro/Tripulação");
        Prompt.separador();

        int num = Prompt.lerInteiro();

        switch (num) {
            case 1:
                cadastrar();
                break;

            case 2:
                voosCadastrados();
                break;

            case 3:
                registrar();
                break;

            case 4:
                consultar();
                break;
        
            default:
                break;
        }

        retorno();

    }

    public void retorno(){
        Prompt.imprimir("1 - Voltar");
        Prompt.imprimir("2 - Sair");

        int num = Prompt.lerInteiro();

        switch (num) {
            case 1:
                menu();
                break;
        
            default:
                break;
        }
    }

    public void cadastrar(){

        int codigo = Prompt.lerInteiro("Digite o codigo do voo");
        String tipo = Prompt.lerLinha("Digite o tipo da aeronave");
        int assentos = Prompt.lerInteiro("Digite a quantidade de assentos da aeronave");
        String localSaida = Prompt.lerLinha("Digite o local de saida");
        String localChegada = Prompt.lerLinha("Digite o destino da aeronave");

        controle.novoVoo(new Aeronave(codigo, tipo, assentos, localSaida, localChegada));

    }

    public void voosCadastrados(){

        Prompt.imprimir(controle.voosCadastrados());

    }

    public void registrar(){
        Prompt.imprimir("P - passageiro  /  T - tripulação");

        do {
            var=false;

            String tipo = Prompt.lerLinha("Qual deseja cadastrar");

            switch (tipo.toLowerCase()) {
                case "p":
                nome = Prompt.lerLinha("Digite o nome do passageiro");
                rg = Prompt.lerInteiro("Digite o rg do passageiro");
                String passagem = Prompt.lerLinha("Digite a passagem");
                int idBagagem = Prompt.lerInteiro("Digite o codigo da bagagem");

                controle.novoPassagero(new Passageiro(nome, rg, passagem, idBagagem));
                        
                    break;

                case "t":

                    Prompt.imprimir("Comandante  /  Comissario");

                    String tipoT = Prompt.lerLinha("Qual deseja cadastrar");

                    do {

                        var=false;

                        nome = Prompt.lerLinha("Digite o nome do tripulante");
                        rg = Prompt.lerInteiro("Digite o rg do Comandante");
                        int identificacao = Prompt.lerInteiro("Digite a identificacao do Comandante");
                        int matricula = Prompt.lerInteiro("Digite a matricula do Comandante");

                        new Tripulante(nome, rg, identificacao, matricula);

                        switch (tipoT.toLowerCase()) {
                            
                            case "comandante":  
                                Double horasDeVoo = Prompt.lerDecimal("Digite as horas de voo do comandante");  
                                controle.novoComandante(new Comandante(nome, rg, identificacao, matricula, horasDeVoo));
                                break;
    
                            case "comissario":
                                String idiomas = Prompt.lerLinha("Digite as linguas falados pelo comissario");
                                controle.novoComissario(new Comissario(nome, rg, identificacao, matricula, idiomas));
                                break;
                        
                            default:
                                Prompt.imprimir("tipo não encontrado digite novamnete");
                                var=true;
                                break;
                        }
                        
                    } while (var==true);

                    break;
                
                default:
                    Prompt.imprimir("tipo não encontrado digite novamnete");
                    var=true;
                    break;
            }
                
        } while (var==true);

    }

    public void consultar(){

        Prompt.imprimir("P - passageiro  /  T - tripulante");

        String tipo = Prompt.lerLinha("Digite quem deseja consultar");
        int rg = Prompt.lerInteiro("Digite o RG para consultar");

        Prompt.imprimir(controle.consultar(tipo, rg));

    }
    
}