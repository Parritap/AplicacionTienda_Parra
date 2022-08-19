package model;

import model.enums.PaisOrigen;
import model.enums.TipoProducto;

import java.util.Date;

public class Producto {

    //atributos
    private String codigo;
    private String nombre;
    private String descripcion;
    private double valorUnitario;
    private int cantExistencias;
    private TipoProducto tipoProducto;

    public Producto(String codigo, String nombre, String descripcion, double valorUnitario, int cantExistencias,
                    TipoProducto tipoProducto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.cantExistencias = cantExistencias;
        this.tipoProducto = tipoProducto;
    }

    public Producto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantExistencias() {
        return cantExistencias;
    }

    public void setCantExistencias(int cantExistencias) {
        this.cantExistencias = cantExistencias;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}