package Regea_The_Game_v1;

import java.awt.*;

public class UI_game_pause {
    Game game;
    Graphics g;
    public UI_game_pause(Game game)
    {
        this.game=game;
    }

    public void drawPauseScreen()
    {
        g.setFont(new Font("Arial",Font.BOLD,40));
        g.drawString("PAUSE",game.wnd.GetWndWidth()/2,game.wnd.GetWndHeight()/2);
    }

    public void draw(Graphics g)
    {
        this.g=g;

        if(game.gameStatus==game.pauseStatus) {
                drawPauseScreen();
        }
    }

}
