package Regea_The_Game_v1.UI;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Graphics.TileScaler;

public class UI {
    public Game game;
    public Graphics g;
    public Font f1;
    public int commandLine=0;
    public boolean messageOn=false;
    public String message="";
    public int messageCounter=0;
    public int titleScreenState=0;

    public UI(Game g)
    {
        this.game=g;

        f1=new Font("ARIAL",Font.BOLD,60);

    }

    public void showMessage(String m)
    {
        messageOn=true;
        message=m;
    }

    public void drawPauseScreen()
    {
        g.setFont(new Font("Arial",Font.BOLD,40));
        String text="PAUSE";
        int x=getCentredText(text);
        int y=game.GetWndHeight()/2;
        g.drawString("PAUSE",x,y);
    }
    public int getCentredText(String t)
    {
        int l=(int)g.getFontMetrics().getStringBounds(t,g).getWidth();
        int x=game.GetWndWidth()/2-l/2;
        return x;
    }
    public void Draw(Graphics g)
    {
        this.g=g;
        if(game.gameStatus==game.pauseStatus) {
            drawPauseScreen();
        }
        if(game.gameStatus==game.titleScreen_Status)
        {
            drawTitleScreen();
        }
    }

    private void drawTitleScreen() {
        if(titleScreenState==0) {
            g.setFont(g.getFont().deriveFont(Font.BOLD, 96F));
            String text = "THE REDEMPTION";
            int x = getCentredText(text);
            int y = 3 * game.Tile_Size();
            BufferedImage image = null;
        /*try{
            image=ImageIO.read(getClass().getResourceAsStream("/res/design meniu/a-king-throne-highlighted-in-a-dark-room-the-thro-upscaled.jpg"));
            image= TileScaler.scaleImage(image,game.GetWndWidth(),game.GetWndHeight());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        g.drawImage(image,0,0,null);*/
            g.setColor(Color.GRAY);
            g.drawString(text, x + 5, y + 5);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/res/design meniu/selected_option.png"));
                image = TileScaler.scaleImage(image, 5 * game.Tile_Size(), 3 * game.Tile_Size() / 2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int selected_opt_x = 2 * game.Tile_Size() - 32;
            ;
            int selected_opt_y = y + 4 * game.Tile_Size();
            switch (commandLine) {
                case 0:
                    break;
                case 1:
                    selected_opt_y = y + 5 * game.Tile_Size();
                    break;
                case 2:
                    selected_opt_y = y + 6 * game.Tile_Size();
                    break;
                case 3:
                    selected_opt_y = y + 7 * game.Tile_Size();
                    break;
            }

            g.drawImage(image, selected_opt_x, selected_opt_y, null);
            g.setFont(g.getFont().deriveFont(Font.BOLD, 30F));
            text = "NEW GAME";
            x = 2 * game.Tile_Size();
            y += 5 * game.Tile_Size();
            g.setColor(Color.GRAY);
            g.drawString(text, x + 3, y + 3);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);

            text = "LOAD GAME";
            x = 2 * game.Tile_Size();
            y += game.Tile_Size();
            g.setColor(Color.GRAY);
            g.drawString(text, x + 3, y + 3);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);

            text = "SETTINGS";
            x = 2 * game.Tile_Size();
            y += game.Tile_Size();
            g.setColor(Color.GRAY);
            g.drawString(text, x + 3, y + 3);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);

            text = "EXIT GAME";
            x = 2 * game.Tile_Size();
            y += game.Tile_Size();
            g.setColor(Color.GRAY);
            g.drawString(text, x + 3, y + 3);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
        }
        if(game.ui.titleScreenState==1)
        {

        }
    }

}
