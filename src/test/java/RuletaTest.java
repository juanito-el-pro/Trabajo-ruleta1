//import org.example.modelo.Ruleta;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class RuletaTest {
//
//    @BeforeEach
//    void limpiar() {
//        Ruleta.reiniciarHistorial();
//    }
//
//    // ===== esRojo =====
//    @Test
//    void rojoConocidoEsRojo() {
//        assertTrue(Ruleta.esRojo(1));
//        assertTrue(Ruleta.esRojo(36));
//        assertTrue(Ruleta.esRojo(19));
//    }
//
//    @Test
//    void negroConocidoNoEsRojo() {
//        assertFalse(Ruleta.esRojo(2));
//        assertFalse(Ruleta.esRojo(0));
//    }
//
//    // ===== obtenerColor =====
//    @Test
//    void ceroEsVerde() {
//        assertEquals("Verde", Ruleta.obtenerColor(0));
//    }
//
//    @Test
//    void colorDeRojoYNegro() {
//        assertEquals("Rojo", Ruleta.obtenerColor(3));
//        assertEquals("Negro", Ruleta.obtenerColor(4));
//    }
//
//    // ===== esMontoValido =====
//    @Test
//    void montoValidoSoloSiEsPositivo() {
//        assertTrue(Ruleta.esMontoValido(1));
//        assertTrue(Ruleta.esMontoValido(1000));
//        assertFalse(Ruleta.esMontoValido(0));
//        assertFalse(Ruleta.esMontoValido(-5));
//    }
//
//    // ===== evaluarResultado =====
//    @Test
//    void apuestaRojo() {
//        assertTrue(Ruleta.evaluarResultado(1, 'R'));
//        assertFalse(Ruleta.evaluarResultado(2, 'R'));
//        assertFalse(Ruleta.evaluarResultado(0, 'R'));
//    }
//
//    @Test
//    void apuestaNegroNuncaGanaConCero() {
//        assertTrue(Ruleta.evaluarResultado(2, 'N'));
//        assertFalse(Ruleta.evaluarResultado(0, 'N'));
//    }
//
//    @Test
//    void apuestaParNuncaGanaConCero() {
//        assertTrue(Ruleta.evaluarResultado(4, 'P'));
//        assertFalse(Ruleta.evaluarResultado(3, 'P'));
//        assertFalse(Ruleta.evaluarResultado(0, 'P'));
//    }
//
//    @Test
//    void apuestaImpar() {
//        assertTrue(Ruleta.evaluarResultado(3, 'I'));
//        assertFalse(Ruleta.evaluarResultado(4, 'I'));
//    }
//
//    // ===== girarRuleta =====
//    @Test
//    void giroSiempreDentroDelRango() {
//        for (int i = 0; i < 1000; i++) {
//            int n = Ruleta.girarRuleta();
//            assertTrue(n >= 0 && n <= 36, "Número fuera de rango: " + n);
//        }
//    }
//
//    // ===== Historial y cálculos =====
//    @Test
//    void historialEmpiezaVacio() {
//        assertEquals(0, Ruleta.historialSize);
//        assertEquals(0, Ruleta.calcularTotalApostado());
//        assertEquals(0, Ruleta.calcularTotalAciertos());
//        assertEquals(0, Ruleta.calcularGananciaNeta());
//        assertEquals(0.0, Ruleta.calcularPorcentajeAciertos(), 0.0001);
//    }
//
//    @Test
//    void registrarYCalcularTotales() {
//        Ruleta.registrarResultado(5, 100, true);
//        Ruleta.registrarResultado(2, 50, false);
//
//        assertEquals(2, Ruleta.historialSize);
//        assertEquals(150, Ruleta.calcularTotalApostado());
//        assertEquals(1, Ruleta.calcularTotalAciertos());
//        assertEquals(50, Ruleta.calcularGananciaNeta()); // +100 - 50
//        assertEquals(50.0, Ruleta.calcularPorcentajeAciertos(), 0.0001);
//    }
//}
