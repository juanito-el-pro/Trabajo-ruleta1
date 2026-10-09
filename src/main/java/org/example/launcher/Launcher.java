package org.example.launcher;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import org.example.controlador.SessionController;
import org.example.vista.VentanaLogin;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {

        // 1. Aplicar el look & feel ANTES de crear cualquier ventana
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
        } catch (Exception e) {
            // Si falla, seguimos con el aspecto por defecto de Swing
            e.printStackTrace();
        }

        // 2. Crear la sesión única
        SessionController session = new SessionController();

        // 3. Abrir la ventana de login
        VentanaLogin ventanaLogin = new VentanaLogin(session);
        ventanaLogin.mostrarVentana();
    }
}