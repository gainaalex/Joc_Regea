package Graphics.Objects;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obj_Door extends Super_Obj{
    public Obj_Door(Game game)
    {
        super(game);
        name="Door";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/Objects/castledoors.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
