package socket.cliente.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		
		Boolean selecao = true;
		double somaNumero = 0;
		
		// abre conexão
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("porta aberta!");
		System.out.println("esperando mensagem do cliente");
		
		// aguarda solicitação
		Socket socket = serverSocket.accept();
		
		System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");
		
		// define
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
		
		while(selecao) {				
			
			double numero = entrada.readDouble();
			if(numero != 0) {
				System.out.println("Numero digitado :" + numero);
				somaNumero += numero;
				saida.writeUTF("");
				
			}else {
				System.out.println("Fim de Processo");
				System.out.println("Somatorio :" + somaNumero);
				saida.writeUTF(String.valueOf(somaNumero));
				
				
				saida.close();
				entrada.close();
				

				socket.close();
				serverSocket.close();
				
				selecao = false;
			}			
		}
	}
}