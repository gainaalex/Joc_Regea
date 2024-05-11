package Entity;

import Graphics.TileScaler;
import Regea_The_Game_v1.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class NPC_Cow extends Entity{

    public boolean isCrescator=true;
    public Random rnd=new Random();
    public int freq;
    public NPC_Cow(Game g) {
        super(g);
        direction="left";
        speed=0;
        solidArea.x=0;
        solidArea.y=0;
        solidArea.height=54;
        solidArea.width=game.Tile_Size()*2-16;
        getNPCImage();
    }
    public void getNPCImage()
    {
        freq=rnd.nextInt(26);
        left=new BufferedImage[4];
        left[0] = setup("/res/Animals/Cow/Eat/cow/left_stay.png");
        left[0]= TileScaler.scaleImage(left[0],game.Tile_Size()*2-16,54);
        left[1] = setup("/res/Animals/Cow/Eat/cow/left_1.png");
        left[1]= TileScaler.scaleImage(left[1],game.Tile_Size()*2-16,54);
        left[2] = setup("/res/Animals/Cow/Eat/cow/left_2.png");
        left[2]= TileScaler.scaleImage(left[2],game.Tile_Size()*2-16,54);
        left[3] = setup("/res/Animals/Cow/Eat/cow/left_3.png");
        left[3]= TileScaler.scaleImage(left[3],game.Tile_Size()*2-16,54);
    }
    public void Update() {
        sprite_counter++;
        if (sprite_counter > 60+freq) {
            if (spriteNum == 3)
            {
                spriteNum--;
                isCrescator=false;
            }
            else if(spriteNum==0)
            {
                spriteNum++;
                isCrescator=true;
            }
            else
            {
                if(isCrescator)
                    spriteNum++;
                else
                    spriteNum--;
            }
            sprite_counter = 0;
        }
    }
    public void draw(Graphics g)
    {
        BufferedImage image=null;
        int screenX=WorldX-game.player1.WorldX+game.player1.screenX;
        int screenY=WorldY-game.player1.WorldY+game.player1.screenY;
        if (WorldX + game.Tile_Size()>game.player1.WorldX-game.player1.screenX &&
                WorldY- game.Tile_Size()<game.player1.WorldX+game.player1.screenX &&
                WorldY+ game.Tile_Size()>game.player1.WorldY-game.player1.screenY &&
                WorldY- game.Tile_Size()<game.player1.WorldY+game.player1.screenY )
        {
            image=left[spriteNum];
            g.drawImage(image,screenX,screenY,null);
        }
    }
}
