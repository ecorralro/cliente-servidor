package cliente_servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// Declaraci�n de variables
		final int puerto = 5678;
		
		try {
			// creo socket y espero conexi�n con el puerto
			ServerSocket servidorSocket = new ServerSocket(puerto);
			System.out.println("Servidor escuchando en el puerto: " + puerto);
			// acepto la conexi�n del socket del cliente
			Socket clienteSocket = servidorSocket.accept();
			System.out.println("La conexi�n se ha establecido con el cliente.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// cerrar conexion
		}

	}

}
