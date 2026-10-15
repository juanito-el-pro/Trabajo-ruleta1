package org.example.controlador;

import org.example.modelo.Resultado;
import org.example.modelo.Ruleta;

import java.util.ArrayList;
import java.util.List;

public class ResultadoController {

    private final Ruleta ruleta;
    private final SessionController session;

    public ResultadoController(Ruleta ruleta, SessionController session) {
        this.ruleta = ruleta;
        this.session = session;
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

    // ===== Historial del usuario =====

    /** Devuelve el historial del usuario actual, ya formateado para la JList. */
    public List<String> getHistorialComoTexto() {
        List<String> lineas = new ArrayList<>();
        List<Resultado> historial = session.getUsuarioActual().getHistorial();

        int i = 1;
        for (Resultado r : historial) {
            String color = ruleta.obtenerColor(r.getNumero());
            String estado = r.isAcierto() ? "GANÓ" : "PERDIÓ";
            String linea = "#" + i +
                    " - Número " + r.getNumero() + " (" + color + ")" +
                    " | Apuesta: " + r.getTipo() + " $" + r.getMonto() +
                    " | " + estado;
            lineas.add(linea);
            i++;
        }
        return lineas;
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