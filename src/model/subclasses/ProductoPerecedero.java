package model.subclasses;

import model.Producto;
import model.enums.TipoProducto;

import java.util.Date;

public class ProductoPerecedero extends Producto {

    private Date fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, String descripcion, double valorUnitario,
                              int cantExistencias, TipoProducto tipoProducto, Date fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto);
        this.fechaVencimiento = fechaVencimiento;
    }

    public ProductoPerecedero(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
