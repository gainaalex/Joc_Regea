package Graphics;

import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Assets
{
    Game game;
    public Tile[] tile;


    public int  map_matrix[][];

    public Assets(Game game)
    {
        this.game=game;
        tile=new Tile[15];
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
    public void GetTiles()
    {
        try{
            tile[0]=new Tile();
            //tile[0].collision=true;
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_0.png"));
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_1.png"));
            tile[2]=new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_2.png"));
            tile[3]=new Tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_3.png"));
            tile[4]=new Tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_4.png"));
            tile[5]=new Tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_5.png"));
            tile[6]=new Tile();
            tile[6].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_6.png"));
            tile[7]=new Tile();
            tile[7].image= ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Grass/grass_tile_7.png"));
            //piatra
            tile[8]=new Tile();
            tile[8].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Stone/Ground&Stone/Stone/ground1.png"));
            //copac
            tile[9]=new Tile();
            tile[9].image=ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree/tree.png"));
            tile[9].collision=true;
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
                WorldY- game.Tile_Size()<game.player1.WorldY+game.player1.screenY )
            {
                g.drawImage(tile[current_tile].image,screenX,screenY,game.Tile_Size(),game.Tile_Size(),null);
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
