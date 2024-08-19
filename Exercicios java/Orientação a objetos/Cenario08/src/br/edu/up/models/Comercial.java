package br.edu.up.models;

public class Comercial extends Contato{

    private String cnpJ;

    public Comercial(int codigo, String nome, String telefone, String cnpJ) {
        super(codigo, nome, telefone);
        this.cnpJ = cnpJ;
    }

    public String getCnpJ() {
        return cnpJ;
    }

    public void setCnpJ(String cnpJ) {
        this.cnpJ = cnpJ;
    }

}