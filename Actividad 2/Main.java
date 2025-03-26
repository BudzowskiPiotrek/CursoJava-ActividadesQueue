import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static PriorityQueue<Tarea> colaTareas = new PriorityQueue<>();
    public static Scanner sn = new Scanner(System.in);
    public static Scanner st = new Scanner(System.in);

    public static void main(String[] args) {
        meterDatos(); // AÑADE TAREAS INICIALES A LA COLA
        menu(); // MUESTRA EL MENÚ PRINCIPAL
    }

    // MÉTODO PARA AÑADIR TAREAS INICIALES A LA COLA
    private static void meterDatos() {
        colaTareas.add(new Tarea("Hacer la compra", 2));
        colaTareas.add(new Tarea("Enviar informe", 1));
        colaTareas.add(new Tarea("Pagar facturas", 3));
    }

    // MÉTODO PARA MOSTRAR EL MENÚ Y GESTIONAR OPCIONES
    private static void menu() {
        do {
            System.out.println("--- Gestor de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Procesar siguiente tarea");
            System.out.println("3. Mostrar tarea actual");
            int opcion = sn.nextInt();
            menuSwitch(opcion);
        } while (true);
    }

    // MÉTODO PARA GESTIONAR LAS OPCIONES DEL MENU
    private static void menuSwitch(int opcion) {
        switch (opcion) {
            case 1:
                agregarTarea();
                break;
            case 2:
                procesarTarea();
                break;
            case 3:
                mostrarTarea();
                break;
            default:
                System.err.println("Numero fuera de rango 1-3, intenta de nuevo");
                break;
        }
    }

    // MÉTODO PARA AGREGAR UNA NUEVA TAREA A LA COLA
    private static void agregarTarea() {
        System.out.println("Introduce la descripción de la tarea:");
        String descripcion = st.nextLine();
        System.out.println("Introduce la prioridad de la tarea (número, menor es mayor prioridad):");
        int prioridad = sn.nextInt();
        colaTareas.add(new Tarea(descripcion, prioridad));
        System.out.println("Tarea añadida con exito");
    }

    // MÉTODO PARA PROCESAR LA SIGUIENTE TAREA
    private static void procesarTarea() {
        Tarea tareaProcesada = colaTareas.poll();
        if (!colaTareas.isEmpty()) {
            System.out.println("Procesando tarea: " + tareaProcesada.getDescripcion());
        } else {
            System.out.println("No hay tareas en la cola");
        }
    }

    // MÉTODO PARA MOSTRAR LA TAREA ACTUAL
    private static void mostrarTarea() {
        Tarea tareaActual = colaTareas.peek();
        if (!colaTareas.isEmpty()) {
            System.out.println("Siguiente tarea a procesar: " + tareaActual.getDescripcion());
        } else {
            System.out.println("No hay tareas en la cola");
        }
    }
}
