package Regea_The_Game_v1;

import Graphics.Objects.Obj_Boots;
import Graphics.Objects.Obj_Door;
import Graphics.Objects.Obj_Gate;
import Graphics.TileScaler;
public class Obj_Placement {
    Game game;
    public Obj_Placement(Game g)
    {
        game=g;
    }
    public void setObjects()
    {
        game.obj_list[0]=new Obj_Door(game);
        game.obj_list[0].image=TileScaler.scaleImage(game.obj_list[0].image,game.Tile_Size(),game.Tile_Size());
        game.obj_list[0].worldX=5*game.Tile_Size();
        game.obj_list[0].worldY=5*game.Tile_Size();

        game.obj_list[1]=new Obj_Boots(game);
        game.obj_list[1].image=TileScaler.scaleImage(game.obj_list[1].image,32,32);
        game.obj_list[1].worldX=3*game.Tile_Size();
        game.obj_list[1].worldY=3*game.Tile_Size();

        game.obj_list[2]=new Obj_Gate(game);
        //game.obj_list[2].image=TileScaler.scaleImage(game.obj_list[1].image,32,32);
        game.obj_list[2].worldX=17*game.Tile_Size();
        game.obj_list[2].worldY=17*game.Tile_Size();

    }
}
