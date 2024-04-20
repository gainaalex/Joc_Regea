package Entity;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC_Baraka extends Entity {

    public NPC_Baraka(Game g) {
        super(g);
        direction="down";
        speed=0;
        solidArea.x=0;
        solidArea.y=0;
        solidArea.height=48;
        solidArea.width=48;
    }
    public void getPlayerImage()
    {
        down=new BufferedImage[2];
        try{
            down[0] = ImageIO.read(getClass().getResourceAsStream("/res/Baraka_Sprites/stay_1.png"));
            down[0] = ImageIO.read(getClass().getResourceAsStream("/res/Baraka_Sprites/stay_2.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
