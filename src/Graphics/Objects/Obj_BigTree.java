package Graphics.Objects;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_BigTree extends Super_Obj{
    public Obj_BigTree(Game game)
    {
        super(game);
        name="BigTree";
        solidArea_defaultY=4*game.Tile_Size()+16;
        solidArea_defaultX=game.Tile_Size()/2;
        solidArea.width=3*game.Tile_Size();
        solidArea.height=game.Tile_Size();
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/big tree/baum.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        priority_over_player=true;
        collision=true;
    }
}
