package br.edu.up.View;

import br.edu.up.controllers.Controles;
import br.edu.up.models.Segurado;
import br.edu.up.models.SeguroAutomovel;
import br.edu.up.models.SeguroVida;
import br.edu.up.utils.Prompt;

public class Tela {

    Controles controle = new Controles();
    Segurado segurado = new Segurado();
    private boolean var;
    private String tipo;
    private boolean possuiCarroReserva;
    private boolean coberturaVidros;
    private boolean cobreDoenca;
    private boolean cobreAcidente;

    public void menu(){

        Prompt.separador();
        Prompt.imprimir("1 - Inserir Seguro");
        Prompt.imprimir("2 - Localizar Seguro");
        Prompt.imprimir("3 - Excluir Seguro");
        Prompt.imprimir("4 - Excluir todos os seguros");
        Prompt.imprimir("5 - Listar todos os Seguros");
        Prompt.imprimir("6 - Ver Quantidade de Seguros");
        Prompt.imprimir("7 - Sair");
        Prompt.separador();

        int num = Prompt.lerInteiro();

        switch (num) {
            case 1:
                addseguro();
                break;

            case 2:
                localizarSeguro();
                break;
            
            case 3:
                excluirSeguro();
                break;
                
            case 4:
                excluirTodos();
                break;
                
            case 5:
                listarTodos();
                break;

            case 6:
                verQuantidade();
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

    public void addseguro(){

        String nome = Prompt.lerLinha("Digite o nome");
        String rg = Prompt.lerLinha("Digite o RG");
        String cpf = Prompt.lerLinha("Digite o CPF");
        String telefone = Prompt.lerLinha("Digite o telefone");
        String endereco = Prompt.lerLinha("Digite o endereço");
        String cep = Prompt.lerLinha("Digite o CEP");
        String cidade = Prompt.lerLinha("Digite a cidade");
 
        Segurado segurado = new Segurado(nome, rg, cpf, telefone, endereco, cep, cidade);

        do {

            var=false;

            Prompt.imprimir("A - Automovel  /  V - Vida");
            tipo = Prompt.lerLinha("Digite qual o tipo de seguro");
    
            switch (tipo.toLowerCase()) {
                case "a":
                    double valorFranquia = Prompt.lerDecimal("Digite o valor da franquia");
                    tipo = Prompt.lerLinha("O seguro possui carro reserva?");

                        possuiCarroReserva=controle.verificador(tipo);

                    tipo = Prompt.lerLinha("O seguro possui cobertura para vidros?");

                        coberturaVidros = controle.verificador(tipo);

                    controle.addSeguro(new SeguroAutomovel(valorFranquia, possuiCarroReserva, coberturaVidros));
                    break;
    
                case "v":

                    tipo = Prompt.lerLinha("O seguro cobre doença?");

                        cobreDoenca = controle.verificador(tipo);

                    tipo = Prompt.lerLinha("O seguro cobre acidente?");

                        coberturaVidros = controle.verificador(tipo);

                    controle.addSeguro(new SeguroVida(cobreDoenca, cobreAcidente));
                    break;
            
                default:
                var=true;
                    break;
            }
            
        } while (var==true);


    }

    public void localizarSeguro(){

        String apolice = Prompt.lerLinha("Digite a apolice");

        Prompt.imprimir(controle.localizar(apolice));

    }

    public void excluirSeguro(){

        String apolice = Prompt.lerLinha("Digite a apolice");

        controle.excluirSeguro(apolice);

    }

    public void excluirTodos(){

        Prompt.imprimir("N - não  /  S - sim");
        String Veri = Prompt.lerLinha("Deseja realmente excluir todos os seguros");

        switch (Veri.toLowerCase()) {
            case "s":
                controle.excluirTodos();
                Prompt.imprimir("Todos os seguros foram deletados");
                break;
        
            default:
                break;
        }

    }

    public void listarTodos(){
       
        Prompt.imprimir(controle.listarSeguros());

    }

    public void verQuantidade(){
        Prompt.imprimir("Existem " + controle.verQuantidade() + " seguros.");
    }
    
}