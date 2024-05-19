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
    public String name;
    public String direction;
    public BufferedImage[] up,down,left,right;
    public BufferedImage[] attackUp,attackDown,attackLeft,attackRight;

    public int sprite_counter=0;
    public int spriteNum=0;
    public Rectangle solidArea;
    //coliziune cu tiles
    public boolean isCollision=false;

    //stats
    public int maxHealth,currentLife,lastSavedCurrentLife;

    //pt gravitatie
    public int airSpeed=0;
    public int gravity=1;
    public int jumpSpeed=-20;
    public int fallSpeed=5;
    public boolean inAir=false;
    public boolean falling=false;
    public boolean airAttack=false;

    public int solidArea_defaultX,solidArea_defaultY;

    //for fights
    public Rectangle attackArea=new Rectangle(0,0,0,0);
    public boolean attacking=false;
    public boolean invincible=false;
    public int invincibleCounter=0;
    public int knockback;
    public int damage;

    //ranged caracters
    public Projectile projectile;

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

    public BufferedImage setupAttackAnimations(String ImagePath)
    {
        BufferedImage image =null;
        try{
            image= ImageIO.read(getClass().getResourceAsStream(ImagePath));
            if (image.getWidth()!=2*game.Tile_Size() && image.getHeight()!=game.Tile_Size())
                image= TileScaler.scaleImage(image,2*game.Tile_Size(), game.Tile_Size());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage[] scaleImagesEntity(BufferedImage[] image,float xwidth, float yheight)
    {

        int width=Math.round(xwidth*game.Tile_Size());
        int heigth=Math.round(yheight*game.Tile_Size());
        for(int i=0;i<image.length;i++)
        {
            image[i]=TileScaler.scaleImage(image[i], width,heigth);
        }
        return image;
    }

    public void scaleSolidArea(float xwidth, float yheight)
    {
        solidArea.width=Math.round(solidArea.width*xwidth);
        solidArea.height=Math.round(solidArea.height*yheight);
    }

    public void Draw(Graphics g) {

    }
    public void Draw_In_Fights(Graphics g)
    {

    }
    public void Update()
    {
        isCollision=false;
        game.collision.checkTile(this);
        game.collision.checkObj(this,false);
        game.collision.check_interaction_w_player(this);
    }

}
