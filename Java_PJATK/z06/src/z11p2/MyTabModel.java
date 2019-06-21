package z11p2;
// PET-TableEx/TableEx.java

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import static javax.swing.JScrollPane.*;

public class MyTabModel {
    public static void main(String... args) {
        JTable table = new JTable(new Tab());
        table.setDefaultRenderer(java.awt.Color.class,
                new MyColorCellRend());
        table.getColumn("BMI").setCellRenderer(
                new MyBMICellRend());
        table.getColumn("Birth").setCellRenderer(
                new MyDateCellRend());

        // This is needed; otherwise the table
        // does not fill the whole scroll...
        table.setPreferredScrollableViewportSize(
                table.getPreferredSize());
        JScrollPane scroll = new JScrollPane(table,
                VERTICAL_SCROLLBAR_ALWAYS,
                HORIZONTAL_SCROLLBAR_ALWAYS);
        JFrame f = new JFrame("Table");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(scroll);
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
    }
}

class Tab extends AbstractTableModel {

    ArrayList<Class>  classes = new ArrayList<>();
    ArrayList<String> colname = new ArrayList<>();

    ArrayList<String>  name = new ArrayList<>();
    ArrayList<String>  surname = new ArrayList<>();
    ArrayList<String>  birth = new ArrayList<>();
    ArrayList<Color>   colo = new ArrayList<>();
    ArrayList<Integer> height = new ArrayList<>();
    ArrayList<Integer> weight = new ArrayList<>();
    ArrayList<Integer> bmi = new ArrayList<>();

    ArrayList<Object>  data = new ArrayList<>();

    int ilerows;


    private void readData() {
        try {
            classes.add(Class.forName("java.lang.String"));
            classes.add(Class.forName("java.lang.String"));
            classes.add(Class.forName("java.lang.String"));
            classes.add(Class.forName("java.awt.Color"));
            classes.add(Class.forName("java.lang.Integer"));
            classes.add(Class.forName("java.lang.Integer"));
            classes.add(Class.forName("java.lang.Integer"));

            colname.add("Name");
            colname.add("Surname");
            colname.add("Birth");
            colname.add("Color");
            colname.add("Height");
            colname.add("Weight");
            colname.add("BMI");

        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        BufferedReader in = null;
        FileReader reader = null;
        try {
            reader = new FileReader("list.txt");
            in = new BufferedReader(reader);
            String line = in.readLine();
            while(line!=null){
                //System.out.println(line);
                String[] fields = line.split(" ");
                name.add(fields[0]);
                surname.add(fields[1]);
                birth.add(fields[2]);
                String[] colors = fields[3].split(",");
                Color color = new Color(
                        Integer.parseInt(colors[0].trim()),
                        Integer.parseInt(colors[1].trim()),
                        Integer.parseInt(colors[2].trim())
                );
                colo.add(color);
                height.add(Integer.valueOf(fields[4]));
                weight.add(Integer.valueOf(fields[5]));
                bmi.add(Integer.valueOf(fields[5])*10000/(Integer.valueOf(fields[4])*Integer.valueOf(fields[4])));
                line = in.readLine();
            }
            ilerows = name.size();
        } catch (Exception e) {
            e.printStackTrace();
        }

        data.add(name);
        data.add(surname);
        data.add(birth);
        data.add(colo);
        data.add(height);
        data.add(weight);
        data.add(bmi);
    }

    public Tab() {
        readData();
    }

    @Override
    public int getColumnCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int r, int c) {
        return ((List)data.get(c)).get(r);
    }

    @Override
    public String getColumnName(int c) {
        return colname.get(c);
    }

    @Override
    public int getRowCount() {
        return ilerows;
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return classes.get(c);
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        return false;
    }
}

class MyColorCellRend extends JLabel
        implements TableCellRenderer {
    public MyColorCellRend() {
        setOpaque(true);
    }

    public Component
    getTableCellRendererComponent(
            JTable table, Object color, boolean isSelected,
            boolean hasFocus, int row, int column) {
        setBackground((Color)color);
        return this;
    }
}

class MyBMICellRend extends JLabel
        implements TableCellRenderer
{
    public MyBMICellRend() {
        setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if((int)value>=25)
            setBackground(Color.RED);
        else if((int)value<=15)
            setBackground(Color.YELLOW);
        else
            setBackground(Color.WHITE);
        setText(value.toString());
        return this;
    }
}

class MyDateCellRend extends JLabel
        implements TableCellRenderer{

    public MyDateCellRend() {
        setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Sansserif", Font.BOLD, 11));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String str = (String)value;
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-DD");
        Date date= null;
        try {
            date = formatter1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatter2 = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely

        setText(formatter2.format(date));
        return this;
    }
}