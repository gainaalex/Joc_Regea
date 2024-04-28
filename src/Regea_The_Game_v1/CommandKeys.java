package Regea_The_Game_v1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandKeys implements KeyListener {
    Game game;
    public boolean up_command=false,down_command=false,left_command=false,right_command=false;

    public CommandKeys(Game g)
    {
        this.game=g;
    }
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
        if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_P)
        {
            if(game.gameStatus== game.playStatus)
                game.gameStatus= game.pauseStatus;
            else
                game.gameStatus=game.playStatus;
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
