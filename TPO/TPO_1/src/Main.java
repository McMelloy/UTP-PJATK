import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Main {
    /*static Random rand = new Random();
    public static void main(String[] args) throws IOException, InterruptedException {
	// write your code here
        RandomAccessFile file = new RandomAccessFile("test","rw");
        FileChannel channel = file.getChannel();

        MappedByteBuffer buf = channel.map(
                FileChannel.MapMode.READ_WRITE,  // read-write mode
                0,  // starting from the beginning of the file
                12
        );

        while(true) {
            System.out.println("////////////////////////////");
            if(buf.get(0)==0) {
                int first = rand.nextInt(100);
                int second = rand.nextInt(100);
                buf.putInt(0,1);
                buf.putInt(first);
                buf.putInt(second);
            }

            buf.rewind();
            int got1 = buf.getInt();
            int got2 = buf.getInt();
            System.out.println(got1 + " + " + got2 + " = " + (got1+got2));
            buf.putInt(0,0);

            buf.rewind();
            Thread.sleep(2000);
        }

    }*/
}
