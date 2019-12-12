import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class TCPClient {
	Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String address;
		int _port;
		String messeg;

	public TCPClient(String ip, String port, String messeg){
		address = ip;
		_port = Integer.parseInt(port);
		this.messeg = messeg;
		
	}

	public String connect(){
		String line = "something is wrong";
		try {
			socket = new Socket(address, _port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		catch (UnknownHostException e) {
			System.out.println("Unknown host");
			System.exit(-1);
		}
		catch  (IOException e) {
			System.out.println("No I/O");
			System.exit(-1);
		}
		
		try {
			out.println(messeg);
			line = in.readLine();
	    }
	    catch (IOException e) {
	    	System.out.println("Error during communication");
	    	System.exit(-1);
	    }
	    
		try {
			socket.close();
		}
		catch (IOException e) {
			System.out.println("Cannot close the socket");
	    	System.exit(-1);
		}
		return line;
	}
}