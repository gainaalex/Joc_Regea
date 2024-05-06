package Graphics.Objects;

import Graphics.TileScaler;
import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obj_Boots extends Super_Obj{
    public Obj_Boots(Game game)
    {
        super(game);
        name="Boots";
        //image=setup("/res/Objects/chain_boots.png");
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/Objects/chain_boots.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision=true;
    }
}
