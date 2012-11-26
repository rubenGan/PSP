package serpis.psp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String args[]) {
		try {
		int port=10001;
		InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
		DatagramSocket datagramSocket = new DatagramSocket(port,inetAddress);
		byte[] buf = new byte[2048];
		
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		while (true){
			datagramPacket.setLength(buf.length);
				
			datagramSocket.receive(datagramPacket);
			
			String data=new String(datagramPacket.getData(),0,datagramPacket.getLength());
			System.out.printf("\nData='%s' InetAddress=%s Port=%d",data,datagramPacket.getAddress(),datagramPacket.getPort());
		System.out.printf("length=%d" , datagramPacket.getLength());
		data=data+data.toLowerCase();
		StringUtil.FillByteArray(buf, data);
		datagramPacket.setLength(data.getBytes().length);
		
		datagramSocket.send(datagramPacket);
		
		}
		
		
		}
		catch (Exception exc){
		System.out.println ("Error en el Server");
		}
		
		}
}
