package Regea_The_Game_v1;

import java.awt.*;

public class EventInterpretor {
    Game game;
    EventRect[][] eventRect;
    int prevEvent_X,prevEvent_Y;
    boolean canTriggerEvent=true;
    public EventInterpretor(Game g)
    {
        this.game=g;

        eventRect=new EventRect[game.wnd.maxWorldCol][game.wnd.maxWorldRow];
        int col=0,row=0;
        while(col<game.wnd.maxWorldCol && row<game.wnd.maxWorldRow)
        {
            eventRect[col][row]=new EventRect();
            eventRect[col][row].x=23;
            eventRect[col][row].y=23;
            eventRect[col][row].width=16;
            eventRect[col][row].height=16;
            eventRect[col][row].eventRectDefaultX=eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY=eventRect[col][row].y;
            col++;
            if(col==game.wnd.maxWorldCol)
            {
                row++;
                col=0;
            }
        }


    }

    public void checkEvent()
    {
        //verific daca eventul poate avea loc din nou
        int xDist=Math.abs(game.player1.WorldX-prevEvent_X);
        int yDist=Math.abs(game.player1.WorldY-prevEvent_Y);
        int distance=Math.max(xDist,yDist);
        if(distance>game.Tile_Size())
            canTriggerEvent=true;
        if(canTriggerEvent)
        {
            if(hit(55,47,"any"))
            {
                sout(55,47,1);
            }
        }
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection)
    {
        boolean hit=false;
        game.player1.solidArea.x=game.player1.WorldX+game.player1.solidArea.x;
        game.player1.solidArea.y=game.player1.WorldY+game.player1.solidArea.y;
        eventRect[eventCol][eventRow].x=eventCol*game.Tile_Size()+eventRect[eventCol][eventRow].x;
        eventRect[eventCol][eventRow].y=eventRow*game.Tile_Size()+eventRect[eventCol][eventRow].y;

        if(game.player1.solidArea.intersects(eventRect[eventCol][eventRow]) && eventRect[eventCol][eventRow].eventDone==false)
        {
            if(game.player1.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any"))
            {
                hit=true;

                prevEvent_X=game.player1.WorldX;
                prevEvent_Y=game.player1.WorldY;
            }
        }
        game.player1.solidArea.x=game.player1.solidArea_defaultX;
        game.player1.solidArea.y=game.player1.solidArea_defaultY;
        eventRect[eventCol][eventRow].x=eventRect[eventCol][eventRow].eventRectDefaultX;
        eventRect[eventCol][eventRow].y=eventRect[eventCol][eventRow].eventRectDefaultY;

        return hit;
    }

    public void sout(int col,int row, int gameState)
    {
        //game.gameStatus=gameState;
        System.out.println("eheee");
        //eventRect[col][row].eventDone=true;
        canTriggerEvent=false;
    }

}
