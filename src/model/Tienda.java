package model;

import exceptions.NegativeNumberException;
import exceptions.StringNuloOrVacioException;
import model.enums.PaisOrigen;
import model.enums.TipoProducto;
import model.subclasses.ProductoEnvasado;
import model.subclasses.ProductoPerecedero;
import model.subclasses.ProductoRefrigerado;
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

    private void crearCliente(TipoPersona tipoPersona, String nombre, String apellidos, String identificacion,
                              String direccion, String telefono, String email, Date fechaNacimiento, String nit,
                              String idTributaria) throws StringNuloOrVacioException {

        if (tipoPersona == null) throw new NullPointerException("El tipo de persona es nulo");

        MyUtils.validarSiNuloOrVacio(nombre, apellidos, identificacion, direccion, telefono, email);

        if (tipoPersona == TipoPersona.NATURAL && fechaNacimiento == null) throw new NullPointerException ("La fecha de nacimiento indicada es nula"){
            Cliente clienteNatural = new Cliente(nombre, apellidos, identificacion, direccion, telefono, email, fechaNacimiento);
            this.listaClientes.add(clienteNatural);


        } else {

            if (nit == null && id_tributaria == null)
                throw new NullPointerException("El nit o el ID tributario es nulo");
            Juridica clienteJuridico = new Juridica(nombre, direccion, doc, telefono, email, contrasenia, nit, id_tributaria);
            this.listaClientes.add(clienteJuridico);
        }
    }


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

    private void actualizarCliente(String email, String nuevoNombre, String nuevaDirec, String nuevoDoc, String nuevoTelef, String nuevaContrasenia, String nuevoNIT, String nuevaID_tributaria) {

        if (email != null || !email.equals("")) {
            for (Cliente c : listaClientes
            ) {

                if (c.getEmail().equals(email)) {

                    if (c.getTipoPersona() == TipoPersona.NATURAL) {

                        if (nuevoNombre != null && !nuevoNombre.equals("")) {
                            c.setNombre(nuevoNombre);
                        }
                        if (nuevaDirec != null && !nuevaDirec.equals("")) {
                            c.setDireccion(nuevaDirec);
                        }
                        if (nuevoDoc != null && !nuevoDoc.equals("")) {
                            c.setDocumento(nuevoDoc);
                        }
                        if (nuevoTelef != null && !nuevoTelef.equals("")) {
                            c.setTelefono(nuevoTelef);
                        }

                        if (nuevaContrasenia != null && nuevaContrasenia.equals("")) {
                            c.setContrasenia(nuevaContrasenia);
                        }

                    }
                    if (c.getTipoPersona() == TipoPersona.JURIDICA) {

                        Juridica personaJuridica = (Juridica) c;

                        if (nuevoNIT != null && !nuevoNIT.equals("")) {
                            personaJuridica.setNit(nuevoNIT);
                        }
                        if (nuevaID_tributaria != null && !!nuevaID_tributaria.equals("")) {
                            personaJuridica.setId_tributaria(nuevaID_tributaria);
                        }
                    }

                }
            }
        }
    }

    private boolean eliminarCliente(String email) {

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

    public void crearProductoPerecedero (String codigo, String nombre, String descripcion, double valorUnitario,
                                         int cantExistencias, TipoProducto tipoProducto, Date fechaVencimiento) throws StringNuloOrVacioException, NegativeNumberException {

        if (tipoProducto == null) throw new NullPointerException("El tipo de peroducto es nulo");
        MyUtils.validarSiNuloOrVacio(codigo, nombre);
        MyUtils.validarSiPositivo(cantExistencias, valorUnitario);

        if (tipoProducto == tipoProducto.PERECEDERO) {

            if (fechaVencimiento == null) throw new NullPointerException("la fecha de Vencimiento es nula");
            ProductoPerecedero perecedero = new ProductoPerecedero(codigo, nombre, descripcion, valorUnitario,
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
        MyUtils.validarSiNuloOrVacio(codigo, nombre);
        MyUtils.validarSiPositivo(cantExistencias, valorUnitario);

        if (tipoProducto == tipoProducto.REFRIGERADO) {

            if (codigoAprovacion == null) throw new NullPointerException("el codigo de aprobacion es nulo");
            MyUtils.validarSiPositivo(tempRefrigeracion);
            ProductoRefrigerado refrigerado = new ProductoRefrigerado(codigo, nombre, descripcion, valorUnitario,
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

