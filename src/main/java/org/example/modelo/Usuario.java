package org.example.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String username;
    private String password;
    private String nombre;
    private final List<Resultado> historial;

    /** Constructor con parámetros. */
    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        setNombre(nombre);
        this.historial = new ArrayList<>();
    }

    /** Constructor sin parámetros: crea un usuario invitado. */
    public Usuario() {
        this("invitado", "", "Invitado");
    }

    /** Valida si las credenciales corresponden a este usuario. */
    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }

    // ===== Getters =====
    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    // ===== Setters =====
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    // ===== Historial (asociación 1 a muchos con Resultado) =====
    public void agregarResultado(Resultado r) {
        historial.add(r);
    }

    public List<Resultado> getHistorial() {
        return historial;
    }
}