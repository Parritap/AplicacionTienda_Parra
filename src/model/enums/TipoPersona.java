package model.enums;

public enum TipoPersona {

    NATURAL(0), JURIDICA(1);

    int identificador;

    TipoPersona(int identificador) {
        this.identificador = identificador;
    }
}
