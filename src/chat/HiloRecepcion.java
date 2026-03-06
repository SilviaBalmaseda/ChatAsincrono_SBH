package chat;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Hilo encargado de recibir los datos y mostrarlos por pantalla.
 * @author Silvia Balmaseda Hernández
 */
public class HiloRecepcion implements Runnable {
    private DataInputStream entrada;

    public HiloRecepcion(DataInputStream entrada) {
        this.entrada = entrada;
    }

    @Override
    public void run() {
        String mensaje;
        try {
            while (true) {
                mensaje = entrada.readUTF(); // Recibe el mensaje.
                System.out.println("-> " + mensaje);
            }
        } catch (IOException e) {
            System.out.println("La conexión se ha cerrado.");
        }
    }
}