package Serpis.psp;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class HttpServer {
private static final String newLine="\r\n";

        public static void main(String [] array) throws IOException, InterruptedException
{
       
      final int port=8080;
    
               
        ServerSocket serverSocket = new ServerSocket(port);
        
       
    
        
    
         while(true){
        
        Socket socket =serverSocket.accept();
     // SimpleServer.Process(socket);
        Runnable runnable = new ServerThread(socket);
        Thread thread = new Thread (runnable);
        thread.start();
        
       
      }
        
        
}
}
