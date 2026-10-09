package org.example.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {

    public static final int CANTIDAD_NUMEROS = 37;

    private static final int[] NUMEROS_ROJOS = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    private int saldo;
    private final List<Resultado> historial;
    private final Random rng;

    /** Constructor sin parámetros: la ruleta inicia con saldo cero. */
    public Ruleta() {
        this(0);
    }

    /** Constructor con saldo inicial. */
    public Ruleta(int saldoInicial) {
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();
        this.rng = new Random();
    }

    // ================== Saldo ==================

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /** Recarga el saldo. Solo acepta montos válidos (> 0). */
    public void depositar(int monto) {
        if (!esMontoValido(monto)) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0.");
        }
        saldo += monto;
    }

    // ================== Apuesta ==================

    /**
     * Ejecuta una ronda completa:
     *  1. Gira la ruleta.
     *  2. Evalúa si la apuesta gana.
     *  3. Actualiza el saldo (pago 1:1).
     *  4. Registra el Resultado en el historial.
     * Devuelve el Resultado para que el controlador lo muestre.
     */
    public Resultado apostar(TipoApuesta tipo, int monto) {
        if (!esMontoValido(monto)) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0.");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipo);

        // Pago 1:1
        if (acierto) {
            saldo += monto;
        } else {
            saldo -= monto;
        }

        Resultado resultado = new Resultado(numero, tipo, monto, acierto);
        historial.add(resultado);
        return resultado;
    }

    // ================== Reglas del juego (privadas) ==================

    private int girarRuleta() {
        return rng.nextInt(CANTIDAD_NUMEROS);
    }

    private boolean evaluarResultado(int numero, TipoApuesta tipo) {
        switch (tipo) {
            case ROJO:  return esRojo(numero);
            case NEGRO: return numero != 0 && !esRojo(numero);
            case PAR:   return numero != 0 && numero % 2 == 0;
            case IMPAR: return numero % 2 != 0;
            default:    return false;
        }
    }

    private boolean esRojo(int n) {
        for (int rojo : NUMEROS_ROJOS) {
            if (rojo == n) {
                return true;
            }
        }
        return false;
    }

    private boolean esMontoValido(int monto) {
        return monto > 0;
    }

    // ================== Color (público: la vista lo necesita) ==================

    public String obtenerColor(int numero) {
        if (numero == 0) {
            return "Verde";
        }
        if (esRojo(numero)) {
            return "Rojo";
        }
        return "Negro";
    }

    // ================== Historial y estadísticas ==================

    public List<Resultado> getHistorial() {
        return historial;
    }

    public int getCantidadRondas() {
        return historial.size();
    }

    public int calcularTotalApostado() {
        int total = 0;
        for (Resultado r : historial) {
            total += r.getMonto();
        }
        return total;
    }

    public int calcularTotalAciertos() {
        int total = 0;
        for (Resultado r : historial) {
            if (r.isAcierto()) {
                total++;
            }
        }
        return total;
    }

    public int calcularGananciaNeta() {
        int ganancia = 0;
        for (Resultado r : historial) {
            ganancia += r.isAcierto() ? r.getMonto() : -r.getMonto();
        }
        return ganancia;
    }

    public double calcularPorcentajeAciertos() {
        if (historial.isEmpty()) {
            return 0;
        }
        return (double) calcularTotalAciertos() / historial.size() * 100;
    }

    public void reiniciarHistorial() {
        historial.clear();
    }
}
