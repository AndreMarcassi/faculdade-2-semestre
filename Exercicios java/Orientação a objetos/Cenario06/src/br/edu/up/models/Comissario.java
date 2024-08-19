package br.edu.up.models;

public class Comissario extends Tripulante {
    
    private String Idiomas;

    public Comissario() {
    }

    public Comissario(String nome, int rg, int identificacao, int matricula, String idiomas) {
        super(nome, rg, identificacao, matricula);
        Idiomas = idiomas;
    }

    public String getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(String idiomas) {
        Idiomas = idiomas;
    }

    

}