package Regea_The_Game_v1;

import Entity.*;

public class NPC_Placement {
    Game game;
    public NPC_Placement(Game g)
    {
        this.game=g;
    }
    public void setNPCs()
    {
        game.npc_list[0][0]=new NPC_Baraka(game);
        //game.npc_list[0][0].currentLife=10;
        game.npc_list[0][0].WorldX=game.Tile_Size()*39;
        game.npc_list[0][0].WorldY=game.Tile_Size()*12;

        game.npc_list[0][1]=new NPC_Cow(game);
        game.npc_list[0][1].WorldX=game.Tile_Size()*7;
        game.npc_list[0][1].WorldY=game.Tile_Size()*10;

        game.npc_list[0][2]=new NPC_Cow(game);
        game.npc_list[0][2].WorldX=game.Tile_Size()*7;
        game.npc_list[0][2].WorldY=game.Tile_Size()*13;

        game.npc_list[0][3]=new NPC_Baraka(game);
        //game.npc_list[0][0].currentLife=10;
        game.npc_list[0][3].WorldX=game.Tile_Size()*67;
        game.npc_list[0][3].WorldY=game.Tile_Size()*51;

        //bosses
        game.bosses[1][0]=new NPC_Baraka_Fight(game);
        game.bosses[1][0].WorldX=15*game.Tile_Size();
        game.bosses[1][0].WorldY=9*game.Tile_Size();

        game.bosses[2][0]=new NPC_Spanciu(game);
        game.bosses[2][0].WorldX=15*game.Tile_Size();
        game.bosses[2][0].WorldY=9*game.Tile_Size();

        game.bosses[3][0]=new NPC_Boloni(game);
        game.bosses[3][0].WorldX=15*game.Tile_Size();
        game.bosses[3][0].WorldY=9*game.Tile_Size();
    }
}
