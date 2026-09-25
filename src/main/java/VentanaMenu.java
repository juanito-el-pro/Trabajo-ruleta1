import javax.swing.*;

public class VentanaMenu {

    //Ventana principal del menu del programa
    private final JFrame frame = new JFrame("Casino Black Cat - Menu");

    // Botones del menú
    private final JButton btnJugar = new JButton("Jugar Ruleta");
    private final JButton btnEstadisticas = new JButton("Estadísticas");
    private final JButton btnSalir = new JButton("Salir");

    public VentanaMenu() {
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

        VentanaRuleta ventanaRuleta = new VentanaRuleta();
        ventanaRuleta.mostrarVentana();
    }

    private void abrirEstadisticas() {
        frame.dispose();

        VentanaEstadisticas ventanaEstadisticas = new VentanaEstadisticas();
        ventanaEstadisticas.mostrarVentana();
    }

    private void salir() {
        frame.dispose();
    }
}