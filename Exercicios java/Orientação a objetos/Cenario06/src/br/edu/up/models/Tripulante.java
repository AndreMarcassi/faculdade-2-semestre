package br.edu.up.models;

public class Tripulante extends Pessoa{
    
    private int identificacao;
    private int matricula;

    public Tripulante() {
    }

    public Tripulante(String nome, int rg, int identificacao, int matricula) {
        super (nome, rg);
        this.identificacao = identificacao;
        this.matricula = matricula;
    }

    public int getIdentificacao() {
        return identificacao;
    }
    
    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}