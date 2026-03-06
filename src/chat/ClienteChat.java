package chat;

import java.io.*;
import java.net.*;

/**
 * Clase principal que ejecuta el cliente del chat.
 * @author Silvia Balmaseda Hernández
 */
public class ClienteChat {
    public static void main(String[] args) {
        String ipServidor = "192.168.8.114";
        int puerto = 5000;

        try {
        	// Crear socket.
            Socket socket = new Socket(ipServidor, puerto);
            System.out.println("¡Conectado exitosamente al servidor!");

            // Usamos DataInputStream y DataOutputStream.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            Thread hiloRecepcion = new Thread(new HiloRecepcion(entrada));
            Thread hiloEnvio = new Thread(new HiloEnvio(salida));

            hiloRecepcion.start();
            hiloEnvio.start();

        } catch (IOException e) {
            System.err.println("Error en el cliente al conectar: " + e.getMessage());
        }
    }
}