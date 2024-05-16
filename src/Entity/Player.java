package Entity;

import Regea_The_Game_v1.Collision;
import Regea_The_Game_v1.CommandKeys;
import Regea_The_Game_v1.Game;
import Graphics.*;
import res.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.Objects;

public class Player extends Entity{
    private CommandKeys keyboard_command;
    public final int screenX;
    public final int screenY;
    public Player(Game g, CommandKeys Ck)
    {
        super(g);
        name="Player";
        solidArea=new Rectangle(16,32,12,10);
        keyboard_command=Ck;
        screenX=(game.GetWndWidth()/2)-(game.wnd.Tile_Size/2);
        screenY=(game.GetWndHeight()/2)-(game.wnd.Tile_Size/2);

        solidArea_defaultX=solidArea.x;
        solidArea_defaultY=solidArea.y;

        this.set_position(55,55);
        this.getPlayerImage();
        this.getAttackAnimations();
    }



    public void set_position(int x, int y)
    {
        WorldX=game.Tile_Size()*x;
        WorldY=game.Tile_Size()*y;
        speed=7;
        direction="down";

    }

    public void getPlayerImage()
    {
        up=new BufferedImage[9];
        down=new BufferedImage[9];
        left=new BufferedImage[9];
        right=new BufferedImage[9];
        up[0] = setup("/res/Regea_Sprites/walk_up/image_8-0.png");
        up[1] = setup("/res/Regea_Sprites/walk_up/image_8-1.png");
        up[2] = setup("/res/Regea_Sprites/walk_up/image_8-2.png");
        up[3] = setup("/res/Regea_Sprites/walk_up/image_8-3.png");
        up[4] = setup("/res/Regea_Sprites/walk_up/image_8-4.png");
        up[5] = setup("/res/Regea_Sprites/walk_up/image_8-5.png");
        up[6] = setup("/res/Regea_Sprites/walk_up/image_8-6.png");
        up[7] = setup("/res/Regea_Sprites/walk_up/image_8-7.png");
        up[8] = setup("/res/Regea_Sprites/walk_up/image_8-8.png");

        down[0] = setup("/res/Regea_Sprites/walk_down/image_10-0.png");
        down[1] = setup("/res/Regea_Sprites/walk_down/image_10-1.png");
        down[2] = setup("/res/Regea_Sprites/walk_down/image_10-2.png");
        down[3] = setup("/res/Regea_Sprites/walk_down/image_10-3.png");
        down[4] = setup("/res/Regea_Sprites/walk_down/image_10-4.png");
        down[5] = setup("/res/Regea_Sprites/walk_down/image_10-5.png");
        down[6] = setup("/res/Regea_Sprites/walk_down/image_10-6.png");
        down[7] = setup("/res/Regea_Sprites/walk_down/image_10-7.png");
        down[8] = setup("/res/Regea_Sprites/walk_down/image_10-8.png");


        left[0] = setup("/res/Regea_Sprites/walk_left/image_9-0.png");
        left[1] = setup("/res/Regea_Sprites/walk_left/image_9-1.png");
        left[2] = setup("/res/Regea_Sprites/walk_left/image_9-2.png");
        left[3] = setup("/res/Regea_Sprites/walk_left/image_9-3.png");
        left[4] = setup("/res/Regea_Sprites/walk_left/image_9-4.png");
        left[5] = setup("/res/Regea_Sprites/walk_left/image_9-5.png");
        left[6] = setup("/res/Regea_Sprites/walk_left/image_9-6.png");
        left[7] = setup("/res/Regea_Sprites/walk_left/image_9-7.png");
        left[8] = setup("/res/Regea_Sprites/walk_left/image_9-8.png");

        right[0] = setup("/res/Regea_Sprites/walk_right/image_11-0.png");
        right[1] = setup("/res/Regea_Sprites/walk_right/image_11-1.png");
        right[2] = setup("/res/Regea_Sprites/walk_right/image_11-2.png");
        right[3] = setup("/res/Regea_Sprites/walk_right/image_11-3.png");
        right[4] = setup("/res/Regea_Sprites/walk_right/image_11-4.png");
        right[5] = setup("/res/Regea_Sprites/walk_right/image_11-5.png");
        right[6] = setup("/res/Regea_Sprites/walk_right/image_11-6.png");
        right[7] = setup("/res/Regea_Sprites/walk_right/image_11-7.png");
        right[8] = setup("/res/Regea_Sprites/walk_right/image_11-8.png");
    }

    public void getAttackAnimations()
    {
        attackLeft=new BufferedImage[6];
        attackLeft[0]=setup("/res/Regea_Sprites/attack_left/tile008.png");
        attackLeft[1]=setup("/res/Regea_Sprites/attack_left/tile009.png");
        attackLeft[2]=setup("/res/Regea_Sprites/attack_left/tile010.png");
        attackLeft[3]=setup("/res/Regea_Sprites/attack_left/tile011.png");
        attackLeft[4]=setup("/res/Regea_Sprites/attack_left/tile012.png");
        attackLeft[5]=setup("/res/Regea_Sprites/attack_left/tile013.png");

        attackRight=new BufferedImage[6];
        attackRight[0]=setup("/res/Regea_Sprites/attack_right/tile024.png");
        attackRight[1]=setup("/res/Regea_Sprites/attack_right/tile025.png");
        attackRight[2]=setup("/res/Regea_Sprites/attack_right/tile026.png");
        attackRight[3]=setup("/res/Regea_Sprites/attack_right/tile027.png");
        attackRight[4]=setup("/res/Regea_Sprites/attack_right/tile028.png");
        attackRight[5]=setup("/res/Regea_Sprites/attack_right/tile029.png");

        attackLeft=scaleImagesEntity(attackLeft,2,1);
        attackRight=scaleImagesEntity(attackRight,2,1);
    }

    public void Update()
    {
        int npc_index=game.collision.checkEntity(this,game.bosses);
        contactBoss(npc_index);
        if(invincible)
        {
            if(invincibleCounter==120)
            {
                invincible=false;
                invincibleCounter=0;
            }
            invincibleCounter++;
        }
        if(keyboard_command.enter_command && !attacking)
        {
            attacking=true;
            spriteNum=0;
            sprite_counter=0;
        }
        if(attacking)
        {
            attackingAnim();
        }
        else {
            if (keyboard_command.left_command || keyboard_command.up_command
                    || keyboard_command.down_command || keyboard_command.right_command || keyboard_command.e_command) {

                if (keyboard_command.up_command) {
                    direction = "up";
                    //    WorldY -= speed;

                }
                if (keyboard_command.down_command) {
                    direction = "down";

                    //  WorldY += speed;
                }
                if (keyboard_command.left_command) {
                    direction = "left";

                    //   WorldX -= speed;
                }
                if (keyboard_command.right_command) {
                    direction = "right";

                    //   WorldX += speed;
                }

                // verific daca are coliziune cu tile ul
                isCollision = false;
                game.collision.checkTile(this);

                int object_index = game.collision.checkObj(this, true);
                pickItem(object_index);
                npc_index = game.collision.checkEntity(this, game.npc_list);
                interactNPC(npc_index);
                if (keyboard_command.left_command || keyboard_command.up_command
                        || keyboard_command.down_command || keyboard_command.right_command)
                    if (!isCollision) {
                        switch (direction) {
                            case "up":
                                WorldY -= speed;
                                break;
                            case "down":
                                WorldY += speed;
                                break;
                            case "left":
                                WorldX -= speed;
                                break;
                            case "right":
                                WorldX += speed;
                                break;
                        }
                    }
                sprite_counter++;
                if (sprite_counter > 10) {
                    if (spriteNum == 8)
                        spriteNum = 0;
                    else
                        spriteNum++;
                    sprite_counter = 0;
                }
            } else {
                spriteNum = 0;
            }
        }
        game.eventInterpretor.checkEvent();
    }

    private void attackingAnim() {
        sprite_counter++;
        if(sprite_counter>15)
        {
            spriteNum++;
            if(spriteNum>=5) {
                spriteNum = 0;
                attacking=false;
            }
            sprite_counter=0;
        }
    }

    public void interactNPC(int npc_index) {
        if(npc_index!=-1)
        {
            if(keyboard_command.e_command) {
                if (npc_index == 0) {
                    System.out.println("tatati");
                }
                keyboard_command.e_command=false;
            }
        }
    }

    public void contactBoss(int npcIndex) {
        if(npcIndex!=-1)
        {
            if(npcIndex==0) {
                if(invincible==false)
                {
                    System.out.println("sugi");
                    invincible=true;
                }
            }
        }

    }

    public void Update_InFights()
    {
        if(keyboard_command.left_command || keyboard_command.right_command || keyboard_command.jump || inAir)
        {
            if (keyboard_command.left_command) {
                direction="left";

                //   WorldX -= speed;
            }
            if (keyboard_command.right_command) {
                direction="right";

                //   WorldX += speed;
            }
            if(keyboard_command.jump) {
                jump();
            }
            if(!keyboard_command.left_command && !keyboard_command.right_command && !keyboard_command.jump && !inAir)
                return;
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
            if(keyboard_command.left_command || keyboard_command.right_command)
                moveX();

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
            spriteNum=0;
        }
    }


    private void jump() {
        if(inAir)
            return;
        inAir=true;
        airSpeed=jumpSpeed;
        falling=false;
    }
    private void resetInAir()
    {
        falling=true;
        airSpeed=0;
    }
    private void moveX() {
        isCollision = false;
        game.collision.CheckSides(this);
        int object_index = game.collision.checkObj(this, true);
        int npc_index = game.collision.checkEntity(this, game.npc_list);
        if (!isCollision) {
            switch (direction) {
                case "left":
                    WorldX -= speed;
                    break;
                case "right":
                    WorldX += speed;
                    break;
            }
        }

    }
    @Override
    public void Draw(Graphics g)
    {
        BufferedImage img=null;
        if(!attacking) {
            switch (direction) {
                case "up":
                    img=up[spriteNum];
                    break;
                case "down":
                    img = down[spriteNum];
                    break;
                case "left":
                    img=left[spriteNum];
                    break;
                case "right":
                    img=right[spriteNum];
                    break;
            }
        }
        else {
            switch (direction)
            {
                case "left":
                    img=attackLeft[spriteNum];
                    break;
                case "right":
                    img=attackRight[spriteNum];
                    break;
            }
        }
        g.drawImage(img,screenX,screenY,null);
    }

    public void pickItem(int i) {
        if (i != -1) {
            String obj_name=game.obj_list[game.wnd.currentMap][i].name;
            switch (obj_name)
            {
                case "Door":
                    game.sound.setFile(3);
                    game.sound.play();
                        try {
                            game.obj_list[game.wnd.currentMap][i].image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/castledoors_open.png"));
                            game.obj_list[game.wnd.currentMap][i].image=TileScaler.scaleImage(game.obj_list[game.wnd.currentMap][0].image,game.Tile_Size(),game.Tile_Size());
                            game.obj_list[game.wnd.currentMap][i].name="Open_Door";
                        }catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    break;
                case "Boots":
                {
                    game.sound.setFile(1);
                    game.sound.play();
                    speed+=10;
                    game.obj_list[i]=null;
                }
            }
        }
    }
}
