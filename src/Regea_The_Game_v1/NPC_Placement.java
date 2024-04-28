package Regea_The_Game_v1;

import Entity.NPC_Baraka;

public class NPC_Placement {
    Game game;
    public NPC_Placement(Game g)
    {
        this.game=g;
    }
    public void setNPCs()
    {
        game.npc_list[0]=new NPC_Baraka(game);
        game.npc_list[0].WorldX=game.Tile_Size()*25;
        game.npc_list[0].WorldY=game.Tile_Size()*26;
    }
}
