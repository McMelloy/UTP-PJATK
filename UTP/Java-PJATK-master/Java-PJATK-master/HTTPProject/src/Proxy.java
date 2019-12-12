import java.io.*;
import java.net.*;

public class Proxy {

    private int _port;

    public Proxy(int port) {
        _port = port;
    }

    public void listenSocket() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(_port);
        }
        catch (IOException e) {
            System.out.println("Could not listen");
            System.exit(-1);
        }
        System.out.println("Server listens on port: " + server.getLocalPort());

        while(true) {
            try {
                client = server.accept();
                //System.out.println("success");
            }
            catch (IOException e) {
                System.out.println("Accept failed");
                System.exit(-1);
            }

            (new ServerThread(client, this)).start();
        }
    }

    public static void main(String[] args) {
        //Proxy server = new Proxy(Integer.parseInt(args[0]));
        Proxy server = new Proxy(5555);
        server.listenSocket();
    }
}