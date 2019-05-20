import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Anim2 extends JPanel implements ActionListener {
    protected ImageIcon imag[];
    protected int totalImag = 10,
                  curImag = 0,
                  animDelay = 50,
                  width,
                  height;
    protected String imagName = "T";
    protected Timer animTimer;

    public Anim2() {
        initAnim();
    }

    public Anim2(int count, int delay, String name) {
        totalImag = count;
        animDelay = delay;
        imagName = name;
        initAnim();
    }

    protected void initAnim() {
        imag = new ImageIcon[totalImag];

        for (int count = 1; count <= imag.length; ++count) {
            imag[count-1] = new ImageIcon(getClass().getResource("images/"+imagName+count+".gif"));
        }
        width = imag[ 0 ].getIconWidth();
        height = imag[0].getIconHeight();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        imag[curImag].paintIcon(this,g,0,0);
        curImag = (curImag + 1)%totalImag;
    }

    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    public void startAnim() {
        curImag = 0;
        animTimer = new Timer(animDelay,this);
        animTimer.start();
    }

    public void stopAnim() {
        animTimer.stop();
    }
}