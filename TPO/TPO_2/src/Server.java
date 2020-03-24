import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8080;

        ServerSocketChannel serverChannel = null;
        Selector selector = null;

        serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(host, port));
        serverChannel.configureBlocking(false);
        selector= Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iter = keys.iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();

                if (key.isAcceptable()) {
                    SocketChannel client = serverChannel.accept();
                    client.configureBlocking(false);

                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Connected");

                } else if (key.isReadable()) {

                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);

                    String result = new String(buffer.array()).trim();
                    System.out.println("Message received: " + result);
                    if(result.equals("exit"))
                        System.exit(0);

                    if(result.matches("[0-9]+ *\\+ *[0-9]+")){
                        String[] nums = result.split("\\+");
                        for(int i = 0;i<nums.length;i++)
                            nums[i] = nums[i].trim();
                        result = ""+(Integer.parseInt(nums[0])+Integer.parseInt(nums[1]));
                        byte[] out = result.getBytes();
                        buffer = ByteBuffer.wrap(out);
                        client.write(buffer);
                        System.out.println("Plus'ed");
                        buffer.clear();
                    }
                    else {
                        byte[] out = result.getBytes();
                        buffer = ByteBuffer.wrap(out);
                        client.write(buffer);
                        System.out.println("Echo'ed");
                        buffer.clear();
                    }
                }
                iter.remove();
            }
        }

    }
}
