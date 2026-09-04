import java.util.Random;
import java.util.Scanner;
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

    public static void mostrarMenu() {
// Mostrar menu en patalla las opciones
        System.out.println();
        System.out.println("|===< Ruleta Black Cat >===|");
        System.out.println("1) Iniciar ronda");
        System.out.println("2) Ver estadisticas");
        System.out.println("3) Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public static int leerOpcion(Scanner in) {
// devuelve la opcion ingresada
        return in.nextInt();
    }


    public static void ejecutarOpcion(int opcion, Scanner in) {
        // Redirige a la opcion escogida, (apuesta/ estadisticas/ salir)

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


    public static int leerMontoApuesta(Scanner in) {
        System.out.print("Ingrese monto a apostar: ");
        return in.nextInt();
    }
    // lee un numero ingresado para apostar
    public static void iniciarRonda(Scanner in) {
// Muestra en pantalla el incio de ronda
        System.out.println();
        System.out.println("|===* Nueva Ronda *===|");

        char tipo = leerTipoApuesta(in);
        int monto = leerMontoApuesta(in);
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
        return rng.nextInt(CANTIDAD_NUMEROS);
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
//evalua si el numero es rojo o no lo es, si no es rojo es negro o verde tirando false, verde solo es el 0
    public static boolean esRojo(int n) {
// avisa si es que el numero esta en la lista de numeros rojos
        for (int numeroRojo : numerosRojos) {
            if (numeroRojo == n) {
                return true;
            }
        }
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
// Guarda los datos sin superar MAX_HISTORIAL.

        if (historialSize < MAX_HISTORIAL) {

            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            historialSize++;
        }
    }

    public static void mostrarResultado(int numero, char tipo, int monto, boolean acierto) {
// Muetra los datos de la ronda
        System.out.println();
        System.out.println("|===> Resultado De La Ronda <===|");
        System.out.println("Numero obtenido: " + numero);
        System.out.println("Tipo de apuesta: " + tipo);
        System.out.println("Monto apostado: $" + monto);
        mostrarColor(numero);
        if (acierto) {
            System.out.println("Resultado: GANASTE");
        } else {
            System.out.println("Resultado: PERDISTE");
        }
    }

    public static void mostrarColor(int numero) {
        //muestra el color del numero asosiado
        if (numero == 0) {
            System.out.println("Color: Verde");
        } else if (esRojo(numero)) {
            System.out.println("Color: Rojo");
        } else {
            System.out.println("Color: Negro");
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
    public static void mostrarEstadisticas() {
        // muestra los datos calculados (estadisticas de juego) (rondas jugas, monto total apostado, total de aciertos y gancia neta)
        int totalApostado = calcularTotalApostado();
        int totalAciertos = calcularTotalAciertos();
        int gananciaNeta = calcularGananciaNeta();

        double porcentajeAciertos = calcularPorcentajeAciertos();
        System.out.println();
        System.out.println("|===< Estadisticas >===|");
        System.out.println("Rondas jugadas: " + historialSize);
        System.out.println("Monto total apostado: $" + totalApostado);
        System.out.println("Cantidad de aciertos: " + totalAciertos);
        System.out.printf("Porcentaje de aciertos: %.2f%%%n", porcentajeAciertos);
        System.out.println("Ganancia o perdida neta: $" + gananciaNeta);

    }
}
