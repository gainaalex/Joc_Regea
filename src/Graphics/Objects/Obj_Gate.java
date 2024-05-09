package Graphics.Objects;

import Graphics.TileScaler;
import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Gate extends Super_Obj{
    public Obj_Gate(Game g) {
        super(g);
        name="Gate";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/Castle/Gate/gate-v2.png"));
            image= TileScaler.scaleImage(image,game.Tile_Size()*8,game.Tile_Size()*5);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        priority_over_player=true;
    }
}
