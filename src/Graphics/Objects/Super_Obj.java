package Graphics.Objects;

import Regea_The_Game_v1.Game;
import Graphics.TileScaler;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Super_Obj {
    public Game game;
    public boolean priority_over_player=false;
    protected static int animation_Counter=0;
    public int freq_def=0;

    protected static boolean isUpdated=false;
    public BufferedImage image;
    public String name;
    public boolean collision=false;
    public int worldX,worldY;

    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidArea_defaultX=0;
    public int solidArea_defaultY=0;

    public Super_Obj(Game g)
    {
        this.game=g;
    }
    public BufferedImage setup(String ImagePath)
    {
        BufferedImage image =null;
        try{
            image= ImageIO.read(getClass().getResourceAsStream(ImagePath));
            if (image.getWidth()!=game.Tile_Size() && image.getHeight()!=game.Tile_Size())
                image= TileScaler.scaleImage(image,game.Tile_Size(), game.Tile_Size());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }

    public void set_image()
    {

    }

    public void scaleImages(int width,int height)
    {

    }

    public void Update()
    {
        if(freq_def==15)
        {
            freq_def=0;
            if(animation_Counter==120)
                animation_Counter=0;
            else
                animation_Counter++;
            isUpdated=false;
        }
        else
            freq_def++;
    }

    public void Draw(Graphics g, Game game)
    {
        set_image();
        int screenX=worldX-game.player1.WorldX+game.player1.screenX;
        int screenY=worldY-game.player1.WorldY+game.player1.screenY;
        if (worldX + game.Tile_Size()*7>game.player1.WorldX-game.player1.screenX &&
                worldX- game.Tile_Size()*7<game.player1.WorldX+game.player1.screenX &&
                worldY+ game.Tile_Size()*5>game.player1.WorldY-game.player1.screenY &&
                worldY- game.Tile_Size()*5<game.player1.WorldY+game.player1.screenY )
        {
            g.drawImage(image,screenX,screenY,null);
        }
    }
}
