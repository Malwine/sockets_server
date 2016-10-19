package sockets.server;

public class Server {
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

