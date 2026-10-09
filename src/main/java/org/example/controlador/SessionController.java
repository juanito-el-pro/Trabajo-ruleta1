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
        // Usuarios de prueba, igual que antes
        usuarios.add(new Usuario("admin", "7777", "Administrador"));
        usuarios.add(new Usuario("juan", "1234", "Juan"));
    }

    /** Registra un usuario nuevo. Lanza excepción si los datos no son válidos. */
    public void registrarUsuario(String usuario, String clave, String nombre) {
        if (usuario == null || usuario.isBlank()
                || clave == null || clave.isBlank()
                || nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        usuarios.add(new Usuario(usuario, clave, nombre));
    }

    /**
     * Intenta iniciar sesión. Si las credenciales son válidas:
     *  - guarda el usuario como actual,
     *  - crea su Ruleta (con saldo temporal de prueba),
     *  - devuelve true.
     * Si no, devuelve false y no cambia el estado.
     */
    public boolean iniciarSession(String usuario, String clave) {
        for (Usuario u : usuarios) {
            if (u.validarCredenciales(usuario, clave)) {
                this.usuarioActual = u;
                this.ruleta = new Ruleta(1000);  // ← temporal para pruebas
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

    /** Cambia el nombre del usuario actual. */
    public void setNombreUsuario(String nuevoNombre) {
        if (hayUsuario()) {
            usuarioActual.setNombre(nuevoNombre);
        }
    }
}
