package Entity;

import Regea_The_Game_v1.Game;
import Graphics.TileScaler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC_Baraka extends Entity {
    int sprite_counter=0;

    public NPC_Baraka(Game g) {
        super(g);
        name="Baraka";
        direction="down";
        speed=0;
        solidArea.x=16;
        solidArea.y=15;
        solidArea.height=40;
        solidArea.width=27;
        solidArea_defaultX=solidArea.x;
        solidArea_defaultY=solidArea.y;
        getNPCImage();
    }
    public void getNPCImage()
    {
        down=new BufferedImage[2];
        down[0] = setup("/res/Baraka_Sprites/stay_1.png");
        down[0]= TileScaler.scaleImage(down[0],60,60);
        down[1] = setup("/res/Baraka_Sprites/stay_2.png");
        down[1]= TileScaler.scaleImage(down[1],60,60);

    }
    public void Update() {
        super.Update();
        sprite_counter++;
        if (sprite_counter > 60) {
            if (spriteNum == 1)
                spriteNum = 0;
            else
                spriteNum++;
            sprite_counter = 0;
        }
    }
    @Override
    public void Draw(Graphics g)
    {
        BufferedImage image=null;
        int screenX=WorldX-game.player1.WorldX+game.player1.screenX;
        int screenY=WorldY-game.player1.WorldY+game.player1.screenY;
        if (WorldX + game.Tile_Size()>game.player1.WorldX-game.player1.screenX &&
                WorldX- game.Tile_Size()<game.player1.WorldX+game.player1.screenX &&
                WorldY+ game.Tile_Size()>game.player1.WorldY-game.player1.screenY &&
                WorldY- game.Tile_Size()<game.player1.WorldY+game.player1.screenY )
        {

            switch (spriteNum){
                case 0:
                    image=down[0];
                    break;
                case 1:
                    image=down[1];
                    break;
            }
            g.drawImage(image,screenX,screenY,null);
        }
    }
}
