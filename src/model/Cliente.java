package model;

import model.enums.TipoPersona;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {

    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;
    private String contrasenia;
    private TipoPersona tipoPersona;

    public Cliente(String nombre, String identificacion, String direccion, String telefono, String email,
                   String contrasenia, TipoPersona tipoPersona) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contrasenia = contrasenia;
        this.tipoPersona = tipoPersona;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}
