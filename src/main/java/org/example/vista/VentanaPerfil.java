package org.example.vista;

import org.example.controlador.RuletaController;
import org.example.controlador.SessionController;

import javax.swing.*;

public class VentanaPerfil {

    private final SessionController session;
    private final RuletaController ruletaCtrl;

    private final JFrame frame = new JFrame("Perfil - Casino Black Cat");

    // Datos actuales
    private final JLabel lblNombreActual = new JLabel();
    private final JLabel lblSaldoActual = new JLabel();

    // Modificar nombre
    private final JLabel lblNuevoNombre = new JLabel("Nuevo nombre:");
    private final JTextField txtNuevoNombre = new JTextField();
    private final JButton btnCambiarNombre = new JButton("Cambiar nombre");

    // Recargar saldo
    private final JLabel lblMontoRecarga = new JLabel("Monto a recargar:");
    private final JTextField txtMontoRecarga = new JTextField();
    private final JButton btnRecargar = new JButton("Recargar");

    private final JButton btnVolver = new JButton("Volver al menú");

    public VentanaPerfil(SessionController session) {
        this.session = session;
        this.ruletaCtrl = new RuletaController(session.getRuleta());

        configurarVentana();
        agregarComponentes();
        configurarEventos();
        actualizarDatos();
    }

    private void configurarVentana() {
        frame.setSize(440, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblNombreActual.setBounds(40, 20, 360, 25);
        lblSaldoActual.setBounds(40, 50, 360, 25);

        lblNuevoNombre.setBounds(40, 100, 130, 25);
        txtNuevoNombre.setBounds(180, 100, 200, 25);
        btnCambiarNombre.setBounds(140, 140, 160, 30);

        lblMontoRecarga.setBounds(40, 200, 130, 25);
        txtMontoRecarga.setBounds(180, 200, 200, 25);
        btnRecargar.setBounds(140, 240, 160, 30);

        btnVolver.setBounds(140, 320, 160, 35);

        frame.add(lblNombreActual);
        frame.add(lblSaldoActual);
        frame.add(lblNuevoNombre);
        frame.add(txtNuevoNombre);
        frame.add(btnCambiarNombre);
        frame.add(lblMontoRecarga);
        frame.add(txtMontoRecarga);
        frame.add(btnRecargar);
        frame.add(btnVolver);
    }

    private void configurarEventos() {
        btnCambiarNombre.addActionListener(e -> cambiarNombre());
        btnRecargar.addActionListener(e -> recargarSaldo());
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** Refresca las etiquetas con los datos actuales de la sesión. */
    private void actualizarDatos() {
        lblNombreActual.setText("Nombre: " + session.getNombreUsuario());
        lblSaldoActual.setText("Saldo actual: $" + ruletaCtrl.getSaldo());
    }

    private void cambiarNombre() {
        String nuevo = txtNuevoNombre.getText().trim();

        try {
            session.setNombreUsuario(nuevo);
            actualizarDatos();
            txtNuevoNombre.setText("");
            JOptionPane.showMessageDialog(frame, "Nombre actualizado.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }

    private void recargarSaldo() {
        String texto = txtMontoRecarga.getText().trim();

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

        try {
            ruletaCtrl.depositar(monto);
            actualizarDatos();
            txtMontoRecarga.setText("");
            JOptionPane.showMessageDialog(frame, "Saldo recargado.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }

    private void volverAlMenu() {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(session);
        ventanaMenu.mostrarVentana();
    }
}
