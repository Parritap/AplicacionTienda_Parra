package model.subclasses;

import model.Cliente;
import model.enums.TipoPersona;

import java.util.Date;

public class ClienteJuridico extends Cliente {

    private String nit;
    private String idTributaria;

    public ClienteJuridico(String nombre, String identificacion, String direccion, String telefono, String email,
                           String contrasenia, TipoPersona tipoPersona, String nit, String idTributaria) {
        super(nombre, identificacion, direccion, telefono, email, contrasenia, tipoPersona);
        this.nit = nit;
        this.idTributaria = idTributaria;
    }

    public ClienteJuridico(String nit, String idTributaria) {
        this.nit = nit;
        this.idTributaria = idTributaria;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getIdTributaria() {
        return idTributaria;
    }

    public void setIdTributaria(String idTributaria) {
        this.idTributaria = idTributaria;
    }
}
