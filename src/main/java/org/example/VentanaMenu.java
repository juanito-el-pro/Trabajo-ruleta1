package org.example;

import javax.swing.*;
import org.example.modelo.Ruleta;

public class VentanaMenu {

    private final JFrame frame = new JFrame("Casino Black Cat - Menu");
    private final JButton btnJugar = new JButton("Jugar Ruleta");
    private final JButton btnEstadisticas = new JButton("Estadísticas");
    private final JButton btnSalir = new JButton("Salir");

    private final Ruleta ruleta;

    /** Constructor de entrada (desde el login). Crea la ruleta con saldo de prueba. */
    public VentanaMenu() {
        this(new Ruleta(1000));   // ← TEMPORAL: 1000 de saldo para probar
    }

    /** Constructor que recibe una Ruleta existente (usado al volver de otras ventanas). */
    public VentanaMenu(Ruleta ruleta) {
        this.ruleta = ruleta;
        configurarVentana();
        agregarComponentes();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        btnJugar.setBounds(120, 50, 160, 40);
        btnEstadisticas.setBounds(120, 110, 160, 40);
        btnSalir.setBounds(120, 170, 160, 40);

        frame.add(btnJugar);
        frame.add(btnEstadisticas);
        frame.add(btnSalir);
    }

    private void configurarEventos() {
        btnJugar.addActionListener(e -> abrirRuleta());
        btnEstadisticas.addActionListener(e -> abrirEstadisticas());
        btnSalir.addActionListener(e -> salir());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void abrirRuleta() {
        frame.dispose();
        VentanaRuleta ventanaRuleta = new VentanaRuleta(ruleta);
        ventanaRuleta.mostrarVentana();
    }

    private void abrirEstadisticas() {
        frame.dispose();
        VentanaEstadisticas ventanaEstadisticas = new VentanaEstadisticas(ruleta);
        ventanaEstadisticas.mostrarVentana();
    }

    private void salir() {
        frame.dispose();
        VentanaLogin ventanaLogin = new VentanaLogin();
        ventanaLogin.mostrarVentana();
    }
}