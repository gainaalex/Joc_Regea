package Graphics.Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Door extends Super_Obj{
    public Obj_Door()
    {
        name="Door";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/Objects/castledoors.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision=true;
    }
}
