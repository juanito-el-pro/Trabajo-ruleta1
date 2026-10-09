package org.example;

import javax.swing.*;
import org.example.modelo.Ruleta;
import org.example.modelo.Resultado;
import org.example.modelo.TipoApuesta;

public class VentanaRuleta {

    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");
    private final Ruleta ruleta;

    private final JLabel lblTipo = new JLabel("Tipo de apuesta:");
    private final JComboBox<String> cmbTipo =
            new JComboBox<>(new String[]{"Rojo", "Negro", "Par", "Impar"});

    private final JLabel lblMonto = new JLabel("Monto a apostar:");
    private final JTextField txtMonto = new JTextField();

    private final JButton btnGirar = new JButton("Girar");
    private final JButton btnVolver = new JButton("Volver");

    private final JLabel lblResultado = new JLabel("Resultado: ");

    public VentanaRuleta(Ruleta ruleta) {
        this.ruleta = ruleta;
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

    private TipoApuesta obtenerTipoApuesta() {
        String tipo = (String) cmbTipo.getSelectedItem();
        switch (tipo) {
            case "Rojo":  return TipoApuesta.ROJO;
            case "Negro": return TipoApuesta.NEGRO;
            case "Par":   return TipoApuesta.PAR;
            case "Impar": return TipoApuesta.IMPAR;
            default:      return TipoApuesta.ROJO;
        }
    }

    private void girar() {
        TipoApuesta tipo = obtenerTipoApuesta();
        String texto = txtMonto.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Ingrese un monto.");
            return;
        }

        int monto;
        try {
            monto = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Ingrese un monto numérico.");
            return;
        }

        Resultado r;
        try {
            r = ruleta.apostar(tipo, monto);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
            return;
        }

        String color = ruleta.obtenerColor(r.getNumero());
        String estado = r.isAcierto() ? "GANASTE" : "PERDISTE";

        lblResultado.setText(
                "<html>Resultado: " + estado +
                        "<br>Número: " + r.getNumero() + " (" + color + ")" +
                        "<br>Tipo: " + r.getTipo() +
                        "<br>Monto: $" + r.getMonto() +
                        "<br>Saldo actual: $" + ruleta.getSaldo() + "</html>"
        );

        txtMonto.setText("");
    }

    private void volverAlMenu() {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(ruleta);
        ventanaMenu.mostrarVentana();
    }
}