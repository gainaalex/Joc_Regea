package Entity;

import Regea_The_Game_v1.CommandKeys;
import Regea_The_Game_v1.Game;
import Graphics.TileScaler;
import res.Animation;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {

    Game game;
    //pozitia globala
    public int WorldX,WorldY;
    public int speed;

    public String direction;
    public BufferedImage[] up,down,left,right;

    public int sprite_counter=0;
    public int spriteNum=0;
    public Rectangle solidArea;
    //coliziune cu tiles
    public boolean isCollision=false;

    public int solidArea_defaultX,solidArea_defaultY;
    public Entity(Game g)
    {
        this.game=g;
        solidArea=new Rectangle();
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

    public void draw(Graphics g) {

    }
    public void Update()
    {
        isCollision=false;
        game.collision.checkTile(this);
        game.collision.checkObj(this,false);
        game.collision.check_interaction_w_player(this);
    }

}
