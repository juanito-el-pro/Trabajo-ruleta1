import javax.swing.*;
public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    public static final List USUARIOS = new ArrayList<>();
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    /**
     * Constructor que inicializa la ventana de inicio de sesión.
     * Configura sus componentes y eventos.
     */
    public VentanaLogin() {
// TODO: Agregar los usuarios iniciales a la lista
// TODO: Inicializar y configurar la ventana

        USUARIOS.add(new Usuario("admin", "7777", "Administrador")); //credenciales almacenadas de usuarios para "probar el codigo"
        USUARIOS.add(new Usuario("juan", "1234", "Juan"));

        frame.setSize(400, 250); //Define el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana debe terminar el programa
        frame.setLayout(null);

        lblUsuario.setBounds(50, 40, 100, 25); //Visualmente donde se ubicara el texto del "Usuario:"
        txtUsuario.setBounds(150, 40, 180, 25); //texto que se escribe visualmente al lado

        lblClave.setBounds(50, 80, 100, 25); // visualmente donde se ubica el texto del "Clave:"
        txtClave.setBounds(150, 80, 180, 25); // texto que se escribe visualmente al lado

        btnIngresar.setBounds(150, 130, 100, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
   lblUsuario.setBounds(50, 40, 100, 25);
        txtUsuario.setBounds(150, 40, 180, 25);

        lblClave.setBounds(50, 80, 100, 25);
        txtClave.setBounds(150, 80, 180, 25);

        btnIngresar.setBounds(150, 130, 100, 30); //Boton visual

        frame.add(lblUsuario); //agrega todos estos componentes definidos para que esten en la ventana al JFrame
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        btnIngresar.addActionListener(e -> login()); // al presionar el boton ingresar se redirige a login

    }
    /**
     * Muestra la ventana en pantalla.
     * Debe centrarla y hacerla visible.
     */
    public void mostrarVentana() {
// TODO: Centrar y mostrar la ventana
    }
    /**
     * Gestiona el inicio de sesión al presionar el botón.
     * Debe validar las credenciales ingresadas y abrir la siguiente
     * ventana o mostrar un mensaje de error.
     */
    private void login() {
// TODO: Implementar la lógica de inicio de sesión
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
        return "";
    }
    /**
     * Abre la ventana de registro para crear un nuevo usuario.
     * Debe cerrar la ventana actual e invocar a VentanaRegistro.
     */
    private void abrirRegistro() {
// TODO: Cerrar la ventana actual y abrir la ventana de registro
    }
}
