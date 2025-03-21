public class Cliente {
    private String nombre;
    private int numeroTicket;
    public static int numeroCliente;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.numeroTicket = numeroCliente;
        numeroCliente++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

}
