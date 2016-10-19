package sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	public static void server() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
    	
        while(true) {
        	System.out.println("Server started...");
    		Socket clientSocket = serverSocket.accept();
    		
        	System.out.println("Read input...");
    		InputStreamReader input = new InputStreamReader(clientSocket.getInputStream());
       		BufferedReader reader = new BufferedReader(input);
    		
    		if(reader.readLine().equals("Hello")) {
    			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true); // autoflush
    			writer.println("WORLD!");
    		}
    		clientSocket.close();
    	}
	}
	
    public static void main(String[] args) {
    	
    	try {
			server();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

