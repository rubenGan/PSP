package serpis.psp;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class HttpServer {

        public static void main(String [] array) throws IOException
	{
       
       final int port=8080;
        final String newLine="\r\n";
      final String fileNameError404="fileError404.html";
      final String response200="HTTP/1.0 200 OK";
      final String response404="HTTP/1.0 404 Not Found";
      
         
        ServerSocket serverSocket = new ServerSocket(port);
         try{    
        	 while(true){
        Socket socket =serverSocket.accept();       
       Scanner scanner = new Scanner( socket.getInputStream());
      
       String fileName="index.html";
       while (true){
    	   String line =scanner.nextLine();
    	   if (line.startsWith("GET")){
    		   
    	   }
    	   System.out.println(line);
    	   if (line.equals("")){
    		   break;
    	   }
    	   
       }
       File file = new File(fileName);
       //Si existe devuelve fileName y si no fileNAmeError404
       String responseFileName=file.exists() ? fileName : fileNameError404;
       //Si existe devuelve response200 y si no response404
      String response = file.exists() ? response200 : response404;
    	 
    	   
       FileInputStream fileInputStream=new FileInputStream(responseFileName);
       
       String header=response+newLine+newLine;
      
       
      byte[] headerBuffer= header.getBytes();
       
       OutputStream outputStream = socket.getOutputStream();
       outputStream.write(headerBuffer);
       
       final int bufferSize=2048;
       byte[] buffer= new byte[bufferSize];
       
       int count;
       while((count=fileInputStream.read(buffer))!=-1){
 //Añadimos un sleep para comprobar que al realizar varias peticiones, se realizan una detrás de otra
    	   Thread.sleep(5000);
    	   outputStream.write(buffer, 0, count);
       }
       fileInputStream.close();
       socket.close();
        	 }
      }catch(Exception e){
    	  System.err.println("Error: " + e.getMessage());
    	  e.printStackTrace();

      }finally{
       serverSocket.close();
        	
		
      }  	
        
        
	} 
	}
	
	
	
	




