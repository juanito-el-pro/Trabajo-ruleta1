package org.example.vista;

import org.example.controlador.ResultadoController;
import org.example.controlador.SessionController;

import javax.swing.*;

public class VentanaEstadisticas {

    private final SessionController session;
    private final ResultadoController resultadoCtrl;

    private final JFrame frame = new JFrame("Estadísticas - Casino Black Cat");

    private final JLabel lblTitulo = new JLabel("Estadísticas de la Ruleta");
    private final JLabel lblRondas = new JLabel();
    private final JLabel lblTotalApostado = new JLabel();
    private final JLabel lblAciertos = new JLabel();
    private final JLabel lblPorcentaje = new JLabel();
    private final JLabel lblGanancia = new JLabel();
    private final JLabel lblSaldo = new JLabel();
    private final JButton btnVolver = new JButton("Volver al menú");

    public VentanaEstadisticas(SessionController session) {
        this.session = session;
        this.resultadoCtrl = new ResultadoController(session.getRuleta());

        configurarVentana();
        agregarComponentes();
        cargarEstadisticas();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(420, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblTitulo.setBounds(120, 20, 200, 30);
        lblRondas.setBounds(50, 80, 320, 25);
        lblTotalApostado.setBounds(50, 110, 320, 25);
        lblAciertos.setBounds(50, 140, 320, 25);
        lblPorcentaje.setBounds(50, 170, 320, 25);
        lblGanancia.setBounds(50, 200, 320, 25);
        lblSaldo.setBounds(50, 230, 320, 25);
        btnVolver.setBounds(130, 290, 160, 35);

        frame.add(lblTitulo);
        frame.add(lblRondas);
        frame.add(lblTotalApostado);
        frame.add(lblAciertos);
        frame.add(lblPorcentaje);
        frame.add(lblGanancia);
        frame.add(lblSaldo);
        frame.add(btnVolver);
    }

    /** Solo lee valores desde el controlador; no calcula nada. */
    private void cargarEstadisticas() {
        lblRondas.setText("Rondas jugadas: " + resultadoCtrl.getCantidadRondas());
        lblTotalApostado.setText("Monto total apostado: $" + resultadoCtrl.getTotalApostado());
        lblAciertos.setText("Cantidad de aciertos: " + resultadoCtrl.getTotalAciertos());
        lblPorcentaje.setText(String.format("Porcentaje de aciertos: %.2f%%",
                resultadoCtrl.getPorcentajeAciertos()));
        lblGanancia.setText("Ganancia o pérdida neta: $" + resultadoCtrl.getGananciaNeta());
        lblSaldo.setText("Saldo actual: $" + session.getRuleta().getSaldo());
    }

    private void configurarEventos() {
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    private void volverAlMenu() {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(session);
        ventanaMenu.mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}