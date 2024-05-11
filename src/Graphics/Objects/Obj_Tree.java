package Graphics.Objects;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Tree extends Super_Obj{
    public Obj_Tree(Game game, int type)
    {
        super(game);
        name="Tree"+type;
        try{
            switch (type)
            {
                case 0:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/big tree/copac_1.png"));
                    break;
                case 1:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/big tree/copac_2.png"));
                    break;
                default:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/big tree/copac_1.png"));
                    break;
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        priority_over_player=true;
        collision=true;
    }
}
