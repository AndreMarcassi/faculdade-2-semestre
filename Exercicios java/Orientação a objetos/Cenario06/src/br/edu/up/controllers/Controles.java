package br.edu.up.controllers;

import java.util.Vector;
import br.edu.up.models.Aeronave;
import br.edu.up.models.Comandante;
import br.edu.up.models.Comissario;
import br.edu.up.models.Passageiro;
import br.edu.up.models.Tripulante;

public class Controles {

    private Vector<Aeronave> Aeronaves;
    private Vector<Tripulante> Tripulantes;
    private Vector<Passageiro> Passageiros;

    public Controles() {
        Aeronaves = new Vector<>();
        Tripulantes = new Vector<>();
        Passageiros = new Vector<>();  
    }

    public void novoVoo(Aeronave aeronave){
        Aeronaves.add(aeronave);
    }

    public String voosCadastrados() {
        StringBuilder listaVoos = new StringBuilder();

        if (Aeronaves==null) {
            return ("Nenhuma aeronave cadastrada.");
        }else{
            for (Aeronave aeronave : Aeronaves) {
                listaVoos.append("Voo codigo: ")
                         .append(aeronave.getCodigo())
                         .append(" com destino a ")
                         .append(aeronave.getDestino())
                         .append("\n");
            }
            
        }
        return listaVoos.toString();
    }

    public void novoPassagero(Passageiro passageiro){
        Passageiros.add(passageiro);
    }

    public void novoComandante(Comandante comandante){
        Tripulantes.add(comandante);
    }

    public void novoComissario(Comissario comissario){
        Tripulantes.add(comissario);
    }

    public String consultar(String tipo, int rg) {
        StringBuilder listaPessoa = new StringBuilder();

        switch (tipo.toLowerCase()) {
            case "p":

                if (Passageiros==null) {
                    return "nenhum passageiro cadastrado";
                }
                else{
                    for (Passageiro passageiro : Passageiros) {

                        if (passageiro.getRg()==rg) {
                            listaPessoa.append("Nome: ")
                                        .append(passageiro.getNome())
                                        .append(", RG: ")
                                        .append(passageiro.getRg())
                                        .append(", Passagem: ")
                                        .append(passageiro.getPassagem())
                                        .append("\n");
    
                        }
    
                    }
                }
                break;

            case "t":
                if (Passageiros==null) {
                    return "nenhum passageiro cadastrado";
                }
                else{
                    for (Tripulante tripulante : Tripulantes) {

                        if (tripulante.getRg()==rg) {
                            
                            listaPessoa.append("Nome: ")
                                    .append(tripulante.getNome())
                                    .append(", RG: ")
                                    .append(tripulante.getRg())
                                    .append(", Identificação: ")
                                    .append(tripulante.getIdentificacao())
                                    .append(", Matricula: ")
                                    .append(tripulante.getMatricula())
                                    .append("\n");

                        }
                    
                    }
                }  
                break;

        }

        if (listaPessoa.toString()==null) {
            return "Não foi encontrado ninguem com esse RG";
        }
        
        return listaPessoa.toString();
    }
    
}