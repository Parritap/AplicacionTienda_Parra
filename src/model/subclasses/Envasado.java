package model.subclasses;

import model.Producto;

import java.util.Date;

public class Envasado extends Producto {

    //Atributos
    private Date fechaEnvasado;
    private double pesoEnvase;


    public Envasado(Date fechaEnvasado, double pesoEnvase) {
        super();
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
    }

    public Date getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(Date fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(double pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }
}
