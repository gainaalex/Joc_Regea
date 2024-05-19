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
    public BufferedImage selected_option;
    public int titleScreenState=0;
    public int pauseScreenState=0;

    public UI(Game g)
    {
        this.game=g;
        try {
            selected_option = ImageIO.read(getClass().getResourceAsStream("/res/design meniu/selected_option.png"));
            selected_option = TileScaler.scaleImage(selected_option, 5 * game.Tile_Size(), 3 * game.Tile_Size() / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        f1=new Font("ARIAL",Font.BOLD,60);

    }

    public void showMessage(String m)
    {
        messageOn=true;
        message=m;
    }

    public void drawPauseScreen()
    {
        if(pauseScreenState==0) {
            g.setFont(new Font("Arial", Font.BOLD, 50));
            String text = "RESUME";
            int x = getCentredText(text);
            int y = game.GetWndHeight() / 2 - 2 * game.Tile_Size();
            BufferedImage modifSelectedImage = TileScaler.scaleImage(selected_option, 8 * game.Tile_Size(), 23 * game.Tile_Size() / 10);
            int selected_x = x - 2 * game.Tile_Size();
            int selected_y = y - 3 * game.Tile_Size() / 2;
            switch (commandLine) {
                case 0:
                    break;
                case 1:
                    selected_y += 2 * game.Tile_Size();
                    break;
                case 2:
                    selected_y += 4 * game.Tile_Size();
                    break;
            }
            g.drawImage(modifSelectedImage, selected_x, selected_y, null);
            g.setColor(Color.BLACK);
            g.drawString(text, x + 3, y - 3);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
            y += 2 * game.Tile_Size();
            if (game.previousStatus == game.fightStatus)
                text = "CLOSE UI";
            else text = "SAVE GAME";
            x = getCentredText(text);
            g.setColor(Color.BLACK);
            g.drawString(text, x + 3, y - 3);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
            y += 2 * game.Tile_Size();
            if (game.previousStatus == game.fightStatus)
                text = "QUIT FIGHT";
            else text = "EXIT TO MENU";

            x = getCentredText(text);
            g.setColor(Color.BLACK);
            g.drawString(text, x + 3, y - 3);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);
        }
        if(pauseScreenState==1)
        {

        }
    }
    public int getCentredText(String t)
    {
        int l=(int)g.getFontMetrics().getStringBounds(t,g).getWidth();
        return game.GetWndWidth()/2-l/2;
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
        if(game.gameStatus==game.fightStatus)
        {
            drawFightUI();
        }
        if(game.gameStatus== game.lvlCompletedStatus)
        {
            drawLvlCompletedUI();
        }
        if(game.gameStatus==game.lvlFailedStatus)
        {
            drawLvlFailedUI();
        }
    }

    private void drawLvlFailedUI() {
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 70F));
        String text="LEVEL FAILED";
        int x=getCentredText(text);
        int y=6* game.Tile_Size();
        g.drawString(text,x+5,y+5);

        g.setColor(new Color(255,228,196));
        g.drawString(text,x+3,y+3);
        g.setColor(new Color(139,69,19));
        g.drawString(text,x,y);

        g.setFont(g.getFont().deriveFont(Font.BOLD, 40F));
        text="RETRY";
        y+=2*game.Tile_Size();
        x=getCentredText(text);
        int selX=x-2* game.Tile_Size();
        int selY=y- 6*game.Tile_Size()/5;
        switch (game.ui.commandLine)
        {
            case 0:
                break;
            case 1:
                selY+=2*game.Tile_Size();
                break;
        }
        BufferedImage scaledSelImg=TileScaler.scaleImage(selected_option,7* game.Tile_Size(),2*game.Tile_Size());
        g.drawImage(scaledSelImg,selX,selY,null);

        g.setColor(Color.BLACK);
        g.drawString(text,x+3,y+3);

        g.setColor(new Color(255,228,196));
        g.drawString(text,x,y);

        text="EXIT TO MENU";
        y+=2*game.Tile_Size();
        x=getCentredText(text);
        //g.drawImage(selected_option,x-game.Tile_Size()/2,y-game.Tile_Size(),null);
        g.setColor(Color.BLACK);
        g.drawString(text,x+3,y+3);

        g.setColor(new Color(255,228,196));
        g.drawString(text,x,y);
    }

    private void drawLvlCompletedUI() {
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 70F));
        String text="LEVEL COMPLETED";
        int x=getCentredText(text);
        int y=6* game.Tile_Size();
        g.drawString(text,x+5,y+5);

        g.setColor(new Color(255,228,196));
        g.drawString(text,x+3,y+3);
        g.setColor(new Color(139,69,19));
        g.drawString(text,x,y);

        g.setFont(g.getFont().deriveFont(Font.BOLD, 40F));
        text="CONTINUE";
        y+=2*game.Tile_Size();
        x=getCentredText(text);
        g.drawImage(selected_option,x-game.Tile_Size()/2,y-game.Tile_Size(),null);
        g.setColor(Color.BLACK);
        g.drawString(text,x+3,y+3);

        g.setColor(new Color(255,228,196));
        g.drawString(text,x,y);
    }

    private void drawFightUI() {
        g.setColor(Color.RED);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 30F));
        String text="REGEA        "+game.player1.currentLife+"  /  "+game.player1.maxHealth;
        int x=16;
        int y=game.Tile_Size();
        g.drawString(text,x+4,y+4);
        g.setColor(Color.WHITE);
        g.drawString(text,x+2,y+2);

        if(game.wnd.currentMap==3)
        {
            int copyY=y+2* game.Tile_Size();
            g.setColor(Color.RED);
            g.drawString("Seconds remains\n to win: " + game.countDownFight, x + 10 * game.Tile_Size()-24 + 2, copyY + 2);
            g.setColor(Color.WHITE);
            g.drawString("Seconds remains\n to win: " + game.countDownFight, x + 10 * game.Tile_Size()-24 , copyY );
        }
        if(game.wnd.currentMap==1) {
            g.setColor(Color.RED);
            g.drawString("Seconds remains\n to survive: " + game.countDownFight, x + 10 * game.Tile_Size()-24 + 2, y + 2);
            g.setColor(Color.WHITE);
            g.drawString("Seconds remains\n to survive: " + game.countDownFight, x + 10 * game.Tile_Size()-24 , y );
        }

        else
        {
            text=game.bosses[game.wnd.currentMap][0].currentLife+"  /  "+game.bosses[game.wnd.currentMap][0].maxHealth+"           "+game.bosses[game.wnd.currentMap][0].name;
            x=game.GetWndWidth()/2+2*game.Tile_Size();
            g.setColor(Color.RED);
            g.drawString(text,x+4,y+4);
            g.setColor(Color.WHITE);
            g.drawString(text,x+2,y+2);
        }
        x=16;
        g.setColor(Color.BLACK);
        y+=20;
        g.fillRect(x,y,8*game.Tile_Size(),game.Tile_Size());
        g.setColor(Color.WHITE);
        g.fillRect(x+10,y+10,8*game.Tile_Size()-20,game.Tile_Size()-20);
        g.setColor(Color.RED);
        int maxWidth=8*game.Tile_Size()-20;
        int currentWidth=Math.round(maxWidth*((float) game.player1.currentLife /game.player1.maxHealth)) ;
        g.fillRect(x+10,y+10,currentWidth,game.Tile_Size()-20);
        if(game.wnd.currentMap!=1) {
            g.setColor(Color.BLACK);
            x = game.GetWndWidth() / 2 + game.Tile_Size() + 32;
            g.fillRect(x, y, 8 * game.Tile_Size(), game.Tile_Size());
            g.setColor(Color.WHITE);
            g.fillRect(x + 10, y + 10, 8 * game.Tile_Size() - 20, game.Tile_Size() - 20);
            g.setColor(Color.RED);
            maxWidth = 8 * game.Tile_Size() - 20;
            currentWidth = Math.round(maxWidth * ((float) game.bosses[game.wnd.currentMap][0].currentLife / game.bosses[game.wnd.currentMap][0].maxHealth));
            int difference = maxWidth - currentWidth;
            g.fillRect(x + 10 + difference, y + 10, currentWidth, game.Tile_Size() - 20);
        }


    }

    private void drawTitleScreen() {
        if(titleScreenState==0) {
            g.setFont(g.getFont().deriveFont(Font.BOLD, 96F));
            String text = "THE REDEMPTION";
            int x = getCentredText(text);
            int y = 3 * game.Tile_Size();
            BufferedImage image = null;
        try{
            image=ImageIO.read(getClass().getResourceAsStream("/res/design meniu/new_background.jpg"));
            image= TileScaler.scaleImage(image,game.GetWndWidth(),game.GetWndHeight());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        g.drawImage(image,0,0,null);
            g.setColor(Color.GRAY);
            g.drawString(text, x + 5, y + 5);
            g.setColor(Color.WHITE);
            g.drawString(text, x, y);



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

            g.drawImage(selected_option, selected_opt_x, selected_opt_y, null);
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
