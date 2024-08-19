package br.edu.up.models;

public class Passageiro extends Pessoa{

    private String passagem;
    private int idBagagem;
    
    public Passageiro() {
    }

    public Passageiro(String nome, int rg, String passagem, int idBagagem) {
        super (nome, rg);
        this.passagem = passagem;
        this.idBagagem = idBagagem;
    }

    public String getPassagem() {
        return passagem;
    }

    public void setPassagem(String passagem) {
        this.passagem = passagem;
    }

    public int getIdBagagem() {
        return idBagagem;
    }

    public void setIdBagagem(int iDbagagem) {
        idBagagem = iDbagagem;
    }
    
    
}