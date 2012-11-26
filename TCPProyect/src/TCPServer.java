import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Date;
import java.util.Scanner;


public class TCPServer 
{
	public static void main(String[] args) throws IOException 
	{
		holaMundo();
		//pingPong();
		connectAndWrite();
	}
	
	
		private static void connectAndWrite() throws IOException
		{
			int port = 10001;
			
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);//autoflush true
		
			printWriter.println("La hora es 1: " + new  Date());
			printWriter.println("La hora es 2: " + new  Date());	
			
			socket.close();
			
			serverSocket.close();
		}
	
	
	
	
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



}