package Graphics;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static Graphics.TileScaler.scaleImage;


public class Assets
{
    Game game;
    public Tile[] tile;
    public BufferedImage[] o_images;
    public BufferedImage[][] background_images;
    public int[][][] map_matrix;

    //for animated tiles
    protected static int animation_Counter=0;
    public int freq_def=0;
    public boolean isUpdated=false;

    public Assets(Game game)
    {
        this.game=game;
        map_matrix=new int[game.wnd.maxMaps][][];
        o_images=new BufferedImage[5];
        background_images=new BufferedImage[4][];
        tile=new Tile[101];
        GetTiles();
        LoadMap("/Graphics/Maps/World_Final_v2.txt",0,game.wnd.maxWorldRow,game.wnd.maxWorldCol);
        LoadMap("/Graphics/Maps/fight1_map.txt",1,15,21);
        LoadMap("/Graphics/Maps/fight2_map.txt",2,15,21);
        LoadMap("/Graphics/Maps/fight3_map.txt",3,15,21);
        try{
            o_images[0]= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/big tree/copac_2.png"));
            o_images[0]=TileScaler.scaleImage(o_images[0],2*game.Tile_Size(),3*game.Tile_Size());
            o_images[1]=ImageIO.read(getClass().getResourceAsStream("/res/Ferma/wheat_obj.png"));
            o_images[1]=TileScaler.scaleImage(o_images[1],game.Tile_Size()+16,game.Tile_Size()+8);
            background_images[1]=new BufferedImage[1];
            background_images[2]=new BufferedImage[1];
            background_images[3]=new BufferedImage[1];
            background_images[1][0]=ImageIO.read(getClass().getResourceAsStream("/res/Fights_resource/fight1/idei/idee 5/final.png"));
            background_images[1][0]=TileScaler.scaleImage(background_images[1][0],game.wnd.GetWndWidth(),game.wnd.GetWndHeight());
            background_images[2][0]=ImageIO.read(getClass().getResourceAsStream("/res/Fights_resource/fight2/idee 1/idee1.png"));
            background_images[2][0]=TileScaler.scaleImage(background_images[2][0],game.wnd.GetWndWidth(), game.GetWndHeight());
            background_images[3][0]=ImageIO.read(getClass().getResourceAsStream("/res/Fights_resource/fight3/idee 2/idee 2.png"));
            background_images[3][0]=TileScaler.scaleImage(background_images[3][0],game.wnd.GetWndWidth(),game.wnd.GetWndHeight()-4* game.Tile_Size());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void LoadMap(String path, int current_map,int maxrow, int maxcol)
    {
        map_matrix[current_map]=new int[maxrow][maxcol];
        try{
            InputStream input=getClass().getResourceAsStream(path);
            BufferedReader br=new BufferedReader(new InputStreamReader(input));

            int col=0,row=0;
            while(col<maxcol && row<maxrow)
            {
                String line= br.readLine();
                while(col<maxcol) {
                    String[] num = line.split(" ");
                    int n = Integer.parseInt(num[col]);
                    map_matrix[current_map][row][col]=n;
                    col++;
                }
                if (col== maxcol)
                {
                    col=0;
                    row++;
                }
            }
            br.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setup(int index, String imagePath, boolean collision)
    {
        try{
            tile[index]=new Tile();
            tile[index].image=ImageIO.read(getClass().getResourceAsStream(imagePath));
            if(tile[index].image.getWidth()!= game.Tile_Size() && tile[index].image.getHeight()!= game.Tile_Size())
                    tile[index].image=TileScaler.scaleImage(tile[index].image, game.Tile_Size(), game.Tile_Size());
            tile[index].collision=collision;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void GetTiles()
    {
        // grass
        setup(10,"/res/Tiles/Grass/grass_tile_0.png",false);
        setup(11,"/res/Tiles/Grass/grass_tile_1.png",false);
        setup(12,"/res/Tiles/Grass/grass_tile_2.png",false);
        setup(13,"/res/Tiles/Grass/grass_tile_3.png",false);
        setup(14,"/res/Tiles/Grass/grass_tile_4.png",false);
        setup(15,"/res/Tiles/Grass/grass_tile_5.png",false);
        setup(16,"/res/Tiles/Grass/grass_tile_6.png",false);
        setup(17,"/res/Tiles/Grass/grass_tile_7.png",false);
        setup(18,"/res/Tiles/Grass/grass_tile_8.png",false);
        setup(25,"/res/Tiles/Grass/grass_tile_9.png",true);
        setup(26,"/res/Tiles/Grass/grass_tile_10.png",true);


        //cobblestone
        setup(19,"/res/Tiles/Stone/Ground&Stone/Stone/cobble.png",false);
        //tree
        setup(20,"/res/Tiles/Tree/front_tree_final.png",true);
        setup(21,"/res/Tiles/Tree/central_tree_final.png",true);
        setup(22,"/res/Tiles/Tree/left_tree_final.png",true);
        setup(23,"/res/Tiles/Tree/right_tree_final.png",true);
        setup(24,"/res/Tiles/Tree/single_tree.png",true);

        setup(30,"/res/Tiles/Stone/Ground&Stone/Stone/ground1.png",true);
        setup(31,"/res/Tiles/Wood/wood_floor.png",false);

        // river
        setup(40,"/res/Tiles/River/river_lavale.png",true);
        setup(41,"/res/Tiles/River/up.png",true);
        setup(42,"/res/Tiles/River/right.png",true);
        setup(43,"/res/Tiles/River/down.png",true);
        setup(44,"/res/Tiles/River/left.png",true);
        setup(45,"/res/Tiles/River/river_up_left.png",true);
        setup(46,"/res/Tiles/River/river_up_right.png",true);
        setup(47,"/res/Tiles/River/river_down_left.png",true);
        setup(48,"/res/Tiles/River/river_down_right.png",true);

        //podea
        setup(49,"/res/Castle/floor/floor/good tiles/tile176.png",false);

        //wall
        setup(50,"/res/Castle/wall/wall_0.png",true);
        setup(51,"/res/Castle/wall/wall_1.png",true);
        setup(52,"/res/Castle/wall/wall_2.png",true);
        setup(53,"/res/Castle/wall/wall_3.png",true);
        setup(54,"/res/Castle/floor/floor/good tiles/tile136.png",false);

        //flori+gard
        setup(62,"/res/Flori/tile007.png",false);
        setup(63,"/res/Flori/tile014.png",false);
        setup(64,"/res/Flori/tile015.png",false);
        setup(65,"/res/Flori/tile017.png",false);
        setup(66,"/res/Flori/tile018.png",false);

        //garduri

        //animale
        setup(60,"/res/Tiles/Gard de adaugat/Animale/gard_final/gard_orizontal.png",true);
        setup(61,"/res/Tiles/Gard de adaugat/Animale/gard_final/gard_vertical.png",true);
        //grau
        setup(70,"/res/Tiles/Gard de adaugat/Grau/gard_final/gard_orizontal.png",true);
        setup(71,"/res/Tiles/Gard de adaugat/Grau/gard_final/gard_vertical.png",true);
        //sateni
        setup(72,"/res/Tiles/Gard de adaugat/Sateni/gard_final/gard_orizontal.png",true);
        setup(73,"/res/Tiles/Gard de adaugat/Sateni/gard_final/gard_vertical.png",true);

        //grau
        setup(80,"/res/Tiles/Dirt.png",true);

    }

    public void Update()
    {
        if(freq_def==15)
        {
            freq_def=0;
            if(animation_Counter==120)
            {
                animation_Counter=0;
            }
            else
                animation_Counter++;
            isUpdated=true;
        }
        else
            freq_def++;
    }

    public void setAnimation()
    {

    }

    public void Draw(Graphics g)
    {
        int WorldCol=0,WorldRow=0;
        while(WorldCol< game.wnd.maxWorldCol && WorldRow<game.wnd.maxWorldRow)
        {
            int current_tile=map_matrix[game.wnd.currentMap][WorldRow][WorldCol];

            int WorldX=WorldCol* game.Tile_Size();
            int WorldY=WorldRow* game.Tile_Size();

            int screenX=WorldX-game.player1.WorldX+game.player1.screenX;
            int screenY=WorldY-game.player1.WorldY+game.player1.screenY;
            if (WorldX + 2*game.Tile_Size()>game.player1.WorldX-game.player1.screenX &&
                WorldX- 2*game.Tile_Size()<game.player1.WorldX+game.player1.screenX &&
                WorldY+ 4*game.Tile_Size()>game.player1.WorldY-game.player1.screenY &&
                WorldY- 4*game.Tile_Size()<game.player1.WorldY+game.player1.screenY &&
                tile[current_tile]!=null)
            {
                g.drawImage(tile[current_tile].image,screenX,screenY, null);

                g.drawString(""+WorldCol+" "+(WorldRow-1),screenX,screenY);
            }
            WorldCol++;
            if (WorldCol== game.wnd.maxWorldCol)
            {
                WorldCol=0;
                WorldRow++;
            }
        }
    }

    public void Draw_In_Fights(Graphics g)
    {
        g.drawImage(background_images[game.wnd.currentMap][0],0,0,null);
        int WorldCol=0,WorldRow=0;
        while(WorldCol< map_matrix[game.wnd.currentMap][0].length && WorldRow<map_matrix[game.wnd.currentMap].length)
        {
            int current_tile=map_matrix[game.wnd.currentMap][WorldRow][WorldCol];
            int WorldX=WorldCol* game.Tile_Size();
            int WorldY=WorldRow* game.Tile_Size();
            if(tile[current_tile].collision)
                g.drawImage(tile[current_tile].image,WorldX,WorldY, null);

                //g.drawString(""+WorldCol+" "+(WorldRow-1),screenX,screenY);
            WorldCol++;
            if (WorldCol== map_matrix[game.wnd.currentMap][0].length)
            {
                WorldCol=0;
                WorldRow++;
            }
        }
    }

    public void Draw_Over_player(Graphics g)
    {
        int WorldCol=0,WorldRow=0;
        while(WorldCol< game.wnd.maxWorldCol && WorldRow<game.wnd.maxWorldRow)
        {
            int current_tile=map_matrix[game.wnd.currentMap][WorldRow][WorldCol];

            int WorldX=WorldCol* game.Tile_Size();
            int WorldY=WorldRow* game.Tile_Size();

            int screenX=WorldX-game.player1.WorldX+game.player1.screenX;
            int screenY=WorldY-game.player1.WorldY+game.player1.screenY;
            if (WorldX + 2*game.Tile_Size()>game.player1.WorldX-game.player1.screenX &&
                    WorldX- 2*game.Tile_Size()<game.player1.WorldX+game.player1.screenX &&
                    WorldY+ 4*game.Tile_Size()>game.player1.WorldY-game.player1.screenY &&
                    WorldY- 4*game.Tile_Size()<game.player1.WorldY+game.player1.screenY &&
                    tile[current_tile]!=null)
            {
                if(current_tile>=20 && current_tile<=24 && (WorldCol+WorldRow)%3==0)
                    g.drawImage(o_images[0],screenX,screenY-2* game.Tile_Size(),null);
                if(current_tile==80)
                    g.drawImage(o_images[1],screenX,screenY-12,null);
            }
            WorldCol++;
            if (WorldCol== game.wnd.maxWorldCol)
            {
                WorldCol=0;
                WorldRow++;
            }
        }
    }
}
