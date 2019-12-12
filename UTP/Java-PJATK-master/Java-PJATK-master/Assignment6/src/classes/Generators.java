package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Generators {
    private static String _name;
    private static String _surname;
    private static Date _birth;
    private static Nationality _nat;
    private static String[] polishNames = getFromFile("tmp/PolishNames.txt");
    private static String[] polishSurnames = getFromFile("tmp/PolishSurnames.txt");


    public static void genNationality() {
        _nat = Nationality.genValue();
    }

    public static void genName(){
        int i = genNumber();
        switch (_nat) {
            case POLISH:
                _name polishNames[i];
                break;

        }
    }



    public static String[] getFromFile(File file) {
        String[] arr = new String[40];
        int index = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tmp = reader.readLine();
            while(tmp !=null) {
                arr[index] = tmp;
                index++;
                tmp = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println();
        }

        return arr;
    }


    public static int genNumber() {
        Random rand = new Random();
        return rand.nextInt(39 + 1);
    }



}
