package Entity;

import Graphics.TileScaler;
import Regea_The_Game_v1.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.spi.AbstractResourceBundleProvider;

public class NPC_Baraka_Fight extends Entity{

    public int actionCounter=0;
    public NPC_Baraka_Fight(Game g) {
        super(g);
        name="Baraka_Fight";
        direction="left";
        speed=2;
        maxHealth=100;
        currentLife=maxHealth;
        solidArea.x=0;
        solidArea.y=0;
        solidArea.width=48;
        solidArea.height=48;
        solidArea_defaultX=solidArea.x;
        solidArea_defaultY=solidArea.y;
        getNPCImage();
    }
    public void getNPCImage()
    {
        left=new BufferedImage[9];
        right=new BufferedImage[9];
        left[0]=setup("/res/Baraka_Sprites/baraka/animations/left/tile162.png");
        left[1]=setup("/res/Baraka_Sprites/baraka/animations/left/tile163.png");
        left[2]=setup("/res/Baraka_Sprites/baraka/animations/left/tile164.png");
        left[3]=setup("/res/Baraka_Sprites/baraka/animations/left/tile165.png");
        left[4]=setup("/res/Baraka_Sprites/baraka/animations/left/tile166.png");
        left[5]=setup("/res/Baraka_Sprites/baraka/animations/left/tile167.png");
        left[6]=setup("/res/Baraka_Sprites/baraka/animations/left/tile168.png");
        left[7]=setup("/res/Baraka_Sprites/baraka/animations/left/tile169.png");
        left[8]=setup("/res/Baraka_Sprites/baraka/animations/left/tile170.png");

        right[0]=setup("/res/Baraka_Sprites/baraka/animations/right/tile198.png");
        right[1]=setup("/res/Baraka_Sprites/baraka/animations/right/tile199.png");
        right[2]=setup("/res/Baraka_Sprites/baraka/animations/right/tile200.png");
        right[3]=setup("/res/Baraka_Sprites/baraka/animations/right/tile201.png");
        right[4]=setup("/res/Baraka_Sprites/baraka/animations/right/tile202.png");
        right[5]=setup("/res/Baraka_Sprites/baraka/animations/right/tile203.png");
        right[6]=setup("/res/Baraka_Sprites/baraka/animations/right/tile204.png");
        right[7]=setup("/res/Baraka_Sprites/baraka/animations/right/tile205.png");
        right[8]=setup("/res/Baraka_Sprites/baraka/animations/right/tile206.png");

        left=scaleImagesEntity(left,2,2);
        right=scaleImagesEntity(right,2,2);
        scaleSolidArea(2,2);

    }
    public void getAttackImages()
    {
        attackLeft=new BufferedImage[6];
        attackLeft[0]=setup("/res/Baraka_Sprites/baraka/animations/attack_left/tile006.png");
        attackLeft[1]=setup("/res/Baraka_Sprites/baraka/animations/attack_left/tile007.png");
        attackLeft[2]=setup("/res/Baraka_Sprites/baraka/animations/attack_left/tile008.png");
        attackLeft[3]=setup("/res/Baraka_Sprites/baraka/animations/attack_left/tile009.png");
        attackLeft[4]=setup("/res/Baraka_Sprites/baraka/animations/attack_left/tile010.png");
        attackLeft[5]=setup("/res/Baraka_Sprites/baraka/animations/attack_left/tile011.png");

        attackRight=new BufferedImage[6];
        attackRight[0]=setup("/res/Baraka_Sprites/baraka/animations/attack_right/tile018.png");
        attackRight[1]=setup("/res/Baraka_Sprites/baraka/animations/attack_right/tile019.png");
        attackRight[2]=setup("/res/Baraka_Sprites/baraka/animations/attack_right/tile020.png");
        attackRight[3]=setup("/res/Baraka_Sprites/baraka/animations/attack_right/tile021.png");
        attackRight[4]=setup("/res/Baraka_Sprites/baraka/animations/attack_right/tile022.png");
        attackRight[5]=setup("/res/Baraka_Sprites/baraka/animations/attack_right/tile023.png");

        attackLeft=scaleImagesEntity(attackLeft,2,1);
        attackRight=scaleImagesEntity(attackRight,2,1);

    }

    public void setAction()
    {
        actionCounter++;
        if(actionCounter==120)
        {
            Random rnd=new Random();
            int i=rnd.nextInt(2);
            switch (i)
            {
                case 0:
                    direction="left";
                    break;
                case 1:
                    direction="right";
                    break;

            }
            actionCounter=0;
        }
    }
    public void Update()
    {
        super.Update();
        if(!isCollision)
        {
            //setAction();
            switch (direction)
            {
                case "left":
                    WorldX-=speed;
                    break;
                case "right":
                    WorldX+=speed;
                    break;
            }
            sprite_counter++;
            if (sprite_counter > 10) {
                if (spriteNum == 8)
                    spriteNum = 0;
                else
                    spriteNum++;
                sprite_counter = 0;
            }
        }
        else
        {
            System.out.println("baraka atinge");
            spriteNum=0;
            switch (direction)
            {
                case "left":
                    direction="right";
                    break;
                case "right":
                    direction="left";
                    break;
            }

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
            switch (direction)
            {
                case "left":
                    switch (spriteNum){
                        case 0:
                            image=left[0];
                            break;
                        case 1:
                            image=left[1];
                            break;
                        case 2:
                            image=left[2];
                            break;
                        case 3:
                            image=left[3];
                            break;
                        case 4:
                            image=left[4];
                            break;
                        case 5:
                            image=left[5];
                            break;
                        case 6:
                            image=left[6];
                            break;
                        case 7:
                            image=left[7];
                            break;
                        case 8:
                            image=left[8];
                            break;
                    }
                    break;
                case "right":
                    switch (spriteNum){
                        case 0:
                            image=right[0];
                            break;
                        case 1:
                            image=right[1];
                            break;
                        case 2:
                            image=right[2];
                            break;
                        case 3:
                            image=right[3];
                            break;
                        case 4:
                            image=right[4];
                            break;
                        case 5:
                            image=right[5];
                            break;
                        case 6:
                            image=right[6];
                            break;
                        case 7:
                            image=right[7];
                            break;
                        case 8:
                            image=right[8];
                            break;
                    }
                    break;
            }

            g.drawImage(image,screenX,screenY,null);
        }
    }

}