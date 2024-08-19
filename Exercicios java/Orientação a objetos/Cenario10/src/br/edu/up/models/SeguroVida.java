package br.edu.up.models;

public class SeguroVida extends Seguro{

    private boolean cobreDoenca;
    private boolean cobreAcidente;

    public SeguroVida() {
    }

    public SeguroVida(boolean cobreDoenca, boolean cobreAcidente) {
        this.cobreDoenca = cobreDoenca;
        this.cobreAcidente = cobreAcidente;
    }

    public boolean isCobreDoenca() {
        return cobreDoenca;
    }
    
    public void setCobreDoenca(boolean cobreDoenca) {
        this.cobreDoenca = cobreDoenca;
    }

    public boolean isCobreAcidente() {
        return cobreAcidente;
    }

    public void setCobreAcidente(boolean cobreAcidente) {
        this.cobreAcidente = cobreAcidente;
    }

}