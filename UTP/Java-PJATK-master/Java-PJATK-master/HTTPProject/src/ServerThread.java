import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
    private Socket socket;
    private Proxy server;
    private Socket browser;


    public ServerThread(Socket socket, Proxy server) {
        super();
        this.socket = socket;
        this.server = server;
    }

    public String getHost() {

        String secondLine;
        String[] arr;

        String host="";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("request.txt"));
            reader.readLine();

            secondLine = reader.readLine();
            arr = secondLine.split(" ");
            host = arr[1];

        } catch (IOException e) {
            System.out.println(e);
        }

        return host;
    }

    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter writeRequest = new PrintWriter(new FileWriter("request.txt"));

            String request;

            while(( request= in.readLine()) != null && !request.isEmpty())
            {
                writeRequest.println(request);

            }
            writeRequest.close();


            String host = getHost();

            System.out.println(host);

            browser = new Socket(host, 80);

            PrintWriter requestToHost = new PrintWriter(browser.getOutputStream());

            BufferedReader readerFromFile = new BufferedReader(new FileReader("request.txt"));

            String sendRequest;

            while((sendRequest = readerFromFile.readLine()) != null && !sendRequest.isEmpty()) {
                //System.out.println(sendRequest);
                requestToHost.print(sendRequest);
            }
            requestToHost.close();

            readerFromFile.close();


            PrintWriter client = new PrintWriter(socket.getOutputStream(),true);

            BufferedReader browserStream = new BufferedReader(new InputStreamReader(browser.getInputStream()));

            String respond;
            //respond = browserStream.readLine();
            while(( respond = browserStream.readLine()) != null && !respond.isEmpty())
            {   System.out.println(respond);
                client.println(respond);
                System.out.println(respond);
               // writeRequest.print('\n');
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