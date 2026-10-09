package org.example.controlador;

import org.example.modelo.Resultado;
import org.example.modelo.Ruleta;
import org.example.modelo.TipoApuesta;

public class RuletaController {

    private final Ruleta ruleta;

    public RuletaController(Ruleta ruleta) {
        this.ruleta = ruleta;
    }

    /**
     * Coordina una apuesta:
     *  1. Solicita al modelo procesar la ronda.
     *  2. Devuelve el Resultado a la Vista.
     * Las reglas (monto válido, saldo suficiente, ganar/perder) las aplica el Modelo.
     */
    public Resultado realizarApuesta(TipoApuesta tipo, int monto) {
        return ruleta.apostar(tipo, monto);
    }

    /** Coordina una recarga de saldo. */
    public void depositar(int monto) {
        ruleta.depositar(monto);
    }

    /** Consulta el saldo actual. */
    public int getSaldo() {
        return ruleta.getSaldo();
    }
}