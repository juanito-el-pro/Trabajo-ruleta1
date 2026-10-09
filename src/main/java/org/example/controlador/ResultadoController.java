package org.example.controlador;

import org.example.modelo.Resultado;
import org.example.modelo.Ruleta;

public class ResultadoController {

    private final Ruleta ruleta;

    public ResultadoController(Ruleta ruleta) {
        this.ruleta = ruleta;
    }

    /** Color del número, obtenido del Modelo. */
    public String getColorDelNumero(int numero) {
        return ruleta.obtenerColor(numero);
    }

    /** Texto formateado de un Resultado, listo para mostrar en un JLabel. */
    public String formatearResultado(Resultado r) {
        String color = ruleta.obtenerColor(r.getNumero());
        String estado = r.isAcierto() ? "GANASTE" : "PERDISTE";
        return "<html>Resultado: " + estado +
                "<br>Número: " + r.getNumero() + " (" + color + ")" +
                "<br>Tipo: " + r.getTipo() +
                "<br>Monto: $" + r.getMonto() +
                "<br>Saldo actual: $" + ruleta.getSaldo() + "</html>";
    }

    // ===== Datos para la ventana de estadísticas =====

    public int getCantidadRondas() {
        return ruleta.getCantidadRondas();
    }

    public int getTotalApostado() {
        return ruleta.calcularTotalApostado();
    }

    public int getTotalAciertos() {
        return ruleta.calcularTotalAciertos();
    }

    public int getGananciaNeta() {
        return ruleta.calcularGananciaNeta();
    }

    public double getPorcentajeAciertos() {
        return ruleta.calcularPorcentajeAciertos();
    }
}