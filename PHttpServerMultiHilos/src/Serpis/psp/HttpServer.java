package Serpis.psp;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class HttpServer {
private static final String newLine="\r\n";

        public static void main(String [] array) throws IOException, InterruptedException
{
       
      final int port=8080;
    
               
        ServerSocket serverSocket = new ServerSocket(port);
        
         while(true){
        
        Socket socket =serverSocket.accept();
      SimpleServer.Process(socket);
       
      }
        
        
}
}
