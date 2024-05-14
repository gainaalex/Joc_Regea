package Graphics.Objects;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_OneTile_Obj extends Super_Obj{
    public Obj_OneTile_Obj(Game game, int type)
    {
        super(game);
        name="OneTile_Obj"+type;
        try{
            switch (type)
            {
                case 0:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Castle/tron/image_2024-05-06_162833793-removebg-preview.png"));
                    break;
                case 1:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Castle/de adaugat/arme.png"));
                    break;
                case 2:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Castle/de adaugat/masa.png"));
                    break;
                case 3:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Castle/de adaugat/mormant_stefan.png"));
                    break;
                case 4:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Castle/de adaugat/sageti.png"));
                    break;
                case 5:
                    //buda
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/buda.png"));
                    break;
                //munte
                case 6:
                    image= ImageIO.read(getClass().getResourceAsStream("/res/Munte/fnal/idee_final_v1.png"));
                    break;
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision=true;
    }

}
