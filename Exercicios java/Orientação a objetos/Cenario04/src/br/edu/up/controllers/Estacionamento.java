package br.edu.up.controllers;

public class Estacionamento {

    private String[] vagas = new String[10];
    private int[] entrada = new int[10];
    private int[] saida = new int[10];
    private int livre;
    private int total;

    public String verificar(){

        for (int i = 0; i < 10; i++) {

            if (vagas[i]==null) {
                return "possui Vagas disponiveis";
            }
            
        }

        return "não possui Vagas disponiveis";

    } 

    public String veiculoEntrada(String placa, String horario) {

        for (int i = 0; i < 10; i++) {

            if (vagas[i]==null) {
                vagas[i]=placa;
                entrada[i]=horario(horario);
                return "carro alojado com sucesso";
            }
            
        }
        
        return"";

    }

    public String veiculoSaida(String placa, String horario){

        for (int i = 0; i < 10; i++) {

            if (vagas[i].equals(placa)) {
                saida[i]=horario(horario);
                total+=pagar(entrada[i], saida[i]);
                vagas[i]=null;
                return "O valor total a ser pago é de: " + pagar(entrada[i], saida[i]);
            }
            
        }
        
        return "ERRO: Placa não encontrada"; 

    }

    public String verificarPlaca(String placa){

        for (int i = 0; i < 10; i++) {

            if (vagas[i].equals(placa)) {
                return "O carro com a placa " + placa + "esta na vaga " + i;
            }

        }

        return "placa nao encontrada";

    }

    public int pagar(int entrada, int saida){
        if (entrada==saida) {
            return 5;
        }
        else if((entrada+1)==saida){
            return 10;
        }
        else{
            return 15;
        }
    }

    public int horario(String horario){

        switch (horario.toLowerCase()) {
            case "m":
                return 1;
            case "t":
                return 2;
            case "n":
                return 3;
            default:
                break;
        }

        return 0;

    }

    public int Livres(){

        livre=0;

        for (int i = 0; i < 10; i++) {

            if (vagas[i]==null) {
                livre+=1;
            }

        }

        return livre;

    }

    public String[] getVagas() {
        return vagas;
    }

    public void setVagas(String[] vagas) {
        this.vagas = vagas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int[] getEntrada() {
        return entrada;
    }

    public void setEntrada(int[] entrada) {
        this.entrada = entrada;
    }

    public int[] getSaida() {
        return saida;
    }

    public void setSaida(int[] saida) {
        this.saida = saida;
    }

    public int getLivre() {
        return livre;
    }

    public void setLivre(int livre) {
        this.livre = livre;
    }
    
}