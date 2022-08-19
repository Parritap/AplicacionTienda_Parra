package model.subclasses;

import model.Producto;
import model.enums.TipoProducto;

public class ProductoRefrigerado extends Producto {

    private String codigoAprovacion;
    private double tempRefrigeracion;

    public ProductoRefrigerado(String codigo, String nombre, String descripcion, double valorUnitario,
                               int cantExistencias, TipoProducto tipoProducto, String codigoAprovacion,
                               double tempRefrigeracion) {
        super(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto);
        this.codigoAprovacion = codigoAprovacion;
        this.tempRefrigeracion = tempRefrigeracion;
    }

    public ProductoRefrigerado(String codigoAprovacion, double tempRefrigeracion) {
        this.codigoAprovacion = codigoAprovacion;
        this.tempRefrigeracion = tempRefrigeracion;
    }

    public String getCodigoAprovacion() {
        return codigoAprovacion;
    }

    public void setCodigoAprovacion(String codigoAprovacion) {
        this.codigoAprovacion = codigoAprovacion;
    }

    public double getTempRefrigeracion() {
        return tempRefrigeracion;
    }

    public void setTempRefrigeracion(double tempRefrigeracion) {
        this.tempRefrigeracion = tempRefrigeracion;
    }


}
