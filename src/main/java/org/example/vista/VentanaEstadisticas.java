package org.example.vista;

import org.example.controlador.ResultadoController;
import org.example.controlador.SessionController;
import org.example.modelo.Estadisticas;

import javax.swing.*;

public class VentanaEstadisticas {

    private final SessionController session;
    private final ResultadoController resultadoCtrl;

    private final JFrame frame = new JFrame("Estadísticas - Casino Black Cat");

    private final JLabel lblTitulo = new JLabel("Estadísticas de la Ruleta");

    // Nuevas metricas
    private final JLabel lblTotalJugadas = new JLabel();
    private final JLabel lblVictorias = new JLabel();
    private final JLabel lblPorcentaje = new JLabel();
    private final JLabel lblRachaMaxima = new JLabel();
    private final JLabel lblTipoMasJugado = new JLabel();

    private final JLabel lblSaldo = new JLabel();

    private final JButton btnVolver = new JButton("Volver al menú");

    public VentanaEstadisticas(SessionController session) {
        this.session = session;
        this.resultadoCtrl = new ResultadoController(session.getRuleta(), session);

        configurarVentana();
        agregarComponentes();
        cargarEstadisticas();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(420, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblTitulo.setBounds(120, 20, 200, 30);

        lblTotalJugadas.setBounds(50, 80, 320, 25);
        lblVictorias.setBounds(50, 110, 320, 25);
        lblPorcentaje.setBounds(50, 140, 320, 25);
        lblRachaMaxima.setBounds(50, 170, 320, 25);
        lblTipoMasJugado.setBounds(50, 200, 320, 25);

        lblSaldo.setBounds(50, 240, 320, 25);

        btnVolver.setBounds(130, 310, 160, 35);

        frame.add(lblTitulo);
        frame.add(lblTotalJugadas);
        frame.add(lblVictorias);
        frame.add(lblPorcentaje);
        frame.add(lblRachaMaxima);
        frame.add(lblTipoMasJugado);
        frame.add(lblSaldo);
        frame.add(btnVolver);
    }

    /** Solo lee valores desde el controlador; no calcula nada. */
    private void cargarEstadisticas() {
        Estadisticas stats = resultadoCtrl.getEstadisticasUsuario();

        lblTotalJugadas.setText("Total de jugadas: " + stats.getTotalJugadas());
        lblVictorias.setText("Victorias: " + stats.getVictorias());
        lblPorcentaje.setText(String.format("Porcentaje de victorias: %.2f%%", stats.getPorcentajeVictorias()));
        lblRachaMaxima.setText("Racha máxima de aciertos: " + stats.getRachaMaxima());

        String tipo = (stats.getTipoMasJugado() != null) ? stats.getTipoMasJugado().toString() : "Ninguno";
        lblTipoMasJugado.setText("Apuesta más jugada: " + tipo);

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