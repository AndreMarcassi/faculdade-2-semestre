package br.edu.up.models;

public class Ponto {

    private double X;
    private double Y;

    public Ponto() {
        this.X = 0;
        this.Y = 0;
    }

    public Ponto(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double calcularDistancia(double X, double Y) {
        return Math.sqrt(Math.pow(this.X - X, 2) + Math.pow(this.Y - Y, 2));
    }

    public double calcularDistancia(Ponto ponto2) {
        return Math.sqrt(Math.pow(this.X - ponto2.X, 2) + Math.pow(this.Y - ponto2.Y, 2));
    }

}