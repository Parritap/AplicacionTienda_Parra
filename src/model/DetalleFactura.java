package model;

public class DetalleFactura {

    private Producto producto;
    private int cantVendido;


    public DetalleFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantVendido = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantVendido() {
        return cantVendido;
    }

    public void setCantVendido(int cantVendido) {
        this.cantVendido = cantVendido;
    }

}
