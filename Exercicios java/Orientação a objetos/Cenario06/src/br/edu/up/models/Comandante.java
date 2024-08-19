package br.edu.up.models;

public class Comandante extends Tripulante{

    private double HorasDeVoo;

    public Comandante() {
    }

    public Comandante(String nome, int rg, int identificacao, int matricula, double horasDeVoo) {
        super(nome, rg, identificacao, matricula);
        HorasDeVoo = horasDeVoo;
    }

    public double getHorasDeVoo() {
        return HorasDeVoo;
    }

    public void setHorasDeVoo(double horasDeVoo) {
        HorasDeVoo = horasDeVoo;
    }
    
}