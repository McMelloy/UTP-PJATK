package shape;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Triangle extends Shape {
    int[] arrx = new int[3];
    int[] arry = new int[3];

    Triangle(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        Random r = new Random();
        arrx[0] = x;
        arrx[1] = r.nextInt(windowWidth);
        arrx[2] = r.nextInt(windowWidth);
        arry[0] = y;
        arry[1] = r.nextInt(windowHeight);
        arry[2] = r.nextInt(windowHeight);
    }

    Triangle(Color color, int x1, int x2, int x3, int y1, int y2, int y3) {
        super(color);
        arrx[0] = x1;
        arrx[1] = x2;
        arrx[2] = x3;
        arry[0] = y1;
        arry[1] = y2;
        arry[2] = y3;
    }

    public static Triangle fromString(String string) {
        String[] color_values = string.split(";");
        Color color = new Color(Integer.parseInt(color_values[0]), Integer.parseInt(color_values[1]),
                Integer.parseInt(color_values[2]));
        String[] values = color_values[3].split(",");
        return new Triangle(color, Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]),
                Integer.parseInt(values[5]));
    }

    @Override
    public ShapeType getType() {
        return ShapeType.TRIANGLE;
    }

    @Override
    public void draw(Graphics graphics, double scalex, double scaley) {
        int[] xtmp = new int[3];
        int[] ytmp = new int[3];

        for (int m = 0; m < 3; m++) {
            xtmp[m] = (int) (arrx[m] * scalex);
            ytmp[m] = (int) (arry[m] * scaley);
        }
        graphics.drawPolygon(xtmp, ytmp, arry.length);
    }

    @Override
    public String toString() {
        return super.toString() + arrx[0] + "," + arrx[1] + "," + arrx[2] + "," + arry[0] + "," + arry[1] + ","
                + arry[2] + '\n';
    }
}
