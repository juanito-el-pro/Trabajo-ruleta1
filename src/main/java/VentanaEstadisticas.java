import javax.swing.*;

public class VentanaEstadisticas {

    // Ventana
    private final JFrame frame = new JFrame("Estadísticas - Casino Black Cat");

    // Componentes
    private final JLabel lblTitulo = new JLabel("Estadísticas de la Ruleta");

    private final JLabel lblRondas = new JLabel();
    private final JLabel lblTotalApostado = new JLabel();
    private final JLabel lblAciertos = new JLabel();
    private final JLabel lblPorcentaje = new JLabel();
    private final JLabel lblGanancia = new JLabel();

    private final JButton btnVolver = new JButton("Volver al menú");

    public VentanaEstadisticas() {
        configurarVentana();
        agregarComponentes();
        cargarEstadisticas();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(420, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblTitulo.setBounds(120, 20, 200, 30);

        lblRondas.setBounds(50, 80, 320, 25);
        lblTotalApostado.setBounds(50, 110, 320, 25);
        lblAciertos.setBounds(50, 140, 320, 25);
        lblPorcentaje.setBounds(50, 170, 320, 25);
        lblGanancia.setBounds(50, 200, 320, 25);

        btnVolver.setBounds(130, 260, 160, 35);

        frame.add(lblTitulo);
        frame.add(lblRondas);
        frame.add(lblTotalApostado);
        frame.add(lblAciertos);
        frame.add(lblPorcentaje);
        frame.add(lblGanancia);
        frame.add(btnVolver);
    }

    /**
     * Pide a Ruleta los valores calculados y los coloca en las etiquetas.
     * La ventana no calcula nada: solo muestra.
     */
    private void cargarEstadisticas() {
        int rondas = Ruleta.historialSize;
        int totalApostado = Ruleta.calcularTotalApostado();
        int totalAciertos = Ruleta.calcularTotalAciertos();
        double porcentaje = Ruleta.calcularPorcentajeAciertos();
        int gananciaNeta = Ruleta.calcularGananciaNeta();

        lblRondas.setText("Rondas jugadas: " + rondas);
        lblTotalApostado.setText("Monto total apostado: $" + totalApostado);
        lblAciertos.setText("Cantidad de aciertos: " + totalAciertos);
        lblPorcentaje.setText(String.format("Porcentaje de aciertos: %.2f%%", porcentaje));
        lblGanancia.setText("Ganancia o pérdida neta: $" + gananciaNeta);
    }

    private void configurarEventos() {
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    private void volverAlMenu() {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ventanaMenu.mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
