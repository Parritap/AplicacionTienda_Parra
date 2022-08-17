package model;

import exceptions.StringNuloOrVacioException;
import model.enums.TipoProducto;
import utilities.MyUtils;

import model.enums.TipoPersona;

import java.util.ArrayList;
import java.util.Date;

public class Tienda {

    //atributos
    private String nombre;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Factura> listaFacturas;

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


    public void crearProducto (String codigo, String nombre, int existencias, double valorUnitario, TipoProducto tipoProducto){


    }


}

