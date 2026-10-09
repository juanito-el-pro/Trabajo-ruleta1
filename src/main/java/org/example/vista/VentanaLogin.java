package org.example.vista;

import org.example.controlador.SessionController;

import javax.swing.*;

public class VentanaLogin {

    private final SessionController session;

    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistro = new JButton("Registrarse");

    public VentanaLogin(SessionController session) {
        this.session = session;
        configurarVentana();
        agregarComponentes();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblUsuario.setBounds(50, 40, 100, 25);
        txtUsuario.setBounds(150, 40, 180, 25);
        lblClave.setBounds(50, 80, 100, 25);
        txtClave.setBounds(150, 80, 180, 25);
        btnIngresar.setBounds(150, 130, 100, 30);
        btnRegistro.setBounds(140, 175, 120, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        frame.add(btnRegistro);
    }

    private void configurarEventos() {
        btnIngresar.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> abrirRegistro());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** La vista solo pregunta al controlador si el login fue exitoso. */
    private void login() {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());

        boolean ok = session.iniciarSession(usuario, clave);

        if (ok) {
            JOptionPane.showMessageDialog(frame, "Bienvenido " + session.getNombreUsuario());
            frame.dispose();
            VentanaMenu ventanaMenu = new VentanaMenu(session);
            ventanaMenu.mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o clave incorrectos");
        }
    }

    private void abrirRegistro() {
        frame.dispose();
        VentanaRegistro ventanaRegistro = new VentanaRegistro(session);
        ventanaRegistro.mostrarVentana();
    }
}