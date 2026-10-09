package org.example.modelo;

public enum TipoApuesta {
    ROJO,
    NEGRO,
    PAR,
    IMPAR;

    @Override
    public String toString() {
        switch (this) {
            case ROJO:  return "Rojo";
            case NEGRO: return "Negro";
            case PAR:   return "Par";
            case IMPAR: return "Impar";
            default:    return name();
        }
    }
}