import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Writer {
    static Random rand = new Random();

    public static void start() throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("test","rw");
        FileChannel channel = file.getChannel();

        MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_WRITE, 0, 12);

        while(true) {
            //System.out.println("//////////////////////////// ");
            if(buf.getInt(0)==0) {
                int first = rand.nextInt(100);
                int second = rand.nextInt(100);
                System.out.println("Putting "+first+" and "+second);
                buf.putInt(1);
                buf.putInt(first);
                buf.putInt(second);
                buf.rewind();
            }
            Thread.sleep(2000);
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        start();
    }
}
