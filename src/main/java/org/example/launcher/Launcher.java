package org.example.launcher;

import org.example.controlador.SessionController;
import org.example.vista.VentanaLogin;

public class Launcher {

    public static void main(String[] args) {
        // Se crea UNA sola sesión para toda la aplicación
        SessionController session = new SessionController();

        VentanaLogin ventanaLogin = new VentanaLogin(session);
        ventanaLogin.mostrarVentana();
    }
}