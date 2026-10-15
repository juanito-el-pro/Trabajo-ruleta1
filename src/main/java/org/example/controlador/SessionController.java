package org.example.controlador;

import org.example.modelo.Ruleta;
import org.example.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SessionController {

    private final List<Usuario> usuarios;
    private Usuario usuarioActual;
    private Ruleta ruleta;

    public SessionController() {
        this.usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "7777", "Administrador"));
        usuarios.add(new Usuario("juan", "1234", "Juan"));
    }

    public void registrarUsuario(String usuario, String clave, String nombre) {
        if (usuario == null || usuario.isBlank()
                || clave == null || clave.isBlank()
                || nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        usuarios.add(new Usuario(usuario, clave, nombre));
    }

    public boolean iniciarSession(String usuario, String clave) {
        for (Usuario u : usuarios) {
            if (u.validarCredenciales(usuario, clave)) {
                this.usuarioActual = u;
                this.ruleta = new Ruleta();  // saldo 0
                return true;
            }
        }
        return false;
    }

    public void cerrarSesion() {
        usuarioActual = null;
        ruleta = null;
    }

    public boolean hayUsuario() {
        return usuarioActual != null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public String getNombreUsuario() {
        return hayUsuario() ? usuarioActual.getNombre() : "";
    }

    public Ruleta getRuleta() {
        return ruleta;
    }

    public void setNombreUsuario(String nuevoNombre) {
        if (hayUsuario()) {
            usuarioActual.setNombre(nuevoNombre);
        }
    }
}