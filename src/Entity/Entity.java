package Entity;

import Regea_The_Game_v1.CommandKeys;
import Regea_The_Game_v1.Game;
import res.Animation;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    //pozitia globala
    public int WorldX,WorldY;
    public int speed;

    public String direction;
    public BufferedImage[] up,down,left,right;

    public int sprite_counter=0;
    public int spriteNum=0;
    public Rectangle solidArea;
    //coliziune cu tile s
    public boolean isCollision=false;

    public int solidArea_defaultX,solidArea_defaultY;
}
