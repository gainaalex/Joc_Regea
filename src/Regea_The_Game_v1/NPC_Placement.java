package Regea_The_Game_v1;

import Entity.NPC_Baraka;
import Entity.NPC_Cow;

public class NPC_Placement {
    Game game;
    public NPC_Placement(Game g)
    {
        this.game=g;
    }
    public void setNPCs()
    {
        game.npc_list[0][0]=new NPC_Baraka(game);
        game.npc_list[0][0].WorldX=game.Tile_Size()*39;
        game.npc_list[0][0].WorldY=game.Tile_Size()*12;

        game.npc_list[0][1]=new NPC_Cow(game);
        game.npc_list[0][1].WorldX=game.Tile_Size()*7;
        game.npc_list[0][1].WorldY=game.Tile_Size()*10;

        game.npc_list[0][2]=new NPC_Cow(game);
        game.npc_list[0][2].WorldX=game.Tile_Size()*7;
        game.npc_list[0][2].WorldY=game.Tile_Size()*13;
    }
}
