package chat;

import java.io.*;
import java.net.*;

/**
 * Clase principal que ejecuta el servidor del chat.
 * @autor: Silvia Balmaseda Hernández
 */
public class ServidorChat {
    public static void main(String[] args) {
        int puerto = 5000; 
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexiones en el puerto " + puerto + "...");
            
            // Crear socket y bind.
            Socket socket = servidor.accept();
            System.out.println("¡Cliente conectado desde " + socket.getInetAddress() + "!");

            // Usamos DataInputStream y DataOutputStream.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            Thread hiloRecepcion = new Thread(new HiloRecepcion(entrada));
            Thread hiloEnvio = new Thread(new HiloEnvio(salida));

            hiloRecepcion.start();
            hiloEnvio.start();

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}