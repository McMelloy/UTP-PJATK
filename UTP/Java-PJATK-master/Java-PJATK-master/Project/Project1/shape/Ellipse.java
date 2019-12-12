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
import shape.*;

public class Ellipse extends Shape {
    public Ellipse(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
    }

    public Ellipse(Color color, int x, int y, int length, int height) {
        super(color, x, y, length, height);
    }

    public static Ellipse fromString(String string) {
        String[] color_values = string.split(";");
        Color color = new Color(Integer.parseInt(color_values[0]), Integer.parseInt(color_values[1]),
                Integer.parseInt(color_values[2]));
        String[] values = color_values[3].split(",");
        return new Ellipse(color, Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                Integer.parseInt(values[3]));
    }

    @Override
    public ShapeType getType() {
        return ShapeType.ELLIPSE;
    }

    @Override
    public void draw(Graphics graphics, double scalex, double scaley) {
        graphics.drawOval((int) (x * scalex), (int) (y * scaley), (int) (length * scalex), (int) (height * scaley));
    }

    @Override
    public String toString() {
        return super.toString() + x + "," + y + "," + length + "," + height + '\n';
    }
}