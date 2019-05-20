import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;

public class URL_txtImg extends Applet implements ActionListener {
    Button imageDisp,textDisp;
    boolean drawImage = false;
    boolean first;
    int i = 0;
    String line_str;
    Font font;

    public void init() {
        imageDisp = new Button("图像");
        textDisp = new Button("文本");
        add(imageDisp);
        add(textDisp);
        imageDisp.addActionListener(this);
        textDisp.addActionListener(this);

        setBackground(Color.white);
        font = new Font("System",Font.BOLD,20);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == imageDisp) {
            drawImage = true;
            doDrawImage();
        } else {
            drawImage = false;
            first = true;
            doWrite("LoadImg.txt");
        }
    }

    public void paint(Graphics g) {
        if (drawImage) {
            try {
                URL image_URL = new URL(getDocumentBase(),"javalogo.gif");
                Toolkit object_Toolkit = Toolkit.getDefaultToolkit();
                Image object_Image = object_Toolkit.getImage(image_URL);
                g.drawImage(object_Image,50,50,this);
            } catch (MalformedURLException e) {}
        } else {
            if (first) {
                first = false;
                g.setColor(Color.white);
                g.fillRect(0,0,400,300);
                g.setFont(font);
            }
            if (line_str != null) {
                g.drawString(line_str,10,i*20);
            }
            i++;
        }
    }

    private void doDrawImage() {
        repaint();
    }

    private void doWrite(String url_str) {
        try {
            URL url = new URL(getDocumentBase(),url_str);
            URLConnection connection = url.openConnection();
            InputStream inputstream = connection.getInputStream();
            InputStreamReader file = new InputStreamReader(inputstream);
            BufferedReader in = new BufferedReader(file);
            try {
                i = 1;
                line_str = in.readLine();
                while (line_str != null) {
                    paint(getGraphics());
                    line_str = in.readLine();
                }
            } catch (IOException e) {}
            in.close();
        } catch (MalformedURLException e1) {
            System.out.println(e1);
        } catch (IOException e2) {
            System.out.println(e2);
        }
    }
}