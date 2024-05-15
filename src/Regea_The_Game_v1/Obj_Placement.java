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
        game.obj_list[0][0]=new Obj_Door(game);
        game.obj_list[0][0].image=TileScaler.scaleImage(game.obj_list[0][0].image,game.Tile_Size(),game.Tile_Size());
        game.obj_list[0][0].worldX=21*game.Tile_Size();
        game.obj_list[0][0].worldY=14*game.Tile_Size();

        game.obj_list[0][1]=new Obj_Boots(game);
        game.obj_list[0][1].image=TileScaler.scaleImage(game.obj_list[0][1].image,32,32);
        game.obj_list[0][1].worldX=40*game.Tile_Size();
        game.obj_list[0][1].worldY=15*game.Tile_Size();

        game.obj_list[0][4]=new Obj_Gate(game);
        game.obj_list[0][4].worldX=17*game.Tile_Size();
        game.obj_list[0][4].worldY=17*game.Tile_Size()+16;

        game.obj_list[0][5]=new Obj_BigTree(game);
        game.obj_list[0][5].solidArea_defaultY=3*game.Tile_Size()+16;
        game.obj_list[0][5].solidArea_defaultX=game.Tile_Size()/2;
        game.obj_list[0][5].solidArea.width=3*game.Tile_Size();
        game.obj_list[0][5].solidArea.height=game.Tile_Size();
        game.obj_list[0][5].image=TileScaler.scaleImage(game.obj_list[0][5].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][5].worldX=11*game.Tile_Size();
        game.obj_list[0][5].worldY=15*game.Tile_Size();

        game.obj_list[0][2]=new Obj_BigTree(game);
        game.obj_list[0][2].image=TileScaler.scaleImage(game.obj_list[0][2].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][2].worldX=14*game.Tile_Size();
        game.obj_list[0][2].worldY=15*game.Tile_Size();


        game.obj_list[0][3]=new Obj_BigTree(game);
        game.obj_list[0][3].image=TileScaler.scaleImage(game.obj_list[0][3].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][3].worldX=22*game.Tile_Size();
        game.obj_list[0][3].worldY=15*game.Tile_Size();

        game.obj_list[0][6]=new Obj_BigTree(game);
        game.obj_list[0][6].image=TileScaler.scaleImage(game.obj_list[0][6].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][6].worldX=26*game.Tile_Size();
        game.obj_list[0][6].worldY=15*game.Tile_Size();

        game.obj_list[0][7]=new Obj_BigTree(game);
        game.obj_list[0][7].image=TileScaler.scaleImage(game.obj_list[0][7].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][7].worldX=30*game.Tile_Size();
        game.obj_list[0][7].worldY=15*game.Tile_Size();

        game.obj_list[0][8]=new Obj_BigTree(game);
        game.obj_list[0][8].image=TileScaler.scaleImage(game.obj_list[0][8].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][8].worldX=34*game.Tile_Size();
        game.obj_list[0][8].worldY=15*game.Tile_Size();


        game.obj_list[0][11]=new Obj_BigTree(game);
        game.obj_list[0][11].image=TileScaler.scaleImage(game.obj_list[0][11].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][11].worldX=36*game.Tile_Size()+16;
        game.obj_list[0][11].worldY=17*game.Tile_Size();

        game.obj_list[0][12]=new Obj_BigTree(game);//outside
        game.obj_list[0][12].image=TileScaler.scaleImage(game.obj_list[0][12].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][12].worldX=45*game.Tile_Size();
        game.obj_list[0][12].worldY=25*game.Tile_Size();

        game.obj_list[0][13]=new Obj_BigTree(game);//outside
        game.obj_list[0][13].image=TileScaler.scaleImage(game.obj_list[0][13].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][13].worldX=40*game.Tile_Size();
        game.obj_list[0][13].worldY=22*game.Tile_Size();

        game.obj_list[0][10]=new Obj_BigTree(game);
        game.obj_list[0][10].image=TileScaler.scaleImage(game.obj_list[0][10].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][10].worldX=45*game.Tile_Size();
        game.obj_list[0][10].worldY=5*game.Tile_Size();//5

        game.obj_list[0][14]=new Obj_BigTree(game);
        game.obj_list[0][14].image=TileScaler.scaleImage(game.obj_list[0][14].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][14].worldX=45*game.Tile_Size();
        game.obj_list[0][14].worldY=9*game.Tile_Size();//9


        game.obj_list[0][15]=new Obj_BigTree(game);
        game.obj_list[0][15].image=TileScaler.scaleImage(game.obj_list[0][15].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][15].worldX=45*game.Tile_Size();
        game.obj_list[0][15].worldY=13*game.Tile_Size();//13

        game.obj_list[0][16]=new Obj_BigTree(game);
        game.obj_list[0][16].image=TileScaler.scaleImage(game.obj_list[0][16].image,5*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][16].worldX=45*game.Tile_Size();
        game.obj_list[0][16].worldY=17*game.Tile_Size();//17

        game.obj_list[0][17]=new Obj_BigTree(game);
        game.obj_list[0][17].image=TileScaler.scaleImage(game.obj_list[0][17].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][17].worldX=42*game.Tile_Size();
        game.obj_list[0][17].worldY=5*game.Tile_Size();

        game.obj_list[0][18]=new Obj_BigTree(game);
        game.obj_list[0][18].image=TileScaler.scaleImage(game.obj_list[0][18].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][18].worldX=38*game.Tile_Size();
        game.obj_list[0][18].worldY=5*game.Tile_Size();

        game.obj_list[0][19]=new Obj_BigTree(game);
        game.obj_list[0][19].image=TileScaler.scaleImage(game.obj_list[0][19].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][19].worldX=35*game.Tile_Size();
        game.obj_list[0][19].worldY=5*game.Tile_Size();


        game.obj_list[0][22]=new Obj_BigTree(game);
        game.obj_list[0][22].image=TileScaler.scaleImage(game.obj_list[0][22].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][22].worldX=32*game.Tile_Size();
        game.obj_list[0][22].worldY=5*game.Tile_Size();


        game.obj_list[0][24]=new Obj_BigTree(game);
        game.obj_list[0][24].image=TileScaler.scaleImage(game.obj_list[0][24].image,4*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][24].worldX=25*game.Tile_Size();
        game.obj_list[0][24].worldY=5*game.Tile_Size();

        game.obj_list[0][25]=new Obj_Tree(game,0);
        game.obj_list[0][25].solidArea_defaultY=game.Tile_Size()+32;
        game.obj_list[0][25].solidArea_defaultX=32;
        game.obj_list[0][25].solidArea.width=32;
        game.obj_list[0][25].solidArea.height=3*game.Tile_Size()-(game.Tile_Size()+32);
        game.obj_list[0][25].image=TileScaler.scaleImage(game.obj_list[0][25].image,2*game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[0][25].worldX=7*game.Tile_Size();
        game.obj_list[0][25].worldY=12*game.Tile_Size();

        game.obj_list[0][26]=new Obj_Tree(game,1);
        game.obj_list[0][26].solidArea_defaultY=game.Tile_Size()+32;
        game.obj_list[0][26].solidArea_defaultX=32;
        game.obj_list[0][26].solidArea.width=32;
        game.obj_list[0][26].solidArea.height=3*game.Tile_Size()-(game.Tile_Size()+32);
        game.obj_list[0][26].image=TileScaler.scaleImage(game.obj_list[0][26].image,2*game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[0][26].worldX=6*game.Tile_Size();
        game.obj_list[0][26].worldY=9*game.Tile_Size();

        game.obj_list[0][27]=new Obj_Tree(game,1);
        game.obj_list[0][27].solidArea_defaultY=game.Tile_Size()+32;
        game.obj_list[0][27].solidArea_defaultX=32;
        game.obj_list[0][27].solidArea.width=32;
        game.obj_list[0][27].solidArea.height=3*game.Tile_Size()-(game.Tile_Size()+32);
        game.obj_list[0][27].image=TileScaler.scaleImage(game.obj_list[0][27].image,2*game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[0][27].worldX=11*game.Tile_Size();
        game.obj_list[0][27].worldY=8*game.Tile_Size();

        //tron
        game.obj_list[0][31]=new Obj_OneTile_Obj(game,0);
        game.obj_list[0][31].solidArea_defaultY= game.Tile_Size();
        game.obj_list[0][31].image=TileScaler.scaleImage(game.obj_list[0][31].image,game.Tile_Size(),2*game.Tile_Size());
        game.obj_list[0][31].worldX=17*game.Tile_Size();
        game.obj_list[0][31].worldY=8*game.Tile_Size()+16;
        //stand cu arme melee
        game.obj_list[0][32]=new Obj_OneTile_Obj(game,1);
        game.obj_list[0][32].solidArea.width= 2*game.Tile_Size();
        game.obj_list[0][32].image=TileScaler.scaleImage(game.obj_list[0][32].image,2*game.Tile_Size(),game.Tile_Size());
        game.obj_list[0][32].worldX=14*game.Tile_Size();
        game.obj_list[0][32].worldY=9*game.Tile_Size();
        //stand cu arcuri
        game.obj_list[0][33]=new Obj_OneTile_Obj(game,4);
        game.obj_list[0][33].solidArea.width=game.Tile_Size()-16;
        game.obj_list[0][33].image=TileScaler.scaleImage(game.obj_list[0][33].image,game.Tile_Size()-16,game.Tile_Size());
        game.obj_list[0][33].worldX=19*game.Tile_Size()+16;
        game.obj_list[0][33].worldY=9*game.Tile_Size();
        //masa
        game.obj_list[0][34]=new Obj_OneTile_Obj(game,2);
        game.obj_list[0][34].solidArea.height= 3*game.Tile_Size();
        game.obj_list[0][34].image=TileScaler.scaleImage(game.obj_list[0][34].image,game.Tile_Size(),3*game.Tile_Size());
        game.obj_list[0][34].worldX=22*game.Tile_Size();
        game.obj_list[0][34].worldY=9*game.Tile_Size();
        //mormant
        game.obj_list[0][35]=new Obj_OneTile_Obj(game,3);
        game.obj_list[0][35].solidArea.height= 2*game.Tile_Size()+16;
        game.obj_list[0][35].solidArea.width= 2*game.Tile_Size();
        game.obj_list[0][35].image=TileScaler.scaleImage(game.obj_list[0][35].image,2*game.Tile_Size(),2*game.Tile_Size());
        game.obj_list[0][35].worldX=30*game.Tile_Size();
        game.obj_list[0][35].worldY=7*game.Tile_Size()+16;




        game.obj_list[0][30]=new Obj_Fountain(game,0);
        game.obj_list[0][30].solidArea_defaultY= game.Tile_Size();
        game.obj_list[0][30].solidArea.width=2*game.Tile_Size();
        game.obj_list[0][30].solidArea.height=game.Tile_Size()+4;
        game.obj_list[0][30].scaleImages(2*game.Tile_Size(),2*game.Tile_Size());
        game.obj_list[0][30].worldX=40*game.Tile_Size();
        game.obj_list[0][30].worldY=12*game.Tile_Size();

        //case
        game.obj_list[0][9]=new Obj_Casa(game,0);
        game.obj_list[0][9].solidArea_defaultY=4*game.Tile_Size()+16;
        game.obj_list[0][9].solidArea_defaultX=0;
        game.obj_list[0][9].solidArea.width=6*game.Tile_Size();
        game.obj_list[0][9].solidArea.height=2*game.Tile_Size();
        game.obj_list[0][9].image=TileScaler.scaleImage(game.obj_list[0][9].image,6*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][9].worldX=40*game.Tile_Size();
        game.obj_list[0][9].worldY=17*game.Tile_Size();

        game.obj_list[0][40]=new Obj_Casa(game,1);
        game.obj_list[0][40].solidArea_defaultY= game.Tile_Size();
        game.obj_list[0][40].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[0][40].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[0][40].image=TileScaler.scaleImage(game.obj_list[0][40].image,7*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][40].worldX=25*game.Tile_Size();
        game.obj_list[0][40].worldY=28*game.Tile_Size();

        game.obj_list[0][41]=new Obj_Casa(game,2);
        game.obj_list[0][41].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[0][41].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[0][41].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[0][41].image=TileScaler.scaleImage(game.obj_list[0][41].image,7*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][41].worldX=27*game.Tile_Size();
        game.obj_list[0][41].worldY=41*game.Tile_Size();

        game.obj_list[0][42]=new Obj_Casa(game,3);
        game.obj_list[0][42].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[0][42].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[0][42].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[0][42].image=TileScaler.scaleImage(game.obj_list[0][42].image,7*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][42].worldX=10*game.Tile_Size();
        game.obj_list[0][42].worldY=27*game.Tile_Size();

        game.obj_list[0][43]=new Obj_Casa(game,4);
        game.obj_list[0][43].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[0][43].solidArea.width=5*game.Tile_Size()-4;
        game.obj_list[0][43].solidArea.height=5*game.Tile_Size()+12;
        game.obj_list[0][43].image=TileScaler.scaleImage(game.obj_list[0][43].image,5*game.Tile_Size(),7*game.Tile_Size());
        game.obj_list[0][43].worldX=38*game.Tile_Size();
        game.obj_list[0][43].worldY=33*game.Tile_Size();

        game.obj_list[0][44]=new Obj_Casa(game,5);
        game.obj_list[0][44].solidArea_defaultY= 2*game.Tile_Size();
        game.obj_list[0][44].solidArea.width=7*game.Tile_Size()-4;
        game.obj_list[0][44].solidArea.height=4*game.Tile_Size()+12;
        game.obj_list[0][44].image=TileScaler.scaleImage(game.obj_list[0][44].image,7*game.Tile_Size(),6*game.Tile_Size());
        game.obj_list[0][44].worldX=11*game.Tile_Size();
        game.obj_list[0][44].worldY=40*game.Tile_Size();

        //ferma

        game.obj_list[0][50]=new Obj_SuperFarm(game,0);
        game.obj_list[0][50].solidArea_defaultY= 6*game.Tile_Size();
        game.obj_list[0][50].solidArea.width=9*game.Tile_Size()-4;
        game.obj_list[0][50].solidArea.height=3*game.Tile_Size()+12;
        game.obj_list[0][50].scaleImages(9*game.Tile_Size(),9*game.Tile_Size());
        game.obj_list[0][50].worldX=54*game.Tile_Size();
        game.obj_list[0][50].worldY=41*game.Tile_Size();

        game.obj_list[0][51]=new Obj_SuperFarm(game,1);
        game.obj_list[0][51].solidArea_defaultY= 4*game.Tile_Size();
        game.obj_list[0][51].solidArea.width=7*game.Tile_Size()-16;
        game.obj_list[0][51].solidArea.height=6*game.Tile_Size()+12;
        game.obj_list[0][51].scaleImages(9*game.Tile_Size(),9*game.Tile_Size());
        game.obj_list[0][51].worldX=72*game.Tile_Size();
        game.obj_list[0][51].worldY=34*game.Tile_Size();

        game.obj_list[0][52]=new Obj_SuperFarm(game,2);
        game.obj_list[0][52].solidArea_defaultY= 5*game.Tile_Size();
        game.obj_list[0][52].solidArea.width=8*game.Tile_Size()+16;
        game.obj_list[0][52].solidArea.height=5*game.Tile_Size()+12;
        game.obj_list[0][52].scaleImages(10*game.Tile_Size(),10*game.Tile_Size());
        game.obj_list[0][52].worldX=55*game.Tile_Size();
        game.obj_list[0][52].worldY=25*game.Tile_Size();

        //munte+pestera

        game.obj_list[0][60]=new Obj_OneTile_Obj(game,6);
        game.obj_list[0][60].solidArea_defaultY= 10*game.Tile_Size();
        game.obj_list[0][60].solidArea.width=15*game.Tile_Size();
        game.obj_list[0][60].solidArea.height=2*game.Tile_Size()+12;
        game.obj_list[0][60].image=TileScaler.scaleImage(game.obj_list[0][60].image,20*game.Tile_Size(),15*game.Tile_Size());
        game.obj_list[0][60].worldX=82*game.Tile_Size();
        game.obj_list[0][60].worldY=0;

        //casa vrajitoare
        game.obj_list[0][61]=new Obj_Casa(game,6);
        game.obj_list[0][61].solidArea_defaultY= 2*game.Tile_Size()-16;
        game.obj_list[0][61].solidArea.width=5*game.Tile_Size()-4;
        game.obj_list[0][61].solidArea.height=3*game.Tile_Size()+12;
        game.obj_list[0][61].image=TileScaler.scaleImage(game.obj_list[0][61].image,5*game.Tile_Size(),5*game.Tile_Size());
        game.obj_list[0][61].worldX=65*game.Tile_Size();
        game.obj_list[0][61].worldY=7*game.Tile_Size();

    }
}
