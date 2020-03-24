import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);
        SocketChannel client = SocketChannel.open(address);

        while (true){
            System.out.println("Input \'x + y\' to get answer, any other message to get echo or \'exit\' to exit program");
            String input = scanner.nextLine();
            byte[] message = input.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            client.write(buffer);
            System.out.println("Message: " + input);
            if(input.equals("exit")) {
                Thread.sleep(500);
                System.exit(0);
            }

            buffer = ByteBuffer.wrap(new byte[100]);
            client.read(buffer);
            System.out.println("Answer: "+new String(buffer.array()));

            Thread.sleep(1000);
        }
    }

}
