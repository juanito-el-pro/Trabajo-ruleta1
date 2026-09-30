import javax.swing.*;

public class VentanaRuleta {

    // Ventana
    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");

    // Componentes
    private final JLabel lblTipo = new JLabel("Tipo de apuesta:");
    private final JComboBox<String> cmbTipo =
            new JComboBox<>(new String[]{"Rojo", "Negro", "Par", "Impar"});

    private final JLabel lblMonto = new JLabel("Monto a apostar:");
    private final JTextField txtMonto = new JTextField();

    private final JButton btnGirar = new JButton("Girar");
    private final JButton btnVolver = new JButton("Volver");

    private final JLabel lblResultado = new JLabel("Resultado: ");

    public VentanaRuleta() {
        configurarVentana();
        agregarComponentes();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {

        lblTipo.setBounds(50, 40, 120, 25);
        cmbTipo.setBounds(180, 40, 180, 25);

        lblMonto.setBounds(50, 80, 120, 25);
        txtMonto.setBounds(180, 80, 180, 25);

        btnGirar.setBounds(150, 130, 120, 35);

        lblResultado.setBounds(50, 180, 340, 70);

        btnVolver.setBounds(150, 270, 120, 35);

        frame.add(lblTipo);
        frame.add(cmbTipo);
        frame.add(lblMonto);
        frame.add(txtMonto);
        frame.add(btnGirar);
        frame.add(lblResultado);
        frame.add(btnVolver);
    }

    private void configurarEventos() {

        btnGirar.addActionListener(e -> girar());

        btnVolver.addActionListener(e -> volverAlMenu());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void girar() {

    }

    private void volverAlMenu() {
        frame.dispose();

        VentanaMenu ventanaMenu = new VentanaMenu();
        ventanaMenu.mostrarVentana();
    }
}