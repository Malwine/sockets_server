package sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {
	private Socket socket;
	private Protocol protocol;

	public ClientHandler(Socket socket, Protocol protocol) {
		this.socket = socket;
		this.protocol = protocol;
	}
	
	public void runServer() throws IOException {
        while(true) {
        	System.out.println("Read input...");
    		InputStreamReader input = new InputStreamReader(socket.getInputStream());
       		BufferedReader reader = new BufferedReader(input);
    		String message;
    		
       		while ((message = reader.readLine()) != null) {
       			System.out.println("Process input...");
           		String readingCommand = protocol.process(message);
           		System.out.println(readingCommand);

           		System.out.println("Sending answer...\n");
           		OutputStream outputStream = socket.getOutputStream();
           		outputStream.write(readingCommand.getBytes());
           		outputStream.flush();
       		}
       		
    		socket.close();
        }
	}

	@Override
	public void run() {
		try {
			runServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
