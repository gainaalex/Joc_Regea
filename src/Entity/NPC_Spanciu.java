package Entity;

import Regea_The_Game_v1.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class NPC_Spanciu extends Entity{
    public int actionCounter=0;
    public NPC_Spanciu(Game g) {
        super(g);
        name="Spanciu";
        direction="left";
        speed=1;
        damage=20;
        maxHealth=100;
        currentLife=maxHealth;
        knockback=game.Tile_Size();

        solidArea.x=14;
        solidArea.y=0;
        solidArea.width=20;
        solidArea.height=43;
        solidArea_defaultX=solidArea.x;
        solidArea_defaultY=solidArea.y;

        //attack area
        attackArea.x=0;
        attackArea.y=0;
        attackArea.width=28;
        attackArea.height=32;
        getNPCImage();
        getAttackImages();
    }
    public void getNPCImage()
    {
        left=new BufferedImage[9];
        right=new BufferedImage[9];
        left[0]=setup("/res/Spanciu_Sprites/no_attack/left/tile024.png");
        left[1]=setup("/res/Spanciu_Sprites/no_attack/left/tile025.png");
        left[2]=setup("/res/Spanciu_Sprites/no_attack/left/tile026.png");
        left[3]=setup("/res/Spanciu_Sprites/no_attack/left/tile027.png");
        left[4]=setup("/res/Spanciu_Sprites/no_attack/left/tile028.png");
        left[5]=setup("/res/Spanciu_Sprites/no_attack/left/tile029.png");
        left[6]=setup("/res/Spanciu_Sprites/no_attack/left/tile030.png");
        left[7]=setup("/res/Spanciu_Sprites/no_attack/left/tile031.png");
        left[8]=setup("/res/Spanciu_Sprites/no_attack/left/tile032.png");

        right[0]=setup("/res/Spanciu_Sprites/no_attack/right/tile072.png");
        right[1]=setup("/res/Spanciu_Sprites/no_attack/right/tile073.png");
        right[2]=setup("/res/Spanciu_Sprites/no_attack/right/tile074.png");
        right[3]=setup("/res/Spanciu_Sprites/no_attack/right/tile075.png");
        right[4]=setup("/res/Spanciu_Sprites/no_attack/right/tile076.png");
        right[5]=setup("/res/Spanciu_Sprites/no_attack/right/tile077.png");
        right[6]=setup("/res/Spanciu_Sprites/no_attack/right/tile078.png");
        right[7]=setup("/res/Spanciu_Sprites/no_attack/right/tile079.png");
        right[8]=setup("/res/Spanciu_Sprites/no_attack/right/tile080.png");

        left=scaleImagesEntity(left,2,2);
        right=scaleImagesEntity(right,2,2);
        scaleSolidArea(2,2);

    }
    public void getAttackImages()
    {
        attackLeft=new BufferedImage[6];
        attackLeft[0]=setup("/res/Spanciu_Sprites/attack/templeft/tile008.png");
        attackLeft[1]=setup("/res/Spanciu_Sprites/attack/templeft/tile009.png");
        attackLeft[2]=setup("/res/Spanciu_Sprites/attack/templeft/tile010.png");
        attackLeft[3]=setup("/res/Spanciu_Sprites/attack/templeft/tile011.png");
        attackLeft[4]=setup("/res/Spanciu_Sprites/attack/templeft/tile012.png");
        attackLeft[5]=setup("/res/Spanciu_Sprites/attack/templeft/tile013.png");

        attackRight=new BufferedImage[6];
        attackRight[0]=setup("/res/Spanciu_Sprites/attack/tempright/tile008.png");
        attackRight[1]=setup("/res/Spanciu_Sprites/attack/tempright/tile009.png");
        attackRight[2]=setup("/res/Spanciu_Sprites/attack/tempright/tile010.png");
        attackRight[3]=setup("/res/Spanciu_Sprites/attack/tempright/tile011.png");
        attackRight[4]=setup("/res/Spanciu_Sprites/attack/tempright/tile012.png");
        attackRight[5]=setup("/res/Spanciu_Sprites/attack/tempright/tile013.png");

        attackLeft=scaleImagesEntity(attackLeft,4,2);
        attackRight=scaleImagesEntity(attackRight,4,2);

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
        if(invincible)
        {
            if(invincibleCounter==240)
            {
                invincible=false;
                System.out.println("gata invincibilitate");
                invincibleCounter=0;
            }
            invincibleCounter++;
        }
        if(!inAir)
        {
            isCollision=false;
            game.collision.CheckFloor(this);
            if(!isCollision)
                inAir=true;

        }
        if(inAir)
        {
            if(airSpeed>0)
            {
                falling=true;
                airSpeed=fallSpeed;
            }
            if(!falling)
                airSpeed+=gravity;
            WorldY+=airSpeed;

            isCollision=false;
            game.collision.CheckFloor(this);
            if(isCollision)
            {
                inAir=false;
                falling=false;
            }

        }
        isCollision=false;
        game.collision.check_interaction_w_player(this);
        if(!isCollision && !attacking)
        {
            //attacking=false;
            if(game.player1.WorldX<WorldX)
                direction="left";
            else direction="right";
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
                if (spriteNum == 5)
                    spriteNum = 0;
                else
                    spriteNum++;
                sprite_counter = 0;
            }
        }
        else
        {
            attacking=true;
            //spriteNum=0;
            //sprite_counter=0;
        }
        if(attacking)
        {
            attackingAnim();
        }
/*


        super.Update();
        if(Objects.equals(direction, "left") && WorldX-speed<0)
            isCollision=true;
        if(!isCollision)
        {
            //setAction();
            switch (direction)
            {
                case "left":
                    WorldX -= speed;
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
            //System.out.println("baraka atinge");
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

        }*/
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
                    image=left[spriteNum];
                    break;
                case "right":
                    image=right[spriteNum];
                    break;
            }

            g.drawImage(image,screenX,screenY,null);
        }
    }
    @Override
    public void Draw_In_Fights(Graphics g)
    {
        int tempWorldX=WorldX;
        int tempWorldY=WorldY;

        BufferedImage image=null;
        if(!attacking) {
            switch (direction) {
                case "left":
                    image = left[spriteNum];
                    break;
                case "right":
                    image = right[spriteNum];
                    break;
            }
        }
        else {
            switch (direction)
            {
                case "left":
                    tempWorldX-=game.Tile_Size();
                    image=attackLeft[spriteNum];
                    break;
                case "right":
                    image=attackRight[spriteNum];
                    break;
            }
        }

        g.drawImage(image,tempWorldX,tempWorldY,null);
    }
    private void attackingAnim() {
        sprite_counter++;
        if(sprite_counter>25)
        {
            spriteNum++;
            if(spriteNum==4)
            {
                int currentWorldX=WorldX;
                int currentsolidAreaWidth=solidArea.width;
                int currentsolidAreaHeigth=solidArea.height;

                switch (direction)
                {
                    case "left":
                        WorldX-=attackArea.width;
                        break;
                    case "right":
                        WorldX+=attackArea.width;
                        break;
                }
                solidArea.width=attackArea.width;
                solidArea.height=attackArea.height;

                isCollision=false;
                game.collision.check_interaction_w_player(this);
                //System.out.println(isCollision);
                if(isCollision)
                {
                    game.player1.currentLife-=damage;
                    game.player1.invincible=true;
                    if(Objects.equals(direction, "left"))
                    {
                        if(game.player1.WorldX-knockback>=0)
                        {
                            game.player1.WorldX=game.player1.WorldX-knockback;
                        }

                    }
                    else {
                        if(game.player1.WorldX+knockback<=18*game.Tile_Size())
                        {
                            game.player1.WorldX=game.player1.WorldX+knockback;
                        }
                    }
                    System.out.println(game.player1.currentLife);
                }

                WorldX=currentWorldX;
                solidArea.width=currentsolidAreaWidth;
                solidArea.height=currentsolidAreaHeigth;
            }
            if(spriteNum>=5) {
                spriteNum = 0;
                attacking=false;
            }
            sprite_counter=0;
        }
    }
}
