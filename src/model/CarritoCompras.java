package model;

import java.util.ArrayList;

public class CarritoCompras {

    private ArrayList<DetalleFactura> listaDetalles = new ArrayList<>();

    public ArrayList<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<DetalleFactura> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }


    public CarritoCompras() {
        this.listaDetalles = new ArrayList<>();
    }
}
