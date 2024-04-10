package Graphics.Objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obj_Boots extends Super_Obj{
    public Obj_Boots()
    {
        name="Boots";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/Objects/chain_boots.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision=true;
    }
}
