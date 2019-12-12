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

public class ShapesWindow extends JFrame {
    private static final int REPAINT_INTERVAL_MSEC = 1000;
    private static final int WINDOW_HEIGHT = 768;
    private static final int WINDOW_WIDTH = 1024;

    static FileWriter writer;
    static BufferedReader reader;
    static int module;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            String s = JOptionPane.showInputDialog(null, "Choose module");
            module = Integer.parseInt(s);
            ShapesWindow window = new ShapesWindow();
            if (module == 1) {
                window.addingThread().start();
            } else {
                window.readFromFile();
            }
        });
    }

    ArrayList<Shape> shapesFromFile = new ArrayList<>();
    ArrayList<Shape> shapes = new ArrayList<>();

    public ShapesWindow() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Figures");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        if (module == 1) {
            try {
                writer = new FileWriter("figures.txt");
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            try {
                reader = new BufferedReader(new FileReader("figures.txt"));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public void writeToFile(Shape p) {
        try {
            writer.write(p.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void readFromFile() {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                addFromFile(Shape.fromString(line));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addFromFile(Shape shape) {
        shapesFromFile.add(shape);
    }

    public void paint(Graphics g) {

        double scalex = (double) getWidth() / WINDOW_WIDTH;
        double scaley = (double) getHeight() / WINDOW_HEIGHT;

        g.clearRect(0, 0, getWidth(), getHeight());
        if (module == 1) {
            for (Shape shape : shapes) {
                g.setColor(shape.color);
                shape.draw(g, scalex, scaley);
            }
        } else {
            for (Shape shape : shapesFromFile) {
                g.setColor(shape.color);
                shape.draw(g, scalex, scaley);
            }
        }
    }

    public void addShape() {
        Random rand = new Random();
        int r = rand.nextInt(ShapeType.values().length);
        ShapeType shapeType = ShapeType.values()[r];
        Shape shape;

        switch (shapeType) {
        case ELLIPSE:
            shape = new Ellipse(WINDOW_WIDTH, WINDOW_HEIGHT);
            break;
        case RECTANGLE:
            shape = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT);
            break;
        case TRIANGLE:
            shape = new Triangle(WINDOW_WIDTH, WINDOW_HEIGHT);
            break;
        default:
            return;
        }
        shapes.add(shape);
        writeToFile(shape);
    }

    public Thread addingThread() {
        return new Thread(() -> {
            while (true) {
                addShape();
                repaint();
                try {
                    Thread.sleep(REPAINT_INTERVAL_MSEC);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}