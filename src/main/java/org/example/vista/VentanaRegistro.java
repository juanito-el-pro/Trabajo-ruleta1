package org.example.vista;

import org.example.controlador.SessionController;

import javax.swing.*;

public class VentanaRegistro {

    private final SessionController session;

    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnRegistrar = new JButton("Registrar");

    public VentanaRegistro(SessionController session) {
        this.session = session;
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
        lblNombre.setBounds(50, 40, 100, 25);
        txtNombre.setBounds(150, 40, 180, 25);
        lblUsuario.setBounds(50, 80, 100, 25);
        txtUsuario.setBounds(150, 80, 180, 25);
        lblClave.setBounds(50, 120, 100, 25);
        txtClave.setBounds(150, 120, 180, 25);
        btnRegistrar.setBounds(140, 170, 120, 30);

        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnRegistrar);
    }

    private void configurarEventos() {
        btnRegistrar.addActionListener(e -> registrarUsuario());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void registrarUsuario() {
        String nombre = txtNombre.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword());

        try {
            session.registrarUsuario(usuario, clave, nombre);
            JOptionPane.showMessageDialog(frame, "Usuario registrado correctamente");
            frame.dispose();
            VentanaLogin ventanaLogin = new VentanaLogin(session);
            ventanaLogin.mostrarVentana();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
}