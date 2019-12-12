import java.io.*;
import java.net.*;
import java.util.HashMap;


public class TCPServer {

	public HashMap<String, String> n = new HashMap<>();
	
	public void listenSocket() {
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(55555); 
		}
		catch (IOException e) {
			System.out.println("Could not listen");
			System.exit(-1);
		}
		System.out.println("Server listens on port: " + server.getLocalPort());
		
		while(true) {
			try {
				client = server.accept();
			}
			catch (IOException e) {
				System.out.println("Accept failed");
				System.exit(-1);
			}
		
			(new ServerThread(client, this)).start();
		}
	}

	public static void main(String[] args) {
		TCPServer server = new TCPServer();
		server.listenSocket();
	}
}