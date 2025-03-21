import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
        public static Deque<Cliente> deque = new ArrayDeque<>();
        public static Scanner sn = new Scanner(System.in);
        public static Scanner st = new Scanner(System.in);

        public static void main(String[] args) {
                // AÑADE CLIENTES INICIALES A LA COLA
                meterDatos();
                // MUESTRA EL MENÚ PRINCIPAL
                menu();
        }

        // MÉTODO PARA AÑADIR CLIENTES INICIALES A LA COLA
        private static void meterDatos() {
                deque.add(new Cliente("Pablo"));
                deque.add(new Cliente("Jose"));
                deque.add(new Cliente("Patric"));
                deque.add(new Cliente("Bea"));
        }

        // MÉTODO PARA MOSTRAR EL MENÚ Y GESTIONAR OPCIONES
        private static void menu() {
                do {
                        System.out.println("--- Atención al cliente ---");
                        System.out.println("1.Agregar clientes");
                        System.out.println("2.Atender siguente cliente");
                        System.out.println("3.Mostrar Nombre del cliente que estas atendiendo");
                        // LEE LA OPCIÓN DEL USUARIO
                        int opcion = sn.nextInt();
                        // LLAMA AL MÉTODO QUE GESTIONA LAS OPCIONES
                        menuSwitch(opcion);
                } while (true);
        }

        // MÉTODO PARA GESTIONAR LAS OPCIONES DEL MENÚ
        private static void menuSwitch(int opcion) {
                switch (opcion) {
                        case 1:
                                agregarCliente(); // AGREGAR UN NUEVO CLIENTE
                                break;
                        case 2:
                                AtenderCliente(); // ATENDER AL SIGUIENTE CLIENTE EN LA COLA
                                break;
                        case 3:
                                MostrarCliente(); // MOSTRAR EL CLIENTE QUE SE ESTÁ ATENDIENDO
                                break;
                        default:
                                System.err.println("Numero fuera de rango 1-3, intenta de nuevo");
                                break;
                }
        }

        // MÉTODO PARA AGREGAR UN NUEVO CLIENTE A LA COLA
        private static void agregarCliente() {
                System.out.println("Dime nombre del nuevo cliente: ");
                String nombre = st.nextLine().toLowerCase(); // LEE EL NOMBRE EN MINÚSCULAS
                Cliente c1 = new Cliente(nombre);
                deque.add(c1); // AÑADE EL NUEVO CLIENTE A LA COLA
                System.out.println("Cliente añadido con exito");
        }

        // MÉTODO PARA ATENDER AL SIGUIENTE CLIENTE
        private static void AtenderCliente() {
                Cliente atendido = deque.poll(); // OBTIENE Y ELIMINA EL PRIMER CLIENTE DE LA COLA
                if (atendido != null) {
                        System.out.println("Acabas de atender al " + atendido.getNombre());
                } else
                        System.out.println("La cola esta vacia");
        }

        // MÉTODO PARA MOSTRAR EL CLIENTE QUE SE ESTÁ ATENDIENDO
        private static void MostrarCliente() {
                Cliente actual = deque.peek(); // OBTIENE EL PRIMER CLIENTE SIN ELIMINARLO
                if (actual != null) {
                        System.out.println("Estas atendiendo al " + actual.getNombre());
                }
        }
}
