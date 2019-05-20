import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Ex10_5 extends Applet implements ActionListener,Runnable {
    AudioClip audio;
    Thread thread;
    Button playaudio, loopaudio, stopaudio;

    public void init() {
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        playaudio = new Button("播放");
        loopaudio = new Button("循环");
        stopaudio = new Button("停止");
        playaudio.addActionListener(this);
        loopaudio.addActionListener(this);
        stopaudio.addActionListener(this);
        add(playaudio);
        add(loopaudio);
        add(stopaudio);
    }

    public void start() {
        thread.start();
    }
    public void stop() {
        audio.stop();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playaudio) {
            audio.play();
        } else if (e.getSource() == loopaudio) {
            audio.loop();
        } else if (e.getSource() == stopaudio) {
            audio.stop();
        } else {}
    }

    public void run() {
        audio = getAudioClip(getCodeBase(),"hi.au");
    }
}