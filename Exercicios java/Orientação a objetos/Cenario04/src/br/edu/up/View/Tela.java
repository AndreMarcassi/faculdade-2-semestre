package br.edu.up.View;

import br.edu.up.controllers.Estacionamento;
import br.edu.up.models.Veiculos;
import br.edu.up.utils.Prompt;

public class Tela {

    Estacionamento estacionamento = new Estacionamento();
    int total;

    public void TelaPrincipal(){

        Prompt.separador();
        Prompt.imprimir("Menu de opções");
        Prompt.imprimir("1 - Verificar vagas");
        Prompt.imprimir("2 - Cadastrar Entrada");
        Prompt.imprimir("3 - Cadastrar Saida");
        Prompt.imprimir("4 - Mostrar vagas");
        Prompt.imprimir("5 - Relatorio");
        Prompt.imprimir("Digite qualquer outro numero para finalizar o programa");
        Prompt.separador();

        int num = Prompt.lerInteiro("");

        switch (num) {
            case 1:
                VerificarVagas();
                break;
            case 2:
                Entrada();
                break;
            case 3:
                Saida();
                break;
            case 4:
                vagas();
                break;
            case 5:
                RelatorioDiario();
                break;
            default:
                break;
        }

        Retorno();

    }

    public void Retorno(){

        Prompt.separador();
        Prompt.imprimir("1 - Voltar");
        Prompt.imprimir("2 - Sair");
        Prompt.separador();

        int num = Prompt.lerInteiro("");

        switch (num) {
            case 1:
                TelaPrincipal();
                break;
            default:
                break;
        }

    }

    public void VerificarVagas(){
        Prompt.imprimir("O estacionamneto " + estacionamento.verificar());
    }

    public void Entrada(){
        Prompt.separador();
        Prompt.imprimir("M = manha / T - tarde / N - noite");
        String horario = Prompt.lerLinha("Digite o periodo de entrada");
        Prompt.separador();
        String modelo = Prompt.lerLinha("Digite o modelo do carro");
        String placa = Prompt.lerLinha("Digite a placa do carro");
        String cor = Prompt.lerLinha("Digite a cor do carro");

        Veiculos veiculo = new Veiculos(modelo, placa, cor);
        estacionamento.veiculoEntrada(placa, horario);
    }

    public void Saida(){
        Prompt.separador();
        Prompt.imprimir("M = manha / T - tarde / N - noite");
        String horario = Prompt.lerLinha("Digite o periodo de saida");
        Prompt.separador();
        String placa = Prompt.lerLinha("Digite a placa para buscar o carro");

        estacionamento.veiculoSaida(placa, horario);
    }

    public void RelatorioDiario(){

        Prompt.separador();
        Prompt.imprimir("O valor total recebido foi de " + estacionamento.getTotal());
        Prompt.separador();

    }

    public void vagas(){

        total=estacionamento.Livres();

        if (total!=0) {
            Prompt.imprimir("O total de vagas disponiveis é " + total);
        }else{
            Prompt.imprimir("Não a vagas disponiveis");
        }

    }

}