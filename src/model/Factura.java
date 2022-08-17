package model;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

    //atributos
    private String codigo;
    private Date fecha;
    private double total;
    private int iva;

    private ArrayList<DetalleFactura> listaDetalles;


    public Factura(String codigo, Date fecha, double total, int iva, ArrayList<DetalleFactura> listaDetalles) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.iva = iva;
        this.listaDetalles = listaDetalles;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public ArrayList<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<DetalleFactura> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
}
