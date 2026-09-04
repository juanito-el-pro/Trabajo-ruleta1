import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };
    /**
     * Método principal: inicia el programa llamando al menú.
     */
    public static void main(String[] args) {
        menu();
    }
    /**
     * Controla el flujo principal del programa mostrando
     * un menú en consola.
     */
    public static void menu() {
// TODO: Repetir el menú hasta que el usuario elija salir.

        Scanner in = new Scanner(System.in);

        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(in);
            ejecutarOpcion(opcion, in);
        } while (opcion != 3);

        in.close();}
    /**
     * Muestra en consola las opciones disponibles del menú.
     */
    public static void mostrarMenu() {
// TODO: Mostrar las opciones disponibles para el usuario.
        System.out.println();
        System.out.println("|===< Ruleta Black Cat >===|");
        System.out.println("1) Iniciar ronda");
        System.out.println("2) Ver estadisticas");
        System.out.println("3) Salir");
        System.out.print("Seleccione una opcion: ");
    }
    /**
     * Lee la opción elegida por el usuario desde teclado.
     *
     * @param in Scanner para entrada por consola.
     * @return número de opción ingresado.
     */
    public static int leerOpcion(Scanner in) {
// TODO: Leer y retornar la opción ingresada.
        return in.nextInt();
    }
    /**
     * Ejecuta la acción correspondiente a la opción del menú.
     *
     * @param opcion opción elegida por el usuario.
     * @param in Scanner para entrada por consola.
     */


    public static void ejecutarOpcion(int opcion, Scanner in) {
        // TODO: Ejecutar la acción asociada a la opción.

            switch (opcion) {
                case 1:
                    iniciarRonda(in);
                    break;

                case 2:
                    mostrarEstadisticas();
                    break;

                case 3:
                    System.out.println("Gracias por jugar, Adios.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
    }
    /**
     * Inicia una ronda de la ruleta: leer apuesta, girar,
     * evaluar y mostrar resultado.
     *
     * @param in Scanner para entrada por consola.
     */
    public static void iniciarRonda(Scanner in) {
// TODO: Implementar el flujo completo de una ronda.
        System.out.println(); //Test para el menu
        System.out.println("|===* Nueva Ronda *===|");

        char tipo = leerTipoApuesta(in);

        System.out.print("Ingrese monto a apostar: ");
        int monto = in.nextInt();

        int numero = girarRuleta();

        boolean acierto = evaluarResultado(numero, tipo);

        registrarResultado(numero, monto, acierto);

        mostrarResultado(numero, tipo, monto, acierto);
    }

    public static char leerTipoApuesta(Scanner in) {char tipo;
// TODO: Leer y validar el tipo de apuesta.
        do {
            System.out.print("Ingrese tipo de apuesta (R/N/P/I): ");
            tipo = in.next().toUpperCase().charAt(0);

            if (tipo != 'R' && tipo != 'N' && tipo != 'P' && tipo != 'I') {
                System.out.println("Tipo de apuesta no valido.");
            }

        } while (tipo != 'R' && tipo != 'N' && tipo != 'P' && tipo != 'I');

        return tipo;
    }
    /**
     * Simula el giro de la ruleta generando un número
     * aleatorio de 0 a 36.
     *
     * @return número de la ruleta.
     */
    public static int girarRuleta() {
// TODO: Generar y retornar un número entre 0 y 36.
        return rng.nextInt(37);
    }
    /**
     * Evalúa si la apuesta realizada por el jugador
     * fue acertada.
     *
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta elegida.
     * @return true si acertó, false si perdió.
     */
    public static boolean evaluarResultado(int numero, char tipo) {
// TODO: Evaluar el resultado según el tipo de apuesta.
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
    /**Determina si un número corresponde a color rojo.
     * @param n número de la ruleta.
     * @return true si es rojo, false en caso contrario.
     */
    public static boolean esRojo(int n) {
// TODO: Buscar el número en el arreglo numerosRojos.
        for (int numeroRojo : numerosRojos) {
            if (numeroRojo == n) {
                return true;
            }
        }
        return false;
    }
    /**
     * Registra los resultados de la ronda en los arreglos
     * de historial.
     *
     * @param numero número obtenido en la ruleta.
     * @param apuesta monto apostado.
     * @param acierto si el jugador acertó o no.
     */

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
// TODO: Guardar los datos sin superar MAX_HISTORIAL.

        if (historialSize < MAX_HISTORIAL) {

            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            historialSize++;
        }
    }
    /**Muestra en consola el resultado de la ronda.
     *
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta realizada.
     * @param monto monto apostado.
     * @param acierto si el jugador ganó o perdió.
     */
    public static void mostrarResultado(int numero, char tipo, int monto, boolean acierto) {
// TODO: Mostrar los datos y el resultado de la ronda.
        System.out.println();
        System.out.println("|===> Resultado De La Ronda <===|");
        System.out.println("Numero obtenido: " + numero);
        System.out.println("Tipo de apuesta: " + tipo);
        System.out.println("Monto apostado: $" + monto);

        if (numero == 0) {
            System.out.println("Color: Verde");
        } else if (esRojo(numero)) {
            System.out.println("Color: Rojo");
        } else {
            System.out.println("Color: Negro");
        }

        if (acierto) {
            System.out.println("Resultado: GANASTE");
        } else {
            System.out.println("Resultado: PERDISTE");
        }
    }
    /**
     * Muestra estadísticas generales de todas las
     * rondas jugadas.
     */
    public static void mostrarEstadisticas() {
        int totalApostado = 0;
        int totalAciertos = 0;

        for (int i = 0; i < historialSize; i++) {
            totalApostado += historialApuestas[i];

            if (historialAciertos[i]) {
                totalAciertos++;
            }
        }

        System.out.println();
        System.out.println("|===< Estadisticas >===|");
        System.out.println("Rondas jugadas: " + historialSize);
        System.out.println("Monto total apostado: $" + totalApostado);
        System.out.println("Cantidad de aciertos: " + totalAciertos);
    }
}
