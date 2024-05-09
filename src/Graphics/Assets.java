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
    public int  map_matrix[][];

    public Assets(Game game)
    {
        this.game=game;
        tile=new Tile[101];
        GetTiles();
        LoadMap("/Graphics/Maps/World_Final_v2.txt");
    }
    public void LoadMap(String path)
    {
        map_matrix=new int[game.wnd.maxWorldRow][game.wnd.maxWorldCol];
        try{
            InputStream input=getClass().getResourceAsStream(path);
            BufferedReader br=new BufferedReader(new InputStreamReader(input));

            int col=0,row=0;
            while(col<game.wnd.maxWorldCol && row<game.wnd.maxWorldRow)
            {
                String line= br.readLine();
                while(col<game.wnd.maxWorldCol) {
                    String[] num = line.split(" ");
                    int n = Integer.parseInt(num[col]);
                    map_matrix[row][col]=n;
                    col++;
                }
                if (col== game.wnd.maxWorldCol)
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

        //wall
        setup(50,"/res/Castle/wall/wall_0.png",true);
        setup(51,"/res/Castle/wall/wall_1.png",true);
        setup(52,"/res/Castle/wall/wall_2.png",true);
        setup(53,"/res/Castle/wall/wall_3.png",true);
        setup(54,"/res/Castle/floor/floor/good tiles/tile136.png",false);


    }
    public void Draw(Graphics g)
    {
        //g.drawImage(grass[0].image,0,0,game.Tile_Size(),game.Tile_Size(),null);
        int WorldCol=0,WorldRow=0;
        while(WorldCol< game.wnd.maxWorldCol && WorldRow<game.wnd.maxWorldRow)
        {
            int current_tile=map_matrix[WorldRow][WorldCol];

            int WorldX=WorldCol* game.Tile_Size();
            int WorldY=WorldRow* game.Tile_Size();

            int screenX=WorldX-game.player1.WorldX+game.player1.screenX;
            int screenY=WorldY-game.player1.WorldY+game.player1.screenY;
            if (WorldX + game.Tile_Size()>game.player1.WorldX-game.player1.screenX &&
                WorldX- game.Tile_Size()<game.player1.WorldX+game.player1.screenX &&
                WorldY+ game.Tile_Size()>game.player1.WorldY-game.player1.screenY &&
                WorldY- game.Tile_Size()<game.player1.WorldY+game.player1.screenY &&
                tile[current_tile]!=null)
            {
                g.drawImage(tile[current_tile].image,screenX,screenY, null);
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
