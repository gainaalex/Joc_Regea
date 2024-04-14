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
        tile=new Tile[50];
        GetTiles();
        LoadMap("/Graphics/Maps/World_1.txt");
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
            tile[index].image=TileScaler.scaleImage(tile[index].image, game.Tile_Size(), game.Tile_Size());
            tile[index].collision=collision;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void GetTiles()
    {
        /*//iarba
        setup(0,"/res/Tiles/Grass/grass_tile_0.png",false);
        setup(1,"/res/Tiles/Grass/grass_tile_1.png",false);
        setup(2,"/res/Tiles/Grass/grass_tile_2.png",false);
        setup(3,"/res/Tiles/Grass/grass_tile_3.png",false);
        setup(4,"/res/Tiles/Grass/grass_tile_4.png",false);
        setup(5,"/res/Tiles/Grass/grass_tile_5.png",false);
        setup(6,"/res/Tiles/Grass/grass_tile_6.png",false);
        setup(7,"/res/Tiles/Grass/grass_tile_7.png",false);
        //piatra
        setup(8,"/res/Tiles/Stone/Ground&Stone/Stone/ground1.png",false);
        //copac
        setup(9,"/res/Tiles/Tree/up_tree_final.png",true);*/

        try{
            tile[10]=new Tile();
            tile[10].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_0.png"));

            tile[11]=new Tile();
            tile[11].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_1.png"));
            tile[12]=new Tile();
            tile[12].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_2.png"));
            tile[13]=new Tile();
            tile[13].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_3.png"));
            tile[14]=new Tile();
            tile[14].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_4.png"));
            tile[15]=new Tile();
            tile[15].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_5.png"));
            tile[16]=new Tile();
            tile[16].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_6.png"));
            tile[17]=new Tile();
            tile[17].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_7.png"));
            tile[18]=new Tile();
            tile[18].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_8.png"));
            //cobblestone
            tile[19]=new Tile();
            tile[19].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Stone/Ground&Stone/Stone/cobble.png"));
            //tree
            tile[20]=new Tile();
            tile[20].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/front_tree_final.png"));
            tile[20].collision=true;

            tile[21]=new Tile();
            tile[21].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/central_tree_final.png"));
            tile[21].collision=true;

            tile[22]=new Tile();
            tile[22].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/left_tree_final.png"));
            tile[22].collision=true;

            tile[23]=new Tile();
            tile[23].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/right_tree_final.png"));
            tile[23].collision=true;

            tile[30]=new Tile();
            tile[30].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Stone/Ground&Stone/Stone/ground1.png"));
            tile[30].collision=true;

            tile[31]=new Tile();
            tile[31].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Wood/wood_floor.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }

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
                g.drawImage(tile[current_tile].image,screenX,screenY,game.Tile_Size(), game.Tile_Size(), null);
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
