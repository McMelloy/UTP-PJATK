package z09;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class sqr extends JPanel  {
    int currentValue=50;
    public sqr(){

        this.setLayout(new BorderLayout());
        SqrSpace sqrspace = new SqrSpace(currentValue);
        add(sqrspace, BorderLayout.CENTER);


        JSlider slider = new JSlider(0, 100, 50);
        slider.setSize(getWidth(),getHeight()/5);
        slider.setBorder(BorderFactory.createTitledBorder("Size of the square"));
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(10);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                currentValue = ((JSlider) ce.getSource()).getValue();
                sqrspace.value = (currentValue);
                sqrspace.repaint();
                //System.out.println(((JSlider) ce.getSource()).getValue());
            }
        });
        add(slider, BorderLayout.SOUTH);

    }

}

class SqrSpace extends JPanel{
    int value;
    public SqrSpace(int value){
        this.value=value;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0,0,255));

        int w = (int)(getWidth()*value/100.);
        int h = (int)(getHeight()*value/100.);
        int side = Math.min(w,h);

        int x = getWidth()/2 - side/2;
        int y = getHeight()/2 - side/2;

        g2d.fillRect(x, y, side, side);

    }
}
