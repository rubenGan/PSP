package serpis.psp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
try{
DatagramSocket datagramSocket = new DatagramSocket();

String text = "¡Hola desde UDPClient!";
byte[]buf=text.getBytes();
InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
int port =10001;

DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length ,inetAddress,port);
 datagramSocket.send(datagramPacket);
 datagramSocket.close();
 
}
catch (Exception exc){
System.out.println ("Error al enviar");
}
	}

}
