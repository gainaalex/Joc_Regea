package Graphics.Objects;

import Regea_The_Game_v1.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Super_Obj {

    public BufferedImage image;
    public String name;
    public boolean collision=false;
    public int worldX,worldY;

    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidArea_defaultX=0;
    public int solidArea_defaultY=0;

    public void Draw(Graphics g, Game game)
    {
        int screenX=worldX-game.player1.WorldX+game.player1.screenX;
        int screenY=worldY-game.player1.WorldY+game.player1.screenY;
        if (worldX + game.Tile_Size()>game.player1.WorldX-game.player1.screenX &&
                worldY- game.Tile_Size()<game.player1.WorldX+game.player1.screenX &&
                worldY+ game.Tile_Size()>game.player1.WorldY-game.player1.screenY &&
                worldY- game.Tile_Size()<game.player1.WorldY+game.player1.screenY )
        {
            g.drawImage(image,screenX,screenY,null);
        }
    }
}
