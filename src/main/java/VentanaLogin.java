import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    public static final List <Usuario> USUARIOS = new ArrayList<>();
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistro = new JButton("Registrarse");
    /**
     * Constructor que inicializa la ventana de inicio de sesión.
     * Configura sus componentes y eventos.
     */
    public VentanaLogin() {

// TODO: Inicializar y configurar la ventana
    inicializarUsuarios();
    configurarVentana();
    agregarComponentes();
    configurarEventos();

    }
    private void inicializarUsuarios() {
        //Agrega usuarios en caso de que no hayan

        if (USUARIOS.isEmpty()) {
            USUARIOS.add(new Usuario("admin", "7777", "Administrador"));
            USUARIOS.add(new Usuario("juan", "1234", "Juan"));
        }
    }
    private void configurarVentana() {
        frame.setSize(400, 250); //Define el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana debe terminar el programa
        frame.setLayout(null);
    }
    private void agregarComponentes() {
        lblUsuario.setBounds(50, 40, 100, 25); //Visualmente donde se ubicara el texto del "Usuario:"
        txtUsuario.setBounds(150, 40, 180, 25); //texto que se escribe visualmente al lado

        lblClave.setBounds(50, 80, 100, 25); // visualmente donde se ubica el texto del "Clave:"
        txtClave.setBounds(150, 80, 180, 25); // texto que se escribe visualmente al lado

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
        //redirige segun el boton marcadado
        btnIngresar.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> abrirRegistro());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null); // TODO: Centrar y mostrar la ventana
        frame.setVisible(true);
    }
    /**
     * Gestiona el inicio de sesión al presionar el botón.
     * Debe validar las credenciales ingresadas y abrir la siguiente
     * ventana o mostrar un mensaje de error.
     */
    private void login() {
 // TODO: Implementar la lógica de inicio de sesión

        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());

        String nombre = validarCredenciales(usuario, clave);

        if (!nombre.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Bienvenido " + nombre);
            frame.dispose();
            Ruleta.menu();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o clave incorrectos");
        }
    }
    /**
     * Valida las credenciales ingresadas utilizando la lista de usuarios.
     *
     * @param u nombre de usuario ingresado
     * @param p contraseña ingresada
     * @return el nombre del usuario si las credenciales son válidas o una cadena vacía
    si no existe una coincidencia
     */
    private String validarCredenciales(String u, String p) {
// TODO: Recorrer la lista y validar las credenciales
        for (Usuario usuario : USUARIOS) {
            if (usuario.validarCredenciales(u, p)) {
                return usuario.getNombre();
            }
        }
        return "";
    }
    /**
     * Abre la ventana de registro para crear un nuevo usuario.
     * Debe cerrar la ventana actual e invocar a VentanaRegistro.
     */
    private void abrirRegistro() {
// TODO: Cerrar la ventana actual y abrir la ventana de registro
        frame.dispose();

        VentanaRegistro ventanaRegistro = new VentanaRegistro();
        ventanaRegistro.abrirVentana();
    }
}
