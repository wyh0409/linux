import java.awt.*;
import javax.swing.*;

public class AnimTimer extends JApplet {
    public void init() {
        String param;

        param = getParameter("animdelay");
        int animDelay = (param == null ? 50 : Integer.parseInt(param));

        String imagName = getParameter("imagname");
        
        param = getParameter("totalimag");
        int totalImag = (param == null ? 0 : Integer.parseInt(param));
        
        Anim2 animator;
        if (imagName == null || totalImag == 0) {
            animator = new Anim2();
        } else {
            animator = new Anim2(totalImag, animDelay, imagName);
        }
        getContentPane().add(animator);
        animator.startAnim();
    }
}