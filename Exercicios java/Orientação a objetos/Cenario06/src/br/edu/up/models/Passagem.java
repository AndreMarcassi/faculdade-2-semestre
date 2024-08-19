package br.edu.up.models;

public class Passagem {

    private int numeroAcento;
    private int classe;

    public Passagem() {
    }

    public Passagem(int numeroAcento, int classe) {
        this.numeroAcento = numeroAcento;
        this.classe = classe;
    }

    public int getNumeroAcento() {
        return numeroAcento;
    }
    public void setNumeroAcento(int numeroAcento) {
        this.numeroAcento = numeroAcento;
    }
    public int getClasse() {
        return classe;
    }
    public void setClasse(int classe) {
        this.classe = classe;
    }
  
}