package org.example.modelo;

public class Usuario {

    private String username;
    private String password;
    private String nombre;

    /** Constructor con parámetros. */
    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        setNombre(nombre);
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
}