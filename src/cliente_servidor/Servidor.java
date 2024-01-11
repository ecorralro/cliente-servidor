package cliente_servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// Declaración de variables
		final int puerto = 5678;
		
		try {
			// creo socket y espero conexión con el puerto
			ServerSocket servidorSocket = new ServerSocket(puerto);
			System.out.println("Servidor escuchando en el puerto: " + puerto);
			// acepto la conexión del socket del cliente
			Socket clienteSocket = servidorSocket.accept();
			System.out.println("La conexión se ha establecido con el cliente.");
			//flujos de entrada y salida para comunicarse con el cliente
			BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
			PrintWriter salidaCliente = new PrintWriter(clienteSocket.getOutputStream(), true);// true realiza autoflush sin necesidad de hacer un posterior salidaCliente.flush()
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// cerrar conexion
		}

	}

}
