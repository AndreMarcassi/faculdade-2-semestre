package br.edu.up.controllers;
import java.util.Vector;

import br.edu.up.models.*;

public class Controles {

    private Vector<Seguro> seguros;

    Segurado segurado = new Segurado();

    public Controles() {
        seguros = new Vector<>();
    }

    public void addSeguro(SeguroAutomovel seguroAutomovel){
        seguros.add(seguroAutomovel);
    }

    public void addSeguro(SeguroVida seguroVida){
        seguros.add(seguroVida);
    }

    public String localizar(String Apolice){

        StringBuilder localizar = new StringBuilder();

        for (Seguro seguro : seguros) {
            localizar.append("Nome: ")
                          .append(segurado.getNome())
                          .append(", Telefone: ")
                          .append(segurado.getTelefone())
                          .append(", Apolice: ")
                          .append(seguro.getApolice())
                          .append(", valorApolice: ")
                          .append(seguro.getValorApolice())
                          .append("\n");
        }

        if (localizar.toString()==null) {
            return "nenhum seguro encontrado";
        }

        return localizar.toString();

    }

    public void excluirSeguro(String Apolice){
        for (Seguro seguro : seguros) {
            if (seguro.getApolice() == Apolice) {
                seguros.remove(seguro);
                return;
            }
        }
    }

    public void excluirTodos(){
        seguros.removeAllElements();
    }

    public String listarSeguros(){

        StringBuilder listarSeguros = new StringBuilder();

        if (seguros.isEmpty()) {
            return "nenhum seguro cadastrado";
        }

        for (Seguro seguro : seguros) {
            listarSeguros.append("Nome: ")
                          .append(segurado.getNome())
                          .append(", Telefone: ")
                          .append(segurado.getTelefone())
                          .append(", Apolice: ")
                          .append(seguro.getApolice())
                          .append(", valorApolice: ")
                          .append(seguro.getValorApolice())
                          .append("\n");
        }

        return listarSeguros.toString();

    }

    public int verQuantidade(){
        return seguros.size();
    }

    public boolean verificador(String tipo){

        if (tipo.toLowerCase()=="s") {
            return true;
        }

        return false;

    }

}