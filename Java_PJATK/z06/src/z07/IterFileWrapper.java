package z07;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class IterFileWrapper implements Iterable<String>, Iterator<String> {
    private String filename;
    private BufferedReader  in = null;
    private String          string;

    public IterFileWrapper(String filename){
        this.filename = filename;
        try {
            FileReader reader = new FileReader(filename);
            in = new BufferedReader(reader);
            string = in.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<String> iterator(){
        return this;
    }

    @Override
    public boolean hasNext() {
        if(string==null){
            return false;
        }
        else
            return true;
    }

    @Override
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        String res = string;
        try {
            string = in.readLine();
            if(string==null)
                in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
