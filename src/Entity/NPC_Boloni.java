package Entity;

import Graphics.Objects.Super_Obj;
import Regea_The_Game_v1.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class NPC_Boloni extends Entity {
    public int actionCounter=0;
    public NPC_Boloni(Game g) {
        super(g);
        name="Boloni";
        direction="left";
        speed=1;
        damage=22;
        maxHealth=80;
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
        left[0]=setup("/res/Boloni_Sprites/walk/left/tile000.png");
        left[1]=setup("/res/Boloni_Sprites/walk/left/tile001.png");
        left[2]=setup("/res/Boloni_Sprites/walk/left/tile002.png");
        left[3]=setup("/res/Boloni_Sprites/walk/left/tile003.png");
        left[4]=setup("/res/Boloni_Sprites/walk/left/tile004.png");
        left[5]=setup("/res/Boloni_Sprites/walk/left/tile005.png");
        left[6]=setup("/res/Boloni_Sprites/walk/left/tile006.png");
        left[7]=setup("/res/Boloni_Sprites/walk/left/tile007.png");
        left[8]=setup("/res/Boloni_Sprites/walk/left/tile008.png");

        right[0]=setup("/res/Boloni_Sprites/walk/right/tile026.png");
        right[1]=setup("/res/Boloni_Sprites/walk/right/tile027.png");
        right[2]=setup("/res/Boloni_Sprites/walk/right/tile028.png");
        right[3]=setup("/res/Boloni_Sprites/walk/right/tile029.png");
        right[4]=setup("/res/Boloni_Sprites/walk/right/tile030.png");
        right[5]=setup("/res/Boloni_Sprites/walk/right/tile031.png");
        right[6]=setup("/res/Boloni_Sprites/walk/right/tile032.png");
        right[7]=setup("/res/Boloni_Sprites/walk/right/tile033.png");
        right[8]=setup("/res/Boloni_Sprites/walk/right/tile034.png");

        left=scaleImagesEntity(left,2,2);
        right=scaleImagesEntity(right,2,2);
        scaleSolidArea(2,2);

    }
    public void getAttackImages()
    {
        attackLeft=new BufferedImage[6];
        attackLeft[0]=setup("/res/Boloni_Sprites/attack/left/tile052.png");
        attackLeft[1]=setup("/res/Boloni_Sprites/attack/left/tile053.png");
        attackLeft[2]=setup("/res/Boloni_Sprites/attack/left/tile054.png");
        attackLeft[3]=setup("/res/Boloni_Sprites/attack/left/tile055.png");
        attackLeft[4]=setup("/res/Boloni_Sprites/attack/left/tile056.png");
        attackLeft[5]=setup("/res/Boloni_Sprites/attack/left/tile057.png");

        attackRight=new BufferedImage[6];
        attackRight[0]=setup("/res/Boloni_Sprites/attack/right/tile078.png");
        attackRight[1]=setup("/res/Boloni_Sprites/attack/right/tile079.png");
        attackRight[2]=setup("/res/Boloni_Sprites/attack/right/tile080.png");
        attackRight[3]=setup("/res/Boloni_Sprites/attack/right/tile081.png");
        attackRight[4]=setup("/res/Boloni_Sprites/attack/right/tile082.png");
        attackRight[5]=setup("/res/Boloni_Sprites/attack/right/tile083.png");

        attackLeft=scaleImagesEntity(attackLeft,2,2);
        attackRight=scaleImagesEntity(attackRight,2,2);

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
                    //tempWorldX-=game.Tile_Size();
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
        if(sprite_counter>20)
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
