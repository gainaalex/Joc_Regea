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
        game.obj_list[1].worldX=40*game.Tile_Size();
        game.obj_list[1].worldY=15*game.Tile_Size();

        game.obj_list[4]=new Obj_Gate(game);
        game.obj_list[4].worldX=17*game.Tile_Size();
        game.obj_list[4].worldY=17*game.Tile_Size()+16;

        game.obj_list[5]=new Obj_BigTree(game);
        game.obj_list[5].solidArea_defaultY=3*game.Tile_Size()+16;
        game.obj_list[5].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[5].solidArea.width=3*game.Tile_Size();
        game.obj_list[5].solidArea.height=game.Tile_Size();
        game.obj_list[5].image=TileScaler.scaleImage(game.obj_list[5].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[5].worldX=11*game.Tile_Size();
        game.obj_list[5].worldY=15*game.Tile_Size();

        game.obj_list[2]=new Obj_BigTree(game);
        game.obj_list[2].image=TileScaler.scaleImage(game.obj_list[2].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[2].worldX=14*game.Tile_Size();
        game.obj_list[2].worldY=15*game.Tile_Size();


        game.obj_list[3]=new Obj_BigTree(game);
        game.obj_list[3].image=TileScaler.scaleImage(game.obj_list[3].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[3].worldX=22*game.Tile_Size();
        game.obj_list[3].worldY=15*game.Tile_Size();

        game.obj_list[6]=new Obj_BigTree(game);
        game.obj_list[6].image=TileScaler.scaleImage(game.obj_list[6].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[6].worldX=26*game.Tile_Size();
        game.obj_list[6].worldY=15*game.Tile_Size();

        game.obj_list[7]=new Obj_BigTree(game);
        game.obj_list[7].image=TileScaler.scaleImage(game.obj_list[7].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[7].worldX=30*game.Tile_Size();
        game.obj_list[7].worldY=15*game.Tile_Size();

        game.obj_list[8]=new Obj_BigTree(game);
        game.obj_list[8].image=TileScaler.scaleImage(game.obj_list[8].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[8].worldX=34*game.Tile_Size();
        game.obj_list[8].worldY=15*game.Tile_Size();


        game.obj_list[11]=new Obj_BigTree(game);
        game.obj_list[11].image=TileScaler.scaleImage(game.obj_list[11].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[11].worldX=36*game.Tile_Size()+16;
        game.obj_list[11].worldY=17*game.Tile_Size();

        game.obj_list[12]=new Obj_BigTree(game);//outside
        game.obj_list[12].image=TileScaler.scaleImage(game.obj_list[12].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[12].worldX=45*game.Tile_Size();
        game.obj_list[12].worldY=25*game.Tile_Size();

        game.obj_list[13]=new Obj_BigTree(game);//outside
        game.obj_list[13].image=TileScaler.scaleImage(game.obj_list[13].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[13].worldX=40*game.Tile_Size();
        game.obj_list[13].worldY=22*game.Tile_Size();

        game.obj_list[10]=new Obj_BigTree(game);
        game.obj_list[10].image=TileScaler.scaleImage(game.obj_list[10].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[10].worldX=45*game.Tile_Size();
        game.obj_list[10].worldY=5*game.Tile_Size();//5

        game.obj_list[14]=new Obj_BigTree(game);
        game.obj_list[14].image=TileScaler.scaleImage(game.obj_list[14].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[14].worldX=45*game.Tile_Size();
        game.obj_list[14].worldY=9*game.Tile_Size();//9


        game.obj_list[15]=new Obj_BigTree(game);
        game.obj_list[15].image=TileScaler.scaleImage(game.obj_list[15].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[15].worldX=45*game.Tile_Size();
        game.obj_list[15].worldY=13*game.Tile_Size();//13

        game.obj_list[16]=new Obj_BigTree(game);
        game.obj_list[16].image=TileScaler.scaleImage(game.obj_list[16].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[16].worldX=45*game.Tile_Size();
        game.obj_list[16].worldY=17*game.Tile_Size();//17

        game.obj_list[17]=new Obj_BigTree(game);
        game.obj_list[17].image=TileScaler.scaleImage(game.obj_list[17].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[17].worldX=42*game.Tile_Size();
        game.obj_list[17].worldY=5*game.Tile_Size();

        game.obj_list[18]=new Obj_BigTree(game);
        game.obj_list[18].image=TileScaler.scaleImage(game.obj_list[18].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[18].worldX=38*game.Tile_Size();
        game.obj_list[18].worldY=5*game.Tile_Size();

        game.obj_list[19]=new Obj_BigTree(game);
        game.obj_list[19].image=TileScaler.scaleImage(game.obj_list[19].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[19].worldX=35*game.Tile_Size();
        game.obj_list[19].worldY=5*game.Tile_Size();


        game.obj_list[22]=new Obj_BigTree(game);
        game.obj_list[22].image=TileScaler.scaleImage(game.obj_list[22].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[22].worldX=32*game.Tile_Size();
        game.obj_list[22].worldY=5*game.Tile_Size();


        game.obj_list[24]=new Obj_BigTree(game);
        game.obj_list[24].image=TileScaler.scaleImage(game.obj_list[24].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[24].worldX=25*game.Tile_Size();
        game.obj_list[24].worldY=5*game.Tile_Size();

        game.obj_list[25]=new Obj_Tree(game,0);
        game.obj_list[25].solidArea_defaultY=game.Tile_Size()+32;
        game.obj_list[25].solidArea_defaultX=32;
        game.obj_list[25].solidArea.width=32;
        game.obj_list[25].solidArea.height=3*game.Tile_Size()-(game.Tile_Size()+32);
        game.obj_list[25].image=TileScaler.scaleImage(game.obj_list[25].image,2*game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[25].worldX=7*game.Tile_Size();
        game.obj_list[25].worldY=12*game.Tile_Size();

        game.obj_list[26]=new Obj_Tree(game,1);
        game.obj_list[26].solidArea_defaultY=game.Tile_Size()+32;
        game.obj_list[26].solidArea_defaultX=32;
        game.obj_list[26].solidArea.width=32;
        game.obj_list[26].solidArea.height=3*game.Tile_Size()-(game.Tile_Size()+32);
        game.obj_list[26].image=TileScaler.scaleImage(game.obj_list[26].image,2*game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[26].worldX=6*game.Tile_Size();
        game.obj_list[26].worldY=9*game.Tile_Size();

        game.obj_list[27]=new Obj_Tree(game,1);
        game.obj_list[27].solidArea_defaultY=game.Tile_Size()+32;
        game.obj_list[27].solidArea_defaultX=32;
        game.obj_list[27].solidArea.width=32;
        game.obj_list[27].solidArea.height=3*game.Tile_Size()-(game.Tile_Size()+32);
        game.obj_list[27].image=TileScaler.scaleImage(game.obj_list[27].image,2*game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[27].worldX=11*game.Tile_Size();
        game.obj_list[27].worldY=8*game.Tile_Size();

        //tron
        game.obj_list[31]=new Obj_OneTile_Obj(game,0);
        game.obj_list[31].solidArea_defaultY= game.Tile_Size();
        game.obj_list[31].image=TileScaler.scaleImage(game.obj_list[31].image,game.Tile_Size(),2*game.Tile_Size());
        game.obj_list[31].worldX=17*game.Tile_Size();
        game.obj_list[31].worldY=8*game.Tile_Size()+16;
        //stand cu arme melee
        game.obj_list[32]=new Obj_OneTile_Obj(game,1);
        game.obj_list[32].solidArea.width= 2*game.Tile_Size();
        game.obj_list[32].image=TileScaler.scaleImage(game.obj_list[32].image,2*game.Tile_Size(),game.Tile_Size());
        game.obj_list[32].worldX=14*game.Tile_Size();
        game.obj_list[32].worldY=9*game.Tile_Size();
        //stand cu arcuri
        game.obj_list[33]=new Obj_OneTile_Obj(game,4);
        game.obj_list[33].solidArea.width=game.Tile_Size()-16;
        game.obj_list[33].image=TileScaler.scaleImage(game.obj_list[33].image,game.Tile_Size()-16,game.Tile_Size());
        game.obj_list[33].worldX=19*game.Tile_Size()+16;
        game.obj_list[33].worldY=9*game.Tile_Size();
        //masa
        game.obj_list[34]=new Obj_OneTile_Obj(game,2);
        game.obj_list[34].solidArea.height= 3*game.Tile_Size();
        game.obj_list[34].image=TileScaler.scaleImage(game.obj_list[34].image,game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[34].worldX=22*game.Tile_Size();
        game.obj_list[34].worldY=9*game.Tile_Size();
        //mormant
        game.obj_list[35]=new Obj_OneTile_Obj(game,3);
        game.obj_list[35].solidArea.height= 2*game.Tile_Size()+16;
        game.obj_list[35].solidArea.width= 2*game.Tile_Size();
        game.obj_list[35].image=TileScaler.scaleImage(game.obj_list[35].image,2*game.Tile_Size(),2*game.Tile_Size());
        game.obj_list[35].worldX=30*game.Tile_Size();
        game.obj_list[35].worldY=7*game.Tile_Size()+16;




        game.obj_list[30]=new Obj_Fountain(game,0);
        game.obj_list[30].solidArea_defaultY= game.Tile_Size();
        game.obj_list[30].solidArea.width=2*game.Tile_Size();
        game.obj_list[30].solidArea.height=game.Tile_Size()+4;
        game.obj_list[30].scaleImages(2*game.Tile_Size(),2*game.Tile_Size());
        game.obj_list[30].worldX=40*game.Tile_Size();
        game.obj_list[30].worldY=12*game.Tile_Size();

        //case
        game.obj_list[9]=new Obj_Casa(game,0);
        game.obj_list[9].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[9].solidArea_defaultX=0;
        game.obj_list[9].solidArea.width=6*game.Tile_Size();
        game.obj_list[9].solidArea.height=2*game.Tile_Size();
        game.obj_list[9].image=TileScaler.scaleImage(game.obj_list[9].image,6*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[9].worldX=40*game.Tile_Size();
        game.obj_list[9].worldY=17*game.Tile_Size();

        game.obj_list[40]=new Obj_Casa(game,1);
        game.obj_list[40].solidArea_defaultY= game.Tile_Size();
        game.obj_list[40].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[40].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[40].image=TileScaler.scaleImage(game.obj_list[40].image,7*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[40].worldX=25*game.Tile_Size();
        game.obj_list[40].worldY=31*game.Tile_Size();

        game.obj_list[41]=new Obj_Casa(game,2);
        game.obj_list[41].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[41].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[41].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[41].image=TileScaler.scaleImage(game.obj_list[41].image,7*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[41].worldX=27*game.Tile_Size();
        game.obj_list[41].worldY=41*game.Tile_Size();

        game.obj_list[42]=new Obj_Casa(game,3);
        game.obj_list[42].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[42].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[42].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[42].image=TileScaler.scaleImage(game.obj_list[42].image,7*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[42].worldX=10*game.Tile_Size();
        game.obj_list[42].worldY=27*game.Tile_Size();

        game.obj_list[43]=new Obj_Casa(game,4);
        game.obj_list[43].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[43].solidArea.width=5*game.Tile_Size()-4;
        game.obj_list[43].solidArea.height=5*game.Tile_Size()+12;
        game.obj_list[43].image=TileScaler.scaleImage(game.obj_list[43].image,5*game.Tile_Size(),7*game.Tile_Size());
        game.obj_list[43].worldX=38*game.Tile_Size();
        game.obj_list[43].worldY=33*game.Tile_Size();

        game.obj_list[44]=new Obj_Casa(game,5);
        game.obj_list[44].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[44].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[44].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[44].image=TileScaler.scaleImage(game.obj_list[44].image,7*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[44].worldX=11*game.Tile_Size();
        game.obj_list[44].worldY=40*game.Tile_Size();


    }
}
