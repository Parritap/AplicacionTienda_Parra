package model.subclasses;

import model.Cliente;
import model.enums.TipoPersona;

import java.util.Date;

public class ClienteNatural extends Cliente {
    private Date fechaNacimiento;

    public ClienteNatural(String nombre, String identificacion, String direccion, String telefono, String email,
                          String contrasenia, TipoPersona tipoPersona, Date fechaNacimiento) {
        super(nombre, identificacion, direccion, telefono, email, contrasenia, tipoPersona);
        this.fechaNacimiento = fechaNacimiento;
    }

    public ClienteNatural(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
