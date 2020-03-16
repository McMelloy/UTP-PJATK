import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        InetSocketAddress address = new InetSocketAddress("localhost", 7777);
        SocketChannel client = SocketChannel.open(address);

        while (true){
            String input = scanner.nextLine();
            byte[] message = input.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            client.write(buffer);
            System.out.println("Message: " + input);

            buffer = ByteBuffer.wrap(new byte[100]);
            client.read(buffer);
            System.out.println("Answer: "+new String(buffer.array()));

            Thread.sleep(1000);
        }
    }

}
