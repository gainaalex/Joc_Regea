package Regea_The_Game_v1;

import Graphics.Objects.Obj_Door;

public class Obj_Placement {
    Game game;
    public Obj_Placement(Game g)
    {
        game=g;
    }
    public void setObjects()
    {
        game.obj_list[0]=new Obj_Door();
        game.obj_list[0].worldX=23*game.Tile_Size();
        game.obj_list[0].worldY=20*game.Tile_Size();

    }
}
