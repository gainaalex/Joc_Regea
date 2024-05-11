package Entity;

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
        solidArea=new Rectangle(16,32,12,10);
        keyboard_command=Ck;
        screenX=(game.GetWndWidth()/2)-(game.wnd.Tile_Size/2);
        screenY=(game.GetWndHeight()/2)-(game.wnd.Tile_Size/2);

        solidArea_defaultX=solidArea.x;
        solidArea_defaultY=solidArea.y;

        this.set_position();
        this.getPlayerImage();
    }

    public void set_position()
    {
        WorldX=game.Tile_Size()*23;
        WorldY=game.Tile_Size()*36;
        speed=5;
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

    public void Update()
    {
        if(keyboard_command.left_command || keyboard_command.up_command
                                || keyboard_command.down_command || keyboard_command.right_command) {

            if (keyboard_command.up_command) {
                direction="up";
                //    WorldY -= speed;

            }
            if (keyboard_command.down_command) {
                direction="down";

                  //  WorldY += speed;
            }
            if (keyboard_command.left_command) {
                direction="left";

                 //   WorldX -= speed;
            }
            if (keyboard_command.right_command) {
                direction="right";

                 //   WorldX += speed;
            }

            // verific daca are coliziune cu tile ul
            isCollision=false;
            //game.collision.checkTile(this);

            int object_index=game.collision.checkObj(this,true);
            pickItem(object_index);

            if (isCollision==false)
            {
                switch (direction)
                {
                    case "up":WorldY -= speed;break;
                    case "down":WorldY += speed;break;
                    case "left":WorldX -= speed;break;
                    case "right":WorldX += speed;break;
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
        }
        else
        {
            spriteNum=0;
        }

    }
    public void Draw(Graphics g)
    {
        BufferedImage img=null;

        switch (direction){
            case "up":
                switch (spriteNum){
                    case 0:
                        img=up[0];
                        break;
                    case 1:
                        img=up[1];
                        break;
                    case 2:
                        img=up[2];
                        break;
                    case 3:
                        img=up[3];
                        break;
                    case 4:
                        img=up[4];
                        break;
                    case 5:
                        img=up[5];
                        break;
                    case 6:
                        img=up[6];
                        break;
                    case 7:
                        img=up[7];
                        break;
                    case 8:
                        img=up[8];
                        break;

                }
                break;
            case "down":
                switch (spriteNum){
                    case 0:
                        img=down[0];
                        break;
                    case 1:
                        img=down[1];
                        break;
                    case 2:
                        img=down[2];
                        break;
                    case 3:
                        img=down[3];
                        break;
                    case 4:
                        img=down[4];
                        break;
                    case 5:
                        img=down[5];
                        break;
                    case 6:
                        img=down[6];
                        break;
                    case 7:
                        img=down[7];
                        break;
                    case 8:
                        img=down[8];
                        break;
                }
                break;
            case "left":
                switch (spriteNum){
                    case 0:
                        img=left[0];
                        break;
                    case 1:
                        img=left[1];
                        break;
                    case 2:
                        img=left[2];
                        break;
                    case 3:
                        img=left[3];
                        break;
                    case 4:
                        img=left[4];
                        break;
                    case 5:
                        img=left[5];
                        break;
                    case 6:
                        img=left[6];
                        break;
                    case 7:
                        img=left[7];
                        break;
                    case 8:
                        img=left[8];
                        break;
                }
                break;
            case "right":
                switch (spriteNum){
                    case 0:
                        img=right[0];
                        break;
                    case 1:
                        img=right[1];
                        break;
                    case 2:
                        img=right[2];
                        break;
                    case 3:
                        img=right[3];
                        break;
                    case 4:
                        img=right[4];
                        break;
                    case 5:
                        img=right[5];
                        break;
                    case 6:
                        img=right[6];
                        break;
                    case 7:
                        img=right[7];
                        break;
                    case 8:
                        img=right[8];
                        break;
                }
                break;
        }
        g.drawImage(img,screenX,screenY,null);
        /*g.setColor(Color.white);
        g.fillRect(x,y, game.Tile_Size(), game.Tile_Size());*/
    }

    public void pickItem(int i) {
        if (i != -1) {
            String obj_name=game.obj_list[i].name;
            switch (obj_name)
            {
                case "Door":
                    game.sound.setFile(3);
                    game.sound.play();
                        try {
                            game.obj_list[i].image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/castledoors_open.png"));
                            game.obj_list[i].image=TileScaler.scaleImage(game.obj_list[0].image,game.Tile_Size(),game.Tile_Size());
                            game.obj_list[i].name="Open_Door";
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
