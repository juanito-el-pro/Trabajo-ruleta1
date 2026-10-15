package org.example.vista;

import org.example.controlador.ResultadoController;
import org.example.controlador.SessionController;

import javax.swing.*;
import java.util.List;

public class VentanaHistorial {

    private final SessionController session;
    private final ResultadoController resultadoCtrl;

    private final JFrame frame = new JFrame("Historial - Casino Black Cat");

    private final JLabel lblTitulo = new JLabel("Historial de jugadas");
    private final JList<String> listaHistorial = new JList<>();
    private final JScrollPane scroll = new JScrollPane(listaHistorial);

    private final JButton btnVolver = new JButton("Volver al menú");

    public VentanaHistorial(SessionController session) {
        this.session = session;
        this.resultadoCtrl = new ResultadoController(session.getRuleta(), session);

        configurarVentana();
        agregarComponentes();
        cargarHistorial();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(620, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    private void agregarComponentes() {
        lblTitulo.setBounds(40, 15, 400, 30);
        scroll.setBounds(40, 55, 540, 280);
        btnVolver.setBounds(220, 345, 180, 35);

        frame.add(lblTitulo);
        frame.add(scroll);
        frame.add(btnVolver);
    }

    /** Pide el historial del usuario al controlador; la vista solo lo muestra. */
    private void cargarHistorial() {
        List<String> lineas = resultadoCtrl.getHistorialComoTexto();

        if (lineas.isEmpty()) {
            listaHistorial.setListData(new String[]{"Aún no hay jugadas registradas."});
        } else {
            listaHistorial.setListData(lineas.toArray(new String[0]));
        }
    }

    private void configurarEventos() {
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    private void volverAlMenu() {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(session);
        ventanaMenu.mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
