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
		String mensajeCliente;
		int numeroLetras;
		
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
			
			// comunicación con el cliente
			while (true) {
				// lee el mensaje enviado por el cliente
				mensajeCliente = entradaCliente.readLine();
				System.out.println("El cliente dice: " + mensajeCliente);
				// procesamos el mensaje del cliente
				numeroLetras = contarLetras(mensajeCliente);
				// enviar respuesta a cliente
				salidaCliente.println("El número de letras del texto introducdo por el usuario es: " + numeroLetras);
				// si el mensaje es quit salir del bucle
				if (mensajeCliente.equalsIgnoreCase("quit")) {
					break;
				}
				
				
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// cerrar conexion
			System.out.println("Conexión finalizada.");
		}

	}
	private static int contarLetras(String texto) {
		int contador = 0;
		
		for (int i = 0; i < texto.length(); i++) {
			if (Character.isLetter(texto.charAt(i))) {
				contador++;
			}
			
		}
		return contador;
	}

}
