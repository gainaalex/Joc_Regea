package Regea_The_Game_v1;

import Graphics.Objects.*;
import Graphics.TileScaler;

import java.awt.*;

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
        game.obj_list[0].worldX=21*game.Tile_Size();
        game.obj_list[0].worldY=14*game.Tile_Size();

        game.obj_list[1]=new Obj_Boots(game);
        game.obj_list[1].image=TileScaler.scaleImage(game.obj_list[1].image,32,32);
        game.obj_list[1].worldX=3*game.Tile_Size();
        game.obj_list[1].worldY=1*game.Tile_Size();

        game.obj_list[4]=new Obj_Gate(game);
        game.obj_list[4].worldX=17*game.Tile_Size();
        game.obj_list[4].worldY=17*game.Tile_Size()+16;

        game.obj_list[5]=new Obj_BigTree(game);
        game.obj_list[5].solidArea_defaultY=3*game.Tile_Size()+16;
        game.obj_list[5].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[5].solidArea.width=3*game.Tile_Size();
        game.obj_list[5].solidArea.height=2*game.Tile_Size();
        game.obj_list[5].image=TileScaler.scaleImage(game.obj_list[5].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[5].worldX=11*game.Tile_Size();
        game.obj_list[5].worldY=15*game.Tile_Size();

        game.obj_list[2]=new Obj_BigTree(game);
        game.obj_list[2].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[2].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[2].solidArea.width=3*game.Tile_Size();
        game.obj_list[2].solidArea.height=2*game.Tile_Size();
        game.obj_list[2].image=TileScaler.scaleImage(game.obj_list[2].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[2].worldX=14*game.Tile_Size();
        game.obj_list[2].worldY=15*game.Tile_Size();


        game.obj_list[3]=new Obj_BigTree(game);
        game.obj_list[3].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[3].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[3].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[3].solidArea.height=2*game.Tile_Size();
        game.obj_list[3].image=TileScaler.scaleImage(game.obj_list[3].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[3].worldX=22*game.Tile_Size();
        game.obj_list[3].worldY=15*game.Tile_Size();

        game.obj_list[6]=new Obj_BigTree(game);
        game.obj_list[6].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[6].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[6].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[6].solidArea.height=2*game.Tile_Size();
        game.obj_list[6].image=TileScaler.scaleImage(game.obj_list[6].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[6].worldX=26*game.Tile_Size();
        game.obj_list[6].worldY=15*game.Tile_Size();

        game.obj_list[7]=new Obj_BigTree(game);
        game.obj_list[7].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[7].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[7].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[7].solidArea.height=2*game.Tile_Size();
        game.obj_list[7].image=TileScaler.scaleImage(game.obj_list[7].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[7].worldX=30*game.Tile_Size();
        game.obj_list[7].worldY=15*game.Tile_Size();

        game.obj_list[8]=new Obj_BigTree(game);
        game.obj_list[8].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[8].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[8].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[8].solidArea.height=2*game.Tile_Size();
        game.obj_list[8].image=TileScaler.scaleImage(game.obj_list[8].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[8].worldX=34*game.Tile_Size();
        game.obj_list[8].worldY=15*game.Tile_Size();

        game.obj_list[9]=new Obj_Casa_Spate(game);
        game.obj_list[9].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[9].solidArea_defaultX=0;
        game.obj_list[9].solidArea.width=6*game.Tile_Size();
        game.obj_list[9].solidArea.height=2*game.Tile_Size();
        game.obj_list[9].image=TileScaler.scaleImage(game.obj_list[9].image,6*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[9].worldX=40*game.Tile_Size();
        game.obj_list[9].worldY=17*game.Tile_Size();

        game.obj_list[11]=new Obj_BigTree(game);
        game.obj_list[11].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[11].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[11].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[11].solidArea.height=2*game.Tile_Size();
        game.obj_list[11].image=TileScaler.scaleImage(game.obj_list[11].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[11].worldX=36*game.Tile_Size()+16;
        game.obj_list[11].worldY=17*game.Tile_Size();

        game.obj_list[10]=new Obj_BigTree(game);
        game.obj_list[10].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[10].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[10].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[10].solidArea.height=2*game.Tile_Size();
        game.obj_list[10].image=TileScaler.scaleImage(game.obj_list[10].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[10].worldX=45*game.Tile_Size();
        game.obj_list[10].worldY=13*game.Tile_Size();

        game.obj_list[12]=new Obj_BigTree(game);
        game.obj_list[12].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[12].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[12].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[12].solidArea.height=2*game.Tile_Size();
        game.obj_list[12].image=TileScaler.scaleImage(game.obj_list[12].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[12].worldX=45*game.Tile_Size();
        game.obj_list[12].worldY=25*game.Tile_Size();

        game.obj_list[13]=new Obj_BigTree(game);
        game.obj_list[13].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[13].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[13].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[13].solidArea.height=2*game.Tile_Size();
        game.obj_list[13].image=TileScaler.scaleImage(game.obj_list[13].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[13].worldX=40*game.Tile_Size();
        game.obj_list[13].worldY=22*game.Tile_Size();

        game.obj_list[14]=new Obj_BigTree(game);
        game.obj_list[14].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[14].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[14].solidArea.width=3*game.Tile_Size()+25;
        game.obj_list[14].solidArea.height=2*game.Tile_Size();
        game.obj_list[14].image=TileScaler.scaleImage(game.obj_list[14].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[14].worldX=45*game.Tile_Size();
        game.obj_list[14].worldY=17*game.Tile_Size();

        game.obj_list[20]=new Obj_Fountain(game);
        game.obj_list[20].solidArea.width=2*game.Tile_Size();
        game.obj_list[20].solidArea.height=2*game.Tile_Size();
        game.obj_list[20].scaleImages(2*game.Tile_Size(),2*game.Tile_Size());
        game.obj_list[20].worldX=40*game.Tile_Size();
        game.obj_list[20].worldY=12*game.Tile_Size();
    }
}
