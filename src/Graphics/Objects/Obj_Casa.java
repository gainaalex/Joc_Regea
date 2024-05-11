package Graphics.Objects;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Casa extends Super_Obj{
    public Obj_Casa(Game game, int type)
    {
        super(game);
        name="Casa"+type;
        try{
            switch (type) {
                case 0:
                    image = ImageIO.read(getClass().getResourceAsStream("/res/Houses/modelcasa_spate.png"));
                    break;
                case 1:
                    image = ImageIO.read(getClass().getResourceAsStream("/res/Houses/house materials/house1x2.gif"));
                    break;
                case 2:
                    image = ImageIO.read(getClass().getResourceAsStream("/res/Houses/house materials/house2x2.gif"));
                    break;
                case 3:
                    image = ImageIO.read(getClass().getResourceAsStream("/res/Houses/house materials/House.png"));
                    break;
                case 4:
                    image = ImageIO.read(getClass().getResourceAsStream("/res/Houses/modelcasa.png"));
                    break;
                case 5:
                    image = ImageIO.read(getClass().getResourceAsStream("/res/Houses/modelcasav2.png"));
                    break;
                case 6://casa vrajitoarei
                    image = ImageIO.read(getClass().getResourceAsStream("/res/Houses/house materials/house3x2.gif"));
                    break;
                default:
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
