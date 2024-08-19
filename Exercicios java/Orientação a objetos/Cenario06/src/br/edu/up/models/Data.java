package br.edu.up.models;

public class Data {

    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minito;

    public Data() {
    }

    public Data(int ano, int mes, int dia, int hora, int minito) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minito = minito;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
    public int getMinito() {
        return minito;
    }
    public void setMinito(int minito) {
        this.minito = minito;
    }

    
}