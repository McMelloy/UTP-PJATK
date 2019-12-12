import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
	private Socket socket;
	private TCPServer server;

	public ServerThread(Socket socket, TCPServer server) {
		super();
		this.socket = socket;
		this.server = server;
	}
	
	public void run() {
		String messg="";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
			String line = in.readLine();
			
			String[] words = line.split(" ");
			String keyword = words[0];
			String name = words[1];
			String ip="";
			String port="";
			if(words.length > 2) {
				ip = words[2];
				port = words[3];
				for(int i = 2; i < words.length; i++ ) {
					messg+= words[i] + " ";
				}
			}
			
			switch(keyword) {
  				case "REGISTER":
					server.n.put(name, ip + " " + port);
					out.println("Service IP port registered as name " + name);
    				break;
  				case "GET":
					out.println(server.n.get(name));
					break;
				case "CALL":
					String s[] = server.n.get(name).split(" ");
					String ip_pr = s[0];
					String port_pr = s[1];
					TCPClient t = new TCPClient(ip_pr, port_pr, messg);
					out.println(t.connect());
					break;
			}
		} catch (IOException e1) {
			// do nothing
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			// do nothing
		}
	}
}