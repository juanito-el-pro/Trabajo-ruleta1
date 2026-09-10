import javax.swing.*;

public class VentanaRegistro {

    // Objetos visuales para la ventana
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");

    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();

    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();

    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();

    private final JButton btnRegistrar = new JButton("Registrar");

    public VentanaRegistro() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
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
        btnRegistrar.addActionListener(e -> registrarUsuario());


    }
    public void abrirVentana() {
        //Contraparte de mostrarVentana en VentanLogin

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void registrarUsuario() {
        String nombre = txtNombre.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword());

        if (nombre.isEmpty() || usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios");
            return;
        }

        VentanaLogin.USUARIOS.add(new Usuario(usuario, clave, nombre));

        JOptionPane.showMessageDialog(frame, "Usuario registrado correctamente");

        frame.dispose();

        VentanaLogin ventanaLogin = new VentanaLogin();
        ventanaLogin.mostrarVentana();
    }
}


