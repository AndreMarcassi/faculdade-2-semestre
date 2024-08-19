package br.edu.up.models;

public class SeguroAutomovel extends Seguro{

    private double valorFranquia;
    private boolean possuiCarroReserva;
    private boolean coberturaVidros;

    public SeguroAutomovel() {
    }

    public SeguroAutomovel(double valorFranquia, boolean possuiCarroReserva, boolean coberturaVidros) {
        this.valorFranquia = valorFranquia;
        this.possuiCarroReserva = possuiCarroReserva;
        this.coberturaVidros = coberturaVidros;
    }
    
    public double getValorFranquia() {
        return valorFranquia;
    }
    public void setValorFranquia(double valorFranquia) {
        this.valorFranquia = valorFranquia;
    }
    public boolean isPossuiCarroReserva() {
        return possuiCarroReserva;
    }
    public void setPossuiCarroReserva(boolean possuiCarroReserva) {
        this.possuiCarroReserva = possuiCarroReserva;
    }
    public boolean isCoverturaVidros() {
        return coberturaVidros;
    }
    public void setCoverturaVidros(boolean coverturaVidros) {
        this.coberturaVidros = coverturaVidros;
    }

}