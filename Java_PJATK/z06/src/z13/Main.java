package z13;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static javax.swing.SwingConstants.RIGHT;


class City{
    String name;
    double price;

    City(String name, double price) {
        this.name = name;
        this.price  = price;
    }

    @Override
    public String toString() { return name; }
}

public class Main extends JFrame {
    JComboBox<City> cities;
    JComboBox<String> discount;
    double price=1;
    String restxt;

    public static void main(String[] args) {
        new Main();
    }

    Main(){

        super("Tickets");

        final City[] data =
        {
                new City("Madrid",475.90),
                new City("Rome",350.40),
                new City("Tokio",1000.0),
                new City("Warsaw",0)
        };

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,100);

        this.setLayout(new BorderLayout());
        JLabel result = new JLabel("Choose destination and discount");
        result.setHorizontalAlignment(SwingConstants.CENTER);
        add(result, BorderLayout.NORTH);

        JPanel dd = new JPanel(new FlowLayout());
        JLabel lcity = new JLabel("Destination:",RIGHT);
        JLabel ldisc = new JLabel("Discount (%):",RIGHT);
        cities   = new JComboBox<City>(data);
        discount = new JComboBox<String>(
                new String[]{"Full price", "Senior", "Student"});
        dd.add(lcity);
        dd.add(cities);
        dd.add(ldisc);
        dd.add(discount);
        add(dd,BorderLayout.CENTER);

        setVisible(true);
    }
}
