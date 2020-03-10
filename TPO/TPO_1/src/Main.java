import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Main {
    static Random rand = new Random();
    public static void main(String[] args) throws IOException, InterruptedException {
	// write your code here
        RandomAccessFile file = new RandomAccessFile("test","rw");
        RandomAccessFile statusfile = new RandomAccessFile("status","rw");
        FileChannel channel = file.getChannel();
        FileChannel statusChannel = statusfile.getChannel();

        MappedByteBuffer buf = channel.map(
                FileChannel.MapMode.READ_WRITE,  // read-write mode
                0,  // starting from the beginning of the file
                8
        );
        MappedByteBuffer statusBuf = statusChannel.map(
                FileChannel.MapMode.READ_WRITE,  // read-write mode
                0,  // starting from the beginning of the file
                1
        );

        while(true) {
            System.out.println("////////////////////////////");
            if(statusBuf.get(0)==0) {
                int first = rand.nextInt(100);
                int second = rand.nextInt(100);
                statusBuf.put(0,(byte)1);
                buf.putInt(first);
                buf.putInt(second);
            }

            buf.rewind();
            int got1 = buf.getInt();
            int got2 = buf.getInt();
            System.out.println(got1 + " + " + got2 + " = " + (got1+got2));
            statusBuf.put(0,(byte)0);

            buf.rewind();
            Thread.sleep(2000);
        }

    }
}
