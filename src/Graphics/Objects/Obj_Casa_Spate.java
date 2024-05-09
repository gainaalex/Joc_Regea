package Graphics.Objects;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Casa_Spate extends Super_Obj{
    public Obj_Casa_Spate(Game game)
    {
        super(game);
        name="Casa_Spate";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/Houses/modelcasa_spate.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        priority_over_player=true;
        collision=true;
    }
}
