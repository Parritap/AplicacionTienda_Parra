package model;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

    //atributos
    private String codigo;
    private Date fecha;
    private ArrayList<DetalleFactura> listaDetalles;
    private Cliente cliente;
    private double total;
    private int iva;

    public Factura(String codigo, Date fecha, double total, int iva, ArrayList<DetalleFactura> listaDetalles) {
        if(this.cliente == cliente){
            this.codigo = codigo;
            this.fecha = fecha;
            this.listaDetalles = listaDetalles;
            this.total = total;
            this.iva = iva;
        }
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

    public ArrayList<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<DetalleFactura> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
