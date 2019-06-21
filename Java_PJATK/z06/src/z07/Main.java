package z07;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Iterator<String> iter = new IterFileWrapper("IterFile.txt").iterator();
        System.out.println( " Is there a line? " + iter.hasNext());
        System.out.println( " Just checking... " + iter.hasNext());
        System.out.println( " The first line:\n" + iter.next());
        System.out.println( " and the remaining lines:");
        while (iter.hasNext())
            System.out.println(iter.next());
        try {
            System.out.println("??? " + iter.next());
        }
        catch(NoSuchElementException e) {
            System.out.println( "*** You cannot get water out of a stone.");
        }
        System.out.println("\n And once again");
        for (String s : new IterFileWrapper("IterFile.txt"))
            System.out.println(s);

    }
}
