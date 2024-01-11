package cliente_servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		// Declaración de variables
		final int puerto = 5678;
		final String host = "127.0.0.1"; // ya que se va a ejecutar en el mismo equipo
		String mensajeUsuario;
		String respuestaServidor;

		try {
			// creo socket y espero conexión con el puerto
			Socket clienteSocket = new Socket(host, puerto);
			// flujos de entrada y de salida para comunicarme con el servidor
			BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
			PrintWriter salidaServidor = new PrintWriter(clienteSocket.getOutputStream(), true); // true realiza
																									// autoflush sin
																									// necesidad de
																									// hacer un
																									// posterior
																									// salidaCliente.flush()

			// comunicación con el servidor
			while (true) {
				System.out.println("Ingrese un texto o escriba quit para salir: ");
				mensajeUsuario = entradaUsuario.readLine();
				// se envía el mensaje de usuario al servidor
				salidaServidor.println(mensajeUsuario);
				// leemos la respuesta del servidor
				respuestaServidor = entradaServidor.readLine();
				System.out.println("El resultado que nos da el servidor es: " + respuestaServidor);

				if (mensajeUsuario.equalsIgnoreCase("quit")) {
					break;
				}
			}
			clienteSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// cerrar conexion
			System.out.println("Finalizado");

		}

	}

}
