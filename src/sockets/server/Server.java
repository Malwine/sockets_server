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
    		
       		//Start Aufgabe 3+4
       		Protocol protocol = new Protocol();
       		String readingCommand = protocol.process(reader.readLine());
       		
       		// TODO: We might want to send back the result of the commands to the client. 
    		// At the moment the results are simply output to the console through Protocol#process.
       		System.out.println(readingCommand);
       		
       		/*
       		// Aufgabe 2f
    		if(reader.readLine().equals("Hello")) {
    			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true); // autoflush
    			writer.println("WORLD!");
    		}
    		*/
       		
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

