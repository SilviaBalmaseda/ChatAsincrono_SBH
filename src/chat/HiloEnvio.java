package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hilo encargado de leer de teclado y enviar los datos.
 * @autor: Silvia Balmaseda Hernández
 */
public class HiloEnvio implements Runnable {
    private DataOutputStream salida;
    private Scanner teclado;

    public HiloEnvio(DataOutputStream salida) {
        this.salida = salida;
        this.teclado = new Scanner(System.in);
    }

    @Override
    public void run() {
        String mensaje;
        try {
            while (true) {
                mensaje = teclado.nextLine();
                salida.writeUTF(mensaje); // Se envia.
            }
        } catch (IOException e) {
            System.out.println("Error al enviar: " + e.getMessage());
        }
    }
}