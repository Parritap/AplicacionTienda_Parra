package model.subclasses;

import model.Producto;

import java.util.Date;

public class Perecedero extends Producto {

    //Atributos
    private Date fechaVencimiento;

    public Perecedero(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
