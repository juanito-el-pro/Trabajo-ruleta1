package org.example.vista;

import org.example.controlador.SessionController;

import javax.swing.*;

public class VentanaMenu {

    private final SessionController session;

    private final JFrame frame = new JFrame("Casino Black Cat - Menu");

    private final JLabel lblBienvenida = new JLabel();
    private final JLabel lblSaldo = new JLabel();

    private final JButton btnPerfil = new JButton("Mi Perfil");

    private final JButton btnJugar = new JButton("Jugar Ruleta");
    private final JButton btnEstadisticas = new JButton("Estadísticas");
    private final JButton btnSalir = new JButton("Salir");

    public VentanaMenu(SessionController session) {
        this.session = session;
        configurarVentana();
        agregarComponentes();
        configurarEventos();
        actualizarDatos();
    }

    private void configurarVentana() {
        frame.setSize(400, 340);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblBienvenida.setBounds(30, 15, 340, 25);
        lblSaldo.setBounds(30, 40, 340, 25);
// botones a partir de y=90 en adelante (los del bloque de arriba)

        btnJugar.setBounds(120, 90, 160, 40);
        btnEstadisticas.setBounds(120, 140, 160, 40);
        btnPerfil.setBounds(120, 190, 160, 40);
        btnSalir.setBounds(120, 240, 160, 40);

        frame.add(lblBienvenida);
        frame.add(lblSaldo);
        frame.add(btnJugar);
        frame.add(btnEstadisticas);
        frame.add(btnPerfil);
        frame.add(btnSalir);
    }

    /** Muestra el nombre del usuario y su saldo actual. */
    private void actualizarDatos() {
        lblBienvenida.setText("Bienvenido, " + session.getNombreUsuario());
        int saldo = session.getRuleta().getSaldo();
        lblSaldo.setText("Saldo actual: $" + saldo);
    }

    private void configurarEventos() {
        btnJugar.addActionListener(e -> abrirRuleta());
        btnEstadisticas.addActionListener(e -> abrirEstadisticas());
        btnPerfil.addActionListener(e -> abrirPerfil());
        btnSalir.addActionListener(e -> cerrarSesion());
    }

    private void abrirPerfil() {
        frame.dispose();
        VentanaPerfil ventanaPerfil = new VentanaPerfil(session);
        ventanaPerfil.mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void abrirRuleta() {
        frame.dispose();
        VentanaRuleta ventanaRuleta = new VentanaRuleta(session);
        ventanaRuleta.mostrarVentana();
    }

    private void abrirEstadisticas() {
        frame.dispose();
        VentanaEstadisticas ventanaEstadisticas = new VentanaEstadisticas(session);
        ventanaEstadisticas.mostrarVentana();
    }

    /** Cierra la sesión y vuelve al login. */
    private void cerrarSesion() {
        frame.dispose();
        session.cerrarSesion();
        VentanaLogin ventanaLogin = new VentanaLogin(session);
        ventanaLogin.mostrarVentana();
    }
}