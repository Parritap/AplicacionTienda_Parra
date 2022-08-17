package model.subclasses;

import model.Producto;
import model.enums.PaisOrigen;
import model.enums.TipoProducto;

import java.util.Date;

public class ProductoEnvasado extends Producto {

    private Date fechaEnvasado;
    private double pesoEnvase;
    private PaisOrigen paisOrigen;

    public ProductoEnvasado(String codigo, String nombre, String descripcion, double valorUnitario, int cantExistencias,
                            TipoProducto tipoProducto, Date fechaEnvasado, double pesoEnvase, PaisOrigen paisOrigen) {
        super(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }

    public ProductoEnvasado(Date fechaEnvasado, double pesoEnvase, PaisOrigen paisOrigen) {
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
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

    public PaisOrigen getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(PaisOrigen paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
