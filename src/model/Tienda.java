package model;

import model.enums.TipoPersona;

import java.util.ArrayList;

public class Tienda {

    //atributos
    private String nombre;
    private String nit;
    private ArrayList<Factura> listaFacturas;
    private ArrayList<Cliente> listaClientes;

    public Tienda(String nombre, String nit, ArrayList<Factura> listaFacturas, ArrayList<Cliente> listaClientes) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaFacturas = listaFacturas;
        this.listaClientes = listaClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }


}
