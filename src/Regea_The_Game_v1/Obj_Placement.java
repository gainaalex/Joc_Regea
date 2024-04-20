package Regea_The_Game_v1;

import Graphics.Objects.Obj_Boots;
import Graphics.Objects.Obj_Door;
import Graphics.TileScaler;
public class Obj_Placement {
    Game game;
    public Obj_Placement(Game g)
    {
        game=g;
    }
    public void setObjects()
    {
        game.obj_list[0]=new Obj_Door();
        game.obj_list[0].image=TileScaler.scaleImage(game.obj_list[0].image,game.Tile_Size(),game.Tile_Size());
        game.obj_list[0].worldX=23*game.Tile_Size();
        game.obj_list[0].worldY=20*game.Tile_Size();

        game.obj_list[1]=new Obj_Boots();
        //game.obj_list[1].image=TileScaler.scaleImage(game.obj_list[1].image,game.Tile_Size(),game.Tile_Size());
        game.obj_list[1].worldX=23*game.Tile_Size();
        game.obj_list[1].worldY=27*game.Tile_Size();

    }
}
