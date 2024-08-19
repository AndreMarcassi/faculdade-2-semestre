package br.edu.up.models;

import java.time.LocalDate;

public abstract class Seguro {
    
    private String Apolice;
    private Segurado segurado;
    private double valorApolice;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public String getApolice() {
        return Apolice;
    }
    public void setApolice(String apolice) {
        Apolice = apolice;
    }
    public Segurado getSegurado() {
        return segurado;
    }
    public void setSegurado(Segurado segurado) {
        this.segurado = segurado;
    }
    public double getValorApolice() {
        return valorApolice;
    }
    public void setValorApolice(double valorApolice) {
        this.valorApolice = valorApolice;
    }
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }
    public LocalDate getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

}