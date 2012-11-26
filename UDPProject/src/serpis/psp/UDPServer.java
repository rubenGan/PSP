package serpis.psp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	public static void main(String args[]) {
		try {
		DatagramSocket datagramSocket = new DatagramSocket(10001);
		byte[] buf = new byte[2048];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		datagramSocket.receive(datagramPacket); //Espera hasta recibir un paquete
		System.out.println(new String(datagramPacket.getData()));
		System.out.println(datagramPacket.getAddress());
		System.out.println(datagramPacket.getPort());
		System.out.println(datagramPacket.getLength());
		datagramSocket.close();
		}
		catch (Exception exc){
		System.out.println ("Error al recibir");
		}
		}
}
