import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Ex10_6 extends JApplet {
    AudioClip audio1,audio2,audio3,currentaudio;
    JButton playaudio,loopaudio,stopaudio;
    JComboBox choice;

    public void init() {
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        String choices[] = {"Hi", "ring", "test"};
        choice = new JComboBox(choices);
        choice.addItemListener(new choiceListener());
        container.add(choice);

        ButtonHandler handler = new ButtonHandler();
        playaudio = new JButton("播放");
        loopaudio = new JButton("循环");
        stopaudio = new JButton("停止");
        playaudio.addActionListener(handler);
        loopaudio.addActionListener(handler);
        stopaudio.addActionListener(handler);
        add(playaudio);
        add(loopaudio);
        add(stopaudio);

        audio1 = getAudioClip(getDocumentBase(), "hi.au");
        audio2 = getAudioClip(getDocumentBase(), "ring.wav");
        audio3 = getAudioClip(getDocumentBase(), "text.mid");
    }

    public void stop() {
        currentaudio.stop();
    }

    class choiceListener implements ItemListener {
        public void iteStateChanged(ItemEvent e) {
            currentaudio.stop();

            switch (choice.getSelectedIndex()) {
                case 0:
                    currentaudio = audio1;
                    break;
                
                case 1:
                    currentaudio = audio2;
                    break;

                case 2:
                    currentaudio = audio3;
                    break;
            }
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playaudio) {
                currentaudio.play();
            } else if (e.getSource() == loopaudio) {
                currentaudio.loop();
            } else if (e.getSource() == stopaudio) {
                currentaudio.stop();
            } else {}
        }
    }
}