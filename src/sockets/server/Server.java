package sockets.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	public static void server() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
    	
        while(true) {
    		Socket clientSocket = serverSocket.accept();
    		InputStream input = clientSocket.getInputStream();
    		byte[] data = new byte[1024];
    		int numBytes = 0;
    		numBytes = input.read(data);
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

