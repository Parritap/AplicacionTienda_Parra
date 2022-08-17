package model.subclasses;

import model.Producto;

public class Refrigerado extends Producto {

    //atributos
    private String codigoAprobacion;
    private double tempRefigeracion;

    public Refrigerado(String nombre, String codigo, int existencias, double valorUnitario) {
        super(nombre, codigo, existencias, valorUnitario);
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public double getTempRefigeracion() {
        return tempRefigeracion;
    }

    public void setTempRefigeracion(double tempRefigeracion) {
        this.tempRefigeracion = tempRefigeracion;
    }
}
