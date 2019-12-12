// QKM-ThreadSusp/OurPanel.java
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

class OurPanel extends JPanel {
    static int NUM = 0;
    static final int WI=70, HE=190;
    static final Dimension DIM = new Dimension(WI,HE);
    static final int NUM_PANELS = 8;
    static final java.util.Random rand =
                    new Random(System.currentTimeMillis());
    static final Color[] kol = {
                     Color.RED,     Color.YELLOW,
                     Color.MAGENTA, Color.GREEN,
                     Color.CYAN,    Color.BLUE,
                     Color.ORANGE,  Color.PINK,
                 };

    OurPanel() {
        setLayout(new GridLayout(1,NUM_PANELS,5,5));
        setBackground(Color.GRAY);
        for ( int i = 0; i < NUM_PANELS; ++i ) {
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            final SmallPanel r = new SmallPanel();
            JButton button = new JButton(
                             new AbstractAction("Go!") {
                public void
                actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    if (r.suspended) {
                        r.suspended = false;
                        b.setText("Susp");
                        synchronized(r) {
                            r.notify();
                        }
                    } else {
                        r.suspended = true;
                        b.setText("Go!");
                    }
                }
            });
            p.add(button,BorderLayout.NORTH);
            p.add(r,BorderLayout.CENTER);
            add(p);
            new Thread(r).start();
        }
    }

    class SmallPanel extends JPanel implements Runnable {

        int r, dx, dy, x = WI/2, y = HE/2, tim;
        volatile boolean started   = false;
        volatile boolean suspended = true;

        public SmallPanel() {
            setLayout(new BorderLayout());
            setBackground(Color.BLACK);
            setForeground(kol[NUM%kol.length]);
            setPreferredSize(DIM);
            do {dx = rand.nextInt( 7)-3;} while(dx == 0);
            do {dy = rand.nextInt( 7)-3;} while(dy == 0);
            r   = rand.nextInt(11)+ 8;
            tim = rand.nextInt(51)+30;
            ++NUM;
        }

        public void run() {

            synchronized(this) {
                try {
                    while(!started) this.wait();
                } catch(InterruptedException ignore) { }
            }

            while (true) {
                synchronized(this) {
                    try {
                        while(suspended) this.wait();
                    } catch(InterruptedException ignore) { }
                }

                x += dx;
                if (x > WI-r) { x = WI-r; dx = -dx; }
                if (x <    r) { x =    r; dx = -dx; }
                y += dy;
                if (y > HE-r) { y = HE-r; dy = -dy;}
                if (y <    r) { y =    r; dy = -dy;}
                try {
                    Thread.sleep(tim);
                } catch(InterruptedException ignore) { }

                repaint();
                  // just in case
                Thread.yield();
            }
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            super.paintComponent(g2);

            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillOval(x-r,y-r,2*r,2*r);

            if (!started) {
                started = true;
                synchronized(this) {
                    this.notify();
                }
            }
        }
    }
}
