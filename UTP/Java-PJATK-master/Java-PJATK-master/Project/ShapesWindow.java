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

enum ShapeType {
    ELLIPSE(0), RECTANGLE(1), TRIANGLE(2);

    private final int value;

    private ShapeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

abstract class Shape {
    private static final int MAX_COLOR = 255;

    ShapeType type;
    int length;
    int height;
    int x;
    int y;
    Color color;

    public static Shape fromString(String string) throws IllegalArgumentException {
        String[] segments = string.split(":");
        String shapeTypeId = segments[0];
        String shapeParams = segments[1];
        ShapeType shapeType = ShapeType.values()[Integer.parseInt(shapeTypeId)];
        switch (shapeType) {
            case ELLIPSE:
                return Ellipse.fromString(shapeParams);
            case RECTANGLE:
                return Rectangle.fromString(shapeParams);
            case TRIANGLE:
               return Triangle.fromString(shapeParams);
            default: 
                throw new IllegalArgumentException(String.format("Unknown shape type %s.", shapeType));
        }
    }

    Shape(int windowWidth, int windowHeight) {
        Random r = new Random();
        color = new Color(r.nextInt(MAX_COLOR), r.nextInt(MAX_COLOR), r.nextInt(MAX_COLOR));
        x = r.nextInt(windowWidth);
        y = r.nextInt(windowHeight);
        length = r.nextInt(windowWidth - x);
        height = r.nextInt(windowHeight - y);
    }

    Shape(Color color, int x, int y, int length, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }

    Shape(Color color) {
        this.color = color;
    }

    abstract ShapeType getType();

    abstract void draw(Graphics graphics, double scalex, double scaley);

    @Override
    public String toString() {
        return getType().getValue() + ":" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + ";";
    }
}

class Ellipse extends Shape {
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

class Rectangle extends Shape {
    public Rectangle(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
    }

    public Rectangle(Color color, int x, int y, int length, int height) {
        super(color, x, y, length, height);
    }

    public static Rectangle fromString(String string) {
        String[] color_values = string.split(";");
        Color color = new Color(Integer.parseInt(color_values[0]), Integer.parseInt(color_values[1]),
                Integer.parseInt(color_values[2]));
        String[] values = color_values[3].split(",");
        return new Rectangle(color, Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                Integer.parseInt(values[2]), Integer.parseInt(values[3]));
    }

    @Override
    public ShapeType getType() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public void draw(Graphics graphics, double scalex, double scaley) {
        graphics.drawRect((int) (x * scalex), (int) (y * scaley), (int) (length * scalex), (int) (height * scaley));
    }

    @Override
    public String toString() {
        return super.toString() + x + "," + y + "," + length + "," + height + '\n';
    }
}

class Triangle extends Shape {
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



public class ShapesWindow extends JFrame {
    private static final int REPAINT_INTERVAL_MSEC = 1000;
    private static final int WINDOW_HEIGHT = 768;
    private static final int WINDOW_WIDTH = 1024;

    static FileWriter writer;
    static BufferedReader reader;
    static int module;

    //setLayout(new BorderLayout());
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