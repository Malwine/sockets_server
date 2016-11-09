package sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	
	public static void server() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		Protocol protocol = new Protocol();
    	
		ExecutorService pool = Executors.newCachedThreadPool();
		
		while(true) {
			System.out.println("Server started");
			Socket clientSocket = serverSocket.accept();
			pool.submit( new ClientHandler(clientSocket, protocol));
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

