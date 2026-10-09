package org.example.vista;

import org.example.controlador.ResultadoController;
import org.example.controlador.RuletaController;
import org.example.controlador.SessionController;
import org.example.modelo.Resultado;
import org.example.modelo.TipoApuesta;

import javax.swing.*;

public class VentanaRuleta {

    private final SessionController session;
    private final RuletaController ruletaCtrl;
    private final ResultadoController resultadoCtrl;

    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");

    private final JLabel lblTipo = new JLabel("Tipo de apuesta:");
    private final JComboBox<TipoApuesta> cmbTipo =
            new JComboBox<>(TipoApuesta.values());

    private final JLabel lblMonto = new JLabel("Monto a apostar:");
    private final JTextField txtMonto = new JTextField();

    private final JButton btnGirar = new JButton("Girar");
    private final JButton btnVolver = new JButton("Volver");

    private final JLabel lblResultado = new JLabel("Resultado: ");

    public VentanaRuleta(SessionController session) {
        this.session = session;
        this.ruletaCtrl = new RuletaController(session.getRuleta());
        this.resultadoCtrl = new ResultadoController(session.getRuleta());

        configurarVentana();
        agregarComponentes();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblTipo.setBounds(50, 40, 120, 25);
        cmbTipo.setBounds(180, 40, 180, 25);

        lblMonto.setBounds(50, 80, 120, 25);
        txtMonto.setBounds(180, 80, 180, 25);

        btnGirar.setBounds(150, 130, 120, 35);

        lblResultado.setBounds(50, 180, 340, 90);

        btnVolver.setBounds(150, 280, 120, 35);

        frame.add(lblTipo);
        frame.add(cmbTipo);
        frame.add(lblMonto);
        frame.add(txtMonto);
        frame.add(btnGirar);
        frame.add(lblResultado);
        frame.add(btnVolver);
    }

    private void configurarEventos() {
        btnGirar.addActionListener(e -> girar());
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void girar() {
        TipoApuesta tipo = (TipoApuesta) cmbTipo.getSelectedItem();

        String texto = txtMonto.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Ingrese un monto.");
            return;
        }

        int monto;
        try {
            monto = Integer.parseInt(texto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un monto numérico.");
            return;
        }

        Resultado r;
        try {
            r = ruletaCtrl.realizarApuesta(tipo, monto);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
            return;
        }

        lblResultado.setText(resultadoCtrl.formatearResultado(r));
        txtMonto.setText("");
    }

    private void volverAlMenu() {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(session);
        ventanaMenu.mostrarVentana();
    }
}