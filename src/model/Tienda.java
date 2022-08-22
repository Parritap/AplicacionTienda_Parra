package model;

import exceptions.NegativeNumberException;
import exceptions.StringNuloOrVacioException;
import model.enums.PaisOrigen;
import model.enums.TipoProducto;
import model.subclasses.*;
import utilities.MyUtils;

import model.enums.TipoPersona;

import java.util.ArrayList;
import java.util.Date;

public class Tienda {

    //atributos
    private String nombre;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Factura> listaFacturas;
    private ArrayList <Producto> listaProductos;

    public Tienda(String nombre, ArrayList<Cliente> listaClientes, ArrayList<Factura> listaFacturas) {
        this.nombre = nombre;
        this.listaClientes = listaClientes;
        this.listaFacturas = listaFacturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    //CRUDS----------------------------------------------------
    /*
    Create
    Read
    Update
    Delete
     */


    //CRUD Cliente

    private void crearClienteNatural (String nombre, String identificacion, String direccion, String telefono, String email,
                                      String contrasenia, TipoPersona tipoPersona, Date fechaNacimiento) throws StringNuloOrVacioException {

        if (tipoPersona == null) throw new NullPointerException("El tipo de persona es nulo");

        if (tipoPersona == TipoPersona.NATURAL) {

            MyUtils.validarSiNuloOrVacio(nombre,identificacion, direccion, telefono, email, contrasenia);
            if (fechaNacimiento == null) throw new NullPointerException ("La fecha de nacimiento indicada es nula");
            Cliente clienteNatural = new ClienteNatural(nombre, identificacion, direccion, telefono, email,
                                                        contrasenia, tipoPersona, fechaNacimiento);
            this.listaClientes.add(clienteNatural);

        }else {
            System.out.print("el tipo de Cliente no es natural, Seleccione otra opcion");
        }
    }

    private void crearClienteJuridico (String nombre, String identificacion, String direccion, String telefono, String email,
                                       String contrasenia, TipoPersona tipoPersona, String nit, String idTributaria) throws StringNuloOrVacioException {

        if (tipoPersona == null) throw new NullPointerException("El tipo de persona es nulo");

        if (tipoPersona == TipoPersona.JURIDICA) {

            MyUtils.validarSiNuloOrVacio(nombre,identificacion, direccion, telefono, email, contrasenia);
            if (nit == null || idTributaria == null) throw new NullPointerException ("el nit o la idTributaria indicada es nula");
            Cliente clienteJuridico = new ClienteJuridico(nombre, identificacion, direccion, telefono, email,
                    contrasenia, tipoPersona, nit, idTributaria);
            this.listaClientes.add(clienteJuridico);

        }else {
            System.out.print("el tipo de Cliente no es Juridico, Seleccione otra opcion");
        }
    }


    //READ
    private Cliente leerCliente(String email) {

        if (email != null) {
            for (Cliente c : listaClientes
            ) {
                if (c.getEmail().equals(email))
                    return c;
            }
        }
        return null;
    }

    //UPDATE
    private void actualizarClienteNatural(String email, String nuevoNombre, String nuevaDireccion, String nuevoTelefono,
                                          String nuevaContrasenia) {

        if (email != null || !email.equals("")) {
            for (Cliente c : listaClientes
            ) {
                if (c.getTipoPersona() == TipoPersona.NATURAL) {

                    if (c.getEmail().equals(email)) {

                        if (nuevoNombre != null && !nuevoNombre.equals("")) {
                            c.setNombre(nuevoNombre);
                        }
                        if (nuevaDireccion != null && !nuevaDireccion.equals("")) {
                            c.setDireccion(nuevaDireccion);
                        }
                        if (nuevoTelefono != null && !nuevoTelefono.equals("")) {
                            c.setTelefono(nuevoTelefono);
                        }

                        if (nuevaContrasenia != null && nuevaContrasenia.equals("")) {
                            c.setContrasenia(nuevaContrasenia);
                        }
                    }
                }
            }
        }
    }

    private void actualizarClienteJurudico(String email, String nuevoNombre, String nuevaDireccion, String nuevoTelefono,
                                          String nuevaContrasenia,  String nuevoNit, String nuevaIdTributaria) {

        if (email != null || !email.equals("")) {
            for (Cliente c : listaClientes
            ) {
                if (c.getTipoPersona() == TipoPersona.NATURAL) {

                    if (c.getEmail().equals(email)) {

                        if (nuevoNombre != null && !nuevoNombre.equals("")) {
                            c.setNombre(nuevoNombre);
                        }

                        if (nuevaDireccion != null && !nuevaDireccion.equals("")) {
                            c.setDireccion(nuevaDireccion);
                        }
                        if (nuevoTelefono != null && !nuevoTelefono.equals("")) {
                            c.setTelefono(nuevoTelefono);
                        }

                        if (nuevaContrasenia != null && nuevaContrasenia.equals("")) {
                            c.setContrasenia(nuevaContrasenia);
                        }
                        if (nuevaIdTributaria != null && nuevaIdTributaria.equals("")){
                            ((ClienteJuridico) c).setIdTributaria(nuevaIdTributaria);
                        }
                        if (nuevoNit != null && nuevoNit.equals("")){
                            ((ClienteJuridico) c).setNit(nuevoNit);
                        }

                    }
                }
            }
        }
    }

    //DELETE
    private boolean eliminarCliente(String email) throws Throwable {

        if (email != null && !email.equals("")) {

            for (Cliente c : listaClientes
            ) {
                if (c.getEmail().equals(email)) {
                    listaClientes.remove(c);
                    return true;
                }
            }
        }
        return false;
    }


    // CRUD PRODUCTO

    //CREATE
    public void crearProductoPerecedero (String codigo, String nombre, String descripcion, double valorUnitario,
                                         int cantExistencias, TipoProducto tipoProducto, Date fechaVencimiento) throws StringNuloOrVacioException, NegativeNumberException {

        if (tipoProducto == null) throw new NullPointerException("El tipo de peroducto es nulo");

        if (tipoProducto == tipoProducto.PERECEDERO) {

            MyUtils.validarSiNuloOrVacio(codigo, nombre);
            MyUtils.validarSiPositivo(cantExistencias, valorUnitario);
            if (fechaVencimiento == null) throw new NullPointerException("la fecha de Vencimiento es nula");
            Producto perecedero = new ProductoPerecedero(codigo, nombre, descripcion, valorUnitario,
                                                            cantExistencias, tipoProducto, fechaVencimiento);
            listaProductos.add(perecedero);

        }else {
            System.out.print("el tipo de producto no es perecedero");
        }
    }


    public void crearProductoRefrigerado (String codigo, String nombre, String descripcion, double valorUnitario,
                                          int cantExistencias, TipoProducto tipoProducto, String codigoAprovacion,
                                          double tempRefrigeracion) throws StringNuloOrVacioException, NegativeNumberException {

        if (tipoProducto == null) throw new NullPointerException("El tipo de peroducto es nulo");

        if (tipoProducto == tipoProducto.REFRIGERADO) {

            MyUtils.validarSiNuloOrVacio(codigo, nombre);
            MyUtils.validarSiPositivo(cantExistencias, valorUnitario);
            if (codigoAprovacion == null) throw new NullPointerException("el codigo de aprobacion es nulo");
            MyUtils.validarSiPositivo(tempRefrigeracion);
            Producto refrigerado = new ProductoRefrigerado(codigo, nombre, descripcion, valorUnitario,
                                                            cantExistencias, tipoProducto, codigoAprovacion, tempRefrigeracion);
            listaProductos.add(refrigerado);

        }else {
            System.out.print("el tipo de producto no es Refrigerado");
        }
    }


    public void crearProductoEnvasado (String codigo, String nombre, String descripcion, double valorUnitario, int cantExistencias,
                                       TipoProducto tipoProducto, Date fechaEnvasado, double pesoEnvase, PaisOrigen paisOrigen) throws StringNuloOrVacioException, NegativeNumberException {

        if (tipoProducto == null) throw new NullPointerException("El tipo de peroducto es nulo");
        MyUtils.validarSiNuloOrVacio(codigo, nombre);
        MyUtils.validarSiPositivo(cantExistencias, valorUnitario);

        if (tipoProducto == tipoProducto.ENVASADO) {

            if (fechaEnvasado == null) throw new NullPointerException("la fecha de envasado es nula");
            if (paisOrigen == null) throw new NullPointerException("es pais de origen es nulo");
            MyUtils.validarSiPositivo(pesoEnvase);
            ProductoEnvasado envasado = new ProductoEnvasado(codigo, nombre, descripcion, valorUnitario,
                    cantExistencias, tipoProducto, fechaEnvasado, pesoEnvase, paisOrigen);
            listaProductos.add(envasado);

        }else {
            System.out.print("el tipo de producto no es Envasado");
        }
    }

    //READ
    public Producto leerProducto (String codigo){

        if (codigo != null) {
            for (Producto p : listaProductos
            ) {
                if (p.getCodigo().equals(codigo))
                    return p;
            }
        }
        return null;

    }


}

