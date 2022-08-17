package model;

public class DetalleFactura {

    private Producto producto;
    private int cantVendido;
    private double subtotal;

    public DetalleFactura(Producto producto, int cantidad, double total) {
        this.producto = producto;
        this.cantVendido = cantidad;
        this.subtotal = total;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
