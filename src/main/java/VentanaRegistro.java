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
    }
}


