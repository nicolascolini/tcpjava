package socket.cliente.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

   public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    Socket socket = new Socket("127.0.0.1", 12345);
    System.out.println("Conectado");
    
    DataInputStream entrada = new DataInputStream(socket.getInputStream());
    DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        
    System.out.println("Digite um numero para continuar...");
    String novaMensagem = "";
    
    while(novaMensagem.isEmpty()) {
        double numero = scanner.nextDouble();
        saida.writeDouble(numero);
                
        novaMensagem = entrada.readUTF();
    
    }
    System.out.println("Somatorio :" + novaMensagem);

    entrada.close();
    saida.close();
    scanner.close();
    socket.close();
            
            
    }
    
}