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
byte[]buf=new byte[2048];
InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
int port =10001;
DatagramPacket datagramPacket = new DatagramPacket (buf,buf.length,inetAddress,port);



 while  (true){
	 String text = "¡Hola desde UDPClient!"+ new java.util.Date();
	StringUtil.FillByteArray(buf, text);
	datagramPacket.setLength(text.getBytes().length);
	 datagramSocket.send(datagramPacket);
	 
	 
	 datagramPacket.setLength(buf.length);
	 datagramSocket.receive(datagramPacket);
	 String data=new String(datagramPacket.getData(),0,datagramPacket.getLength());
	 System.out.printf("\n Receive Data='%s",data);
	 
	 Thread.sleep(5000);
 }
 
 
 
 
}
catch (Exception exc){
System.out.println ("Error en el Cliente");
}
	}

}
