package Serpis.psp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpServerThread extends Thread
{
	
	private Socket socket = null;
	private static final String newLine = "\r\n";

    public HttpServerThread(Socket socket) {
      super("HttpServerThread");
      this.socket = socket;
    }
    public void run()
    {
    	try
		{
				String fileName = getFileName(socket.getInputStream());
			 
			 	writeHeader(socket.getOutputStream(),fileName);
			 	writeFile(socket.getOutputStream(),fileName);
			 	
			 	socket.close();
			 	
			 	
			
		}catch(Exception e){
				System.err.println("Error:" + e.getMessage());
				e.printStackTrace();
				
			}finally{
			try {
				socket.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			}
    	
    	}
    private static String getFileName(InputStream inputStream)
	{
		Scanner scanner = new Scanner( inputStream);
		
		String fileName = "index.html";
	
		while (true)
		{
			String line = scanner.nextLine();
			if(line.startsWith("GET")){
				fileName= line.substring(5, line.length()-9).trim();
			      
			       System.out.println("ARCHIVO PEDIDO: "+fileName);
				
			}
			System.out.println(line);
			if (line.equals(""))
				break;
		}
		return fileName;
	}
	private static void writeHeader(OutputStream outputStream, String fileName) throws IOException
	{	
		File file = new File(fileName);
		
		final String response200 ="HTTP/1.0 200 OK";
		final String response404 ="HTTP/1.0 404 Not Found";
		String response = file.exists() ? response200 : response404;
		String header = response + newLine + newLine;
		
		byte[] headerBuffer = header.getBytes();
		
		outputStream.write(headerBuffer );
	}
	private static void writeFile(OutputStream outputStream, String fileName) throws IOException{
		
		final String fileNameError404 = "fileError404.html";
		
		File file = new File(fileName);
		String responseFileName = file.exists() ? fileName : fileNameError404;
		
		final int bufferSize = 2048;
		byte[] buffer = new byte[bufferSize];
		
		
		FileInputStream fileInputStream = new FileInputStream(responseFileName);
		
		int count;
		while((count = fileInputStream.read(buffer)) != -1){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			outputStream.write(buffer, 0, count);
		}
			
		
		fileInputStream.close();
	}
		
	 


}
