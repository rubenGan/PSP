package serpis.psp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		pingPong();

	}
	
	private static void pingPong() throws IOException, InterruptedException
	{
		
				
		
		int port = 10001;		
		ServerSocket serverSocket = new ServerSocket(port);
		
				
		
		Socket socket = serverSocket.accept();//escucha peticiones entrantes
		Scanner scanner = new Scanner(socket.getInputStream());//lee el mensaje del cliente
		
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		
		int i = 0;
		
		while(i++<10)
		{
			receivePing(socket, scanner);			
			sendPong(socket, output);			
		}
		
		socket.close();
		serverSocket.close();
	}
	
	
	private static void sendPong(Socket s, DataOutputStream output) throws IOException 
	{
		output.writeBytes("Pong\n");
		output.flush();
		System.out.println("Servidor envía: pong");
	}
	
	private static void receivePing(Socket s, Scanner sc) throws InterruptedException
	{
		String line = sc.nextLine();//Lee el ping
		System.out.println("Mensaje recibido: " + line);//aqui imprime el mensaje
		
		Thread.sleep(4000);// espera de 4 segundos
	}
	
	
	
	/*
	private static void holaMundo() throws IOException
	{
		int port = 10001;
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		Socket socket = serverSocket.accept();//escucha peticiones entrantes
		
		Scanner scanner = new Scanner(socket.getInputStream());//aqui tiene el mensaje de client
		
		String line = scanner.nextLine();//aqui lee el mensaje
		System.out.println("Line = " + line);//aqui imprime el mensaje
		
		socket.close();
		serverSocket.close();
		
	}
*/

}


