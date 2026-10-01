import java.util.Random;

public class Ruleta {

    public static final int MAX_HISTORIAL = 100;
    public static final int CANTIDAD_NUMEROS = 37;

    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

     // Metodo principal: inicia el programa mostrando la ventana de login.

    public static void main(String[] args) {
        VentanaLogin ventanaLogin = new VentanaLogin();
        ventanaLogin.mostrarVentana();
    }
    /**
     *  Controla el flujo principal del programa mostrando login
     *
     */

    public static int girarRuleta() {
// regrea un valor entre 0 y 36
        return rng.nextInt(CANTIDAD_NUMEROS);
    }
    public static boolean evaluarResultado(int numero, char tipo) {
// evalua el resultado categorizado por su tipo de apuesta
        switch (tipo) {

            case 'R':
                return esRojo(numero);
            case 'N':
                return numero != 0 && !esRojo(numero);
            case 'P':
                return numero != 0 && numero % 2 == 0;
            case 'I':
                return numero % 2 != 0;
            default:
                return false;
        }
    }
    public static boolean esRojo(int n) {
// avisa si es que el numero esta en la lista de numeros rojos
        for (int numeroRojo : numerosRojos) {
            if (numeroRojo == n) {
                return true;
            }
        }
        return false;
    }
    public static String obtenerColor(int numero) {

        //obtiene el color del numero asosiado
        if (numero == 0) {
            return "Verde";
        } if (esRojo(numero)) {
            return "Rojo";
        } else {
            return "Negro";
        }
    }

    public static boolean esMontoValido(int monto) {
        return monto > 0;
    }
    // lee un numero ingresado para apostar

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
// Guarda los datos sin superar MAX_HISTORIAL.

        if (historialSize < MAX_HISTORIAL) {

            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            historialSize++;
        }
    }

    public static int calcularTotalApostado() {
        //Calcula el totalapostado
        int totalApostado = 0;

        for (int i = 0; i < historialSize; i++) {
            totalApostado += historialApuestas[i];
        }

        return totalApostado;
    }
    public static int calcularTotalAciertos() {
        //calcula el total de aciertos
        int totalAciertos = 0;

        for (int i = 0; i < historialSize; i++) {
            if (historialAciertos[i]) {
                totalAciertos++;
            }
        }
        return totalAciertos;
    }
    public static int calcularGananciaNeta() {
        //saca el calculo de ganacianeta
        int ganancia = 0;

        for (int i = 0; i < historialSize; i++) {
            if (historialAciertos[i]) {
                ganancia += historialApuestas[i];
            } else {
                ganancia -= historialApuestas[i];
            }
        }

        return ganancia;
    }
    public static double calcularPorcentajeAciertos() {
        if (historialSize == 0) {
            return 0;
        }
        return (double) calcularTotalAciertos() / historialSize * 100;
    }
}


