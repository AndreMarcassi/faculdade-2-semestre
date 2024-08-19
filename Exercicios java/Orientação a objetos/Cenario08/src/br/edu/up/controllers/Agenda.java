package br.edu.up.controllers;

import java.util.Vector;
import br.edu.up.models.*;

public class Agenda {

    private Vector<Contato> contatos;

    public Agenda() {
        contatos = new Vector<>();  
    }

    public void addPessoal(int codigo, String nome, String telefone, String aniversario) {
        Pessoal contato = new Pessoal(codigo, nome, telefone, aniversario);
        contatos.add(contato);
    }

    public void addComercial(int codigo, String nome, String telefone, String cnpJ) {
        Comercial contato = new Comercial(codigo, nome, telefone, cnpJ);
        contatos.add(contato);
    }

    public void removerContato(int codigo) {
        for (Contato contato : contatos) {
            if (contato.getCodigo() == codigo) {
                contatos.remove(contato);
                return;
            }
        }
    }

    public String listarContatos() {

        StringBuilder listarContatos = new StringBuilder();
        
        for (Contato contato : contatos) {
            listarContatos.append("Nome: ")
                          .append(contato.getNome())
                          .append(", Telefone: ")
                          .append(contato.getTelefone())
                          .append("\n");
        }
        return listarContatos.toString();
    }

    public boolean verificarContato(int codigo) {
        for (Contato contato : contatos) {
            if (contato.getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }

    public String listaContato(int codigo) {

        StringBuilder listaContato = new StringBuilder();

        for (Contato contato : contatos) {
            if (contato.getCodigo() == codigo){
                listaContato.append("Nome: ")
                            .append(contato.getNome())
                            .append(", Telefone: ")
                            .append(contato.getTelefone());
            }
        }
        return listaContato.toString();
    }

}