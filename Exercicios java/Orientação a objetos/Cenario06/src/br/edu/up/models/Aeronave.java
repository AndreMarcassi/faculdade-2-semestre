package br.edu.up.models;

public class Aeronave {
    
    private int codigo;
    private String tipo;
    private int assentos;
    private String localSaida;
    private String destino;

    public Aeronave() {
    }

    public Aeronave(int codigo, String tipo, int assentos, String localSaida, String destino) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.assentos = assentos;
        this.localSaida = localSaida;
        this.destino = destino;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getAssentos() {
        return assentos;
    }
    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public String getLocalSaida() {
        return localSaida;
    }

    public void setLocalSaida(String localSaida) {
        this.localSaida = localSaida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String localChegada) {
        this.destino = localChegada;
    }
    
}