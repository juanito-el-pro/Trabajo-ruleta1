package org.example.controlador;

import org.example.modelo.Resultado;
import org.example.modelo.Ruleta;
import org.example.modelo.TipoApuesta;

public class RuletaController {

    private final Ruleta ruleta;
    private final SessionController session;

    public RuletaController(Ruleta ruleta, SessionController session) {
        this.ruleta = ruleta;
        this.session = session;
    }

    /**
     * Coordina una apuesta completa:
     *  1. Pide al modelo procesar la ronda.
     *  2. Registra el Resultado en el historial del usuario actual.
     *  3. Devuelve el Resultado a la Vista.
     */
    public Resultado realizarApuesta(TipoApuesta tipo, int monto) {
        Resultado r = ruleta.apostar(tipo, monto);
        session.getUsuarioActual().agregarResultado(r);
        return r;
    }

    public void depositar(int monto) {
        ruleta.depositar(monto);
    }

    public int getSaldo() {
        return ruleta.getSaldo();
    }
}