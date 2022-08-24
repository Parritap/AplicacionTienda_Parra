package controller;

import exceptions.NegativeNumberException;
import exceptions.StringNuloOrVacioException;
import model.*;
import model.enums.PaisOrigen;
import model.enums.TipoPersona;
import model.enums.TipoProducto;

import java.util.Date;

public class Singleton {


    Tienda tienda;


    private static class SingletonHolder {
        private final static Singleton E_INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.E_INSTANCE;
    }


    public Singleton() {
        inicilizarDatos();
    }


    public Tienda getTienda() {
        return tienda;
    }



    private void inicilizarDatos() {

        try {
            tienda = new Tienda("La Tienda");

            tienda.crearProductoEnvasado ("01-11111", "Sardinas", "Las mejores sardinas", 1000, 10, TipoProducto.ENVASADO, new Date(), 100, PaisOrigen.ARGENTINA );
            tienda.crearProductoEnvasado ("01-22222", "Atún", "EL mejor atun", 1000, 20, TipoProducto.ENVASADO, new Date(), 100, PaisOrigen.ARGENTINA );

            tienda.crearProductoPerecedero("02-1111", "Leche", "La mejor leche", 10000, 10, TipoProducto.PERECEDERO, new Date());
            tienda.crearProductoPerecedero("02-2222", "Queso", "El mejor Queso", 20000, 20, TipoProducto.PERECEDERO, new Date());

            tienda.crearProductoRefrigerado("03-1111", "Jamon", "El mejor jamón", 10000, 10, TipoProducto.REFRIGERADO, "codigoAprobacion-001", 5);
            tienda.crearProductoRefrigerado("03-2222", "Tocino", "El mejor Tocino", 20000, 20, TipoProducto.REFRIGERADO, "codigoAprobacion-002", 5);


            tienda.crearClienteNatural("Juan Esteban", "1002656555", "Mi casita en la 14", "3243585508", "cliente@cliente.com", "cliente", TipoPersona.NATURAL, new Date());


        } catch (StringNuloOrVacioException e) {

        } catch (NegativeNumberException e) {

        }


    }


}
