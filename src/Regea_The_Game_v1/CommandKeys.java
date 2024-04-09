package Regea_The_Game_v1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandKeys implements KeyListener {

    public boolean up_command=false,down_command=false,left_command=false,right_command=false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if (code == KeyEvent.VK_W)
        {
            up_command=true;
        }
        if (code == KeyEvent.VK_S)
        {
            down_command=true;
        }
        if (code == KeyEvent.VK_A)
        {
            left_command=true;
        }
        if (code == KeyEvent.VK_D)
        {
            right_command=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if (code== KeyEvent.VK_W) {
            up_command = false;
        }
        if (code== KeyEvent.VK_S)
            down_command=false;
        if (code== KeyEvent.VK_A)
            left_command=false;
        if (code== KeyEvent.VK_D)
            right_command=false;
    }
}
