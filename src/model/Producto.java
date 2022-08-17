package model;

public class Producto{

    //atributos
    private String nombre;
    private String codigo;
    private int existencias;
    private double valorUnitario;

    public Producto(String nombre, String codigo, int existencias, double valorUnitario) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.existencias = existencias;
        this.valorUnitario = valorUnitario;
    }

    public Producto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
