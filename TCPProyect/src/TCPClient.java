import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.Scanner;


public class TCPClient 
{

	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		//holaMundo();	
		//pingPong();
		//connectAndRead(args);
		connectUpvWeb();
		System.out.println("TCPClient fin");
	}
	
	private static void pingPong() throws InterruptedException, IOException
	{	
		InetAddress inetAddress = InetAddress.getByName("127.1.1.0");
		int port = 10001;
		
		DatagramSocket datagramSocket = new DatagramSocket();
		byte[] bufReceive = new byte[2048];
		DatagramPacket datagramPacketReceive = new DatagramPacket(bufReceive, bufReceive.length);
		
		while(true)
		{
			String text = "Hola desde UDPClient"+ new java.util.Date();
			byte[] bufSend = text.getBytes();
			DatagramPacket datagramPacketSend = new DatagramPacket(bufSend, bufSend.length, inetAddress, port);
			datagramSocket.send(datagramPacketSend);
			
            datagramSocket.receive(datagramPacketReceive);
			
			String data = new String(datagramPacketReceive.getData(),0, datagramPacketReceive.getLength());
			System.out.printf("Receive Data='%s'\n",data);
			
			
		   //message + message.toLowerCase();	
		 Thread.sleep(5000);//miliseconds
		
			datagramSocket.close();
			System.out.println("UDPClient fin");
		}
	}
	
	private static void connectUpvWeb() throws IOException
	{
		String host = "www.upv.es";
		int port = 80;
		String line1 = "GET /index.html HTTP/1.1";
		String line2 = "";
		
		InetAddress inetAddress = InetAddress.getByName(host);
		Socket socket = new Socket(inetAddress, port);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);//autoflush=true
		printWriter.println(line1);
		printWriter.println(line2);
		
		Scanner scanner = new Scanner(socket.getInputStream());
		
		while(scanner.hasNextLine())
			System.out.println(scanner.nextLine());
	}
	
	
	
	private static void connectAndRead(String[] args) throws IOException
	{
		System.out.println("Argumentos: ");
		for(int i = 0; i<args.length; i++)
			System.out.println(args[i]);
		
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		InetAddress inetAddress = InetAddress.getByName(host);
		Socket socket = new Socket(inetAddress, port);
		
		Scanner scanner = new Scanner(socket.getInputStream());	
		
		while(scanner.hasNextLine())
		{
			System.out.println(scanner.nextLine());
		}
		
		socket.close();
	}

	private static void holaMundo() throws UnknownHostException, IOException
	{
		
		//InetAddress inetAddres = InetAddress.getByName("127.0.0.1");
		String host = null;//localhost
		int port =10001;
		Socket SocketCliente = new Socket(host,port);
		//Socket SocketCliente = new Socket(inetAddress, port);
	
		
		OutputStream outputStream = SocketCliente.getOutputStream();//flujo de salida
		PrintWriter printWriter = new PrintWriter(outputStream, true);
		printWriter.println("Hola desde TCPClient a las " + new java.util.Date());
		//Flujo = new DataOutputStream(FlujoDeSalida);
		//Flujo.writeBytes("Hola Mundo");
		
		printWriter.close();
		SocketCliente.close();
		
	}
	
}
