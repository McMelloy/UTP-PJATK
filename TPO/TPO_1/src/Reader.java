import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Reader {

    public static void start() throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("test","rw");
        FileChannel channel = file.getChannel();

        MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_WRITE, 0, 12);

        while(true) {
            //System.out.println("////////////////////////////");
            if(buf.getInt(0)==1) {
                int got1 = buf.getInt(4);
                int got2 = buf.getInt(8);
                System.out.println(got1 + " + " + got2 + " = " + (got1+got2));
                buf.putInt(0,0);
                buf.rewind();
            }
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        start();
    }
}
