package br.edu.up.View;

import br.edu.up.controllers.Agenda;
import br.edu.up.utils.Prompt;

public class Tela {

    Agenda agenda = new Agenda();
    private boolean var;
    private int codigo;

    public void menu(){

        Prompt.separador();
        Prompt.imprimir("1 - Inserir um contato pessoal");
        Prompt.imprimir("2 - Inserir um contato comercial");
        Prompt.imprimir("3 - Excluir um contado");
        Prompt.imprimir("4 - Consultar um contato");
        Prompt.imprimir("5 - Listar todos os contatos");
        Prompt.separador();

        int num = Prompt.lerInteiro("");

        switch (num) {
            case 1:
                cadastrarPessoal();
                break;

            case 2:
                cadastrarComercial();
                break;

            case 3:
                Remover();
                break;

            case 4:
                verContato();
                break;

            case 5:
                mostrarContatos();
                break;
        
            default:
                break;
        }

        retorno();

    }

    public void retorno(){

        Prompt.separador();
        Prompt.imprimir("1 - Voltar");
        Prompt.imprimir("2 - Sair");
        Prompt.separador();

        int num = Prompt.lerInteiro("");

        switch (num) {
            case 1:
                menu();
                break;

            default:
                break;

        }
    }

    public void cadastrarPessoal(){
        
        do {

            var=false;

            codigo = Prompt.lerInteiro("Digite o codigo que deseja cadastrar");

            if (agenda.verificarContato(codigo)==true) {
                Prompt.imprimir("O codigo informado ja esta cadastrado");
                var=true;
            }

        } while (var==true);

        String nome = Prompt.lerLinha("Digite o nome do contato");
        String telefone = Prompt.lerLinha("Digite o telefone do contato");
        String aniversario = Prompt.lerLinha("Digite a data de aniversario");

        agenda.addPessoal(codigo, nome, telefone, aniversario);

        Prompt.imprimir("Numero cadastrado");
        Prompt.separador();
    }

    public void cadastrarComercial(){

        do {

            var=false;

            codigo = Prompt.lerInteiro("Digite o codigo que deseja cadastrar");

            if (agenda.verificarContato(codigo)==true) {
                Prompt.imprimir("O codigo informado ja esta cadastrado");
            }

        } while (var==true);

        String nome = Prompt.lerLinha("Digite o nome do contato");
        String telefone = Prompt.lerLinha("Digite o telefone do contato");
        String cnpJ = Prompt.lerLinha("Digite o cnpJ da empresa");

        agenda.addComercial(codigo, nome, telefone, cnpJ);

        Prompt.imprimir("Numero cadastrado");
        Prompt.separador();
    }

    public void Remover(){

        do {

            var=false;

            codigo = Prompt.lerInteiro("Digite o codigo do contato que deseja remover");

            if (agenda.verificarContato(codigo)==true) {
                agenda.removerContato(codigo);
            }
            else{
                Prompt.imprimir("Codigo não encontrado");
                Prompt.separador();
                var=true;
            }

        } while (var==true);

        Prompt.imprimir("Contato removido com sucesso");

    }

    public void verContato(){

        codigo = Prompt.lerInteiro("Digite o codigo do contato que deseja visualizar");

            if (agenda.verificarContato(codigo)==true) {
                Prompt.imprimir(agenda.listaContato(codigo));
            }
            else{
                Prompt.imprimir("Codigo não encontrado");
            }
        
    }

    public void mostrarContatos(){
        Prompt.imprimir(agenda.listarContatos());
    }
    
}