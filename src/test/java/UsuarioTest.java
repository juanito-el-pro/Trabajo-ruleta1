import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void validarCredencialesCorrectas() {
        Usuario usuario = new Usuario("juan", "1234", "Juan");

        assertTrue(usuario.validarCredenciales("juan", "1234"));
    }
    @Test
    void validarUsuarioIncorrecto() {
        Usuario usuario = new Usuario("juan", "1234", "Juan");

        assertFalse(usuario.validarCredenciales("pedro", "1234"));
    }
    @Test
    void validarClaveIncorrecta() {
        Usuario usuario = new Usuario("juan", "1234", "Juan");

        assertFalse(usuario.validarCredenciales("juan", "9999"));
    }
    @Test
    void obtenerNombreCorrectamente() {
        Usuario usuario = new Usuario("juan", "1234", "Juan");

        assertEquals("Juan", usuario.getNombre());
    }

}
