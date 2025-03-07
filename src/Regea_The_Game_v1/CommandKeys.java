package Regea_The_Game_v1;

import Entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandKeys implements KeyListener {
    Game game;
    public boolean up_command=false,down_command=false,left_command=false,
            right_command=false,jump=false,e_command=false,enter_command=false;

    public CommandKeys(Game g)
    {
        this.game=g;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(game.gameStatus== game.playStatus) {
            if (code == KeyEvent.VK_W) {
                up_command = true;
            }
            if (code == KeyEvent.VK_S) {
                down_command = true;
            }
            if (code == KeyEvent.VK_A) {
                left_command = true;
            }
            if (code == KeyEvent.VK_D) {
                right_command = true;
            }
            if (code == KeyEvent.VK_E) {
                e_command = true;
            }
            if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_P) {
                game.gameStatus = game.pauseStatus;
            }
        }
        else if(game.gameStatus==game.pauseStatus)
        {
            if(game.previousStatus==game.fightStatus)
            {
                if (code == KeyEvent.VK_W || code==KeyEvent.VK_UP) {
                    if(game.ui.commandLine!=0)
                        game.ui.commandLine--;
                    else game.ui.commandLine=2;
                }
                if (code == KeyEvent.VK_S || code==KeyEvent.VK_DOWN) {
                    if(game.ui.commandLine!=2)
                        game.ui.commandLine++;
                    else game.ui.commandLine=0;
                }
                if(code== KeyEvent.VK_ENTER || code== KeyEvent.VK_RIGHT)
                {
                    switch (game.ui.commandLine)
                    {
                        case 0:
                            game.gameStatus= game.fightStatus;
                            break;
                        case 1:
                            game.ui.pauseScreenState=1;
                            break;
                        case 2:
                            game.set3on4Gameplay(game.player1.savedTileX,game.player1.savedTileY,game.player1.lastSavedCurrentLife);
                            game.ui.commandLine=0;
                            break;
                    }
                }
                if(code==KeyEvent.VK_LEFT && game.ui.pauseScreenState==1)
                {
                    game.ui.pauseScreenState=0;
                }
            }
            if(game.previousStatus==game.playStatus)
            {
                if (code == KeyEvent.VK_W || code==KeyEvent.VK_UP) {
                    if(game.ui.commandLine!=0)
                        game.ui.commandLine--;
                    else game.ui.commandLine=2;
                }
                if (code == KeyEvent.VK_S || code==KeyEvent.VK_DOWN) {
                    if(game.ui.commandLine!=2)
                        game.ui.commandLine++;
                    else game.ui.commandLine=0;
                }
                if(code== KeyEvent.VK_ENTER || code== KeyEvent.VK_RIGHT)
                {
                    switch (game.ui.commandLine)
                    {
                        case 0:
                            game.gameStatus= game.playStatus;
                            break;
                        case 1:
                            //fct de save
                            game.dataDeBaza.deleteAllRows();
                            game.dataDeBaza.insert(game.player1.WorldX/game.Tile_Size(),
                                    game.player1.WorldY/game.Tile_Size(),game.player1.currentLife);
                            game.gameStatus=game.playStatus;
                            game.ui.commandLine=0;
                            break;
                        case 2:
                            game.gameStatus=game.titleScreen_Status;
                            game.ui.commandLine=0;
                            break;
                    }
                }
            }
            if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_P) {
                if(game.previousStatus== game.playStatus)
                    game.gameStatus = game.playStatus;
                if(game.previousStatus==game.fightStatus)
                    game.gameStatus= game.fightStatus;
            }

        }
        else if(game.gameStatus==game.titleScreen_Status)
        {
            if (code == KeyEvent.VK_W || code==KeyEvent.VK_UP) {
                if(game.ui.commandLine!=0)
                    game.ui.commandLine--;
                else game.ui.commandLine=3;
            }
            if (code == KeyEvent.VK_S || code==KeyEvent.VK_DOWN) {
                if(game.ui.commandLine!=3)
                    game.ui.commandLine++;
                else game.ui.commandLine=0;
            }
            if(code== KeyEvent.VK_ENTER || code== KeyEvent.VK_RIGHT)
            {
                switch (game.ui.commandLine)
                {
                    case 0:
                        game.set3on4Gameplay(17,10,game.player1.maxHealth);
                        break;
                    case 1:
                        //fct de load
                        game.set3on4Gameplay(game.dataDeBaza.getWorldTileX(),game.dataDeBaza.getWorldTileY(),game.dataDeBaza.getLife());
                        break;
                    case 2:
                        if(game.ui.titleScreenState==0)
                            game.ui.titleScreenState=1;
                        game.ui.commandLine=0;
                        break;
                    case 3:
                        game.StopGame();
                        System.exit(0);
                        break;
                }
            }
            if(code== KeyEvent.VK_ESCAPE || code== KeyEvent.VK_LEFT)
            {
                if(game.ui.titleScreenState==1 || game.ui.titleScreenState==2)
                    game.ui.titleScreenState=0;
            }
        }
        else if(game.gameStatus==game.fightStatus)
        {
            if (code == KeyEvent.VK_A) {
                left_command = true;
            }
            if (code == KeyEvent.VK_D) {
                right_command = true;
            }
            if(code == KeyEvent.VK_SPACE) {
                jump=true;
            }
            if(code==KeyEvent.VK_ENTER)
            {
                enter_command=true;
            }
            if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_P) {
                game.gameStatus = game.pauseStatus;
            }
        }
        else if(game.gameStatus==game.lvlCompletedStatus)
        {
            if(code==KeyEvent.VK_ENTER)
            {
                game.player1.lastSavedCurrentLife=game.player1.currentLife;
                game.set3on4Gameplay(game.player1.savedTileX,game.player1.savedTileY,game.player1.currentLife);
            }
        }
        else if(game.gameStatus==game.lvlFailedStatus)
        {
            if (code == KeyEvent.VK_W || code==KeyEvent.VK_UP) {
                if(game.ui.commandLine!=0)
                    game.ui.commandLine--;
                else game.ui.commandLine=1;
            }
            if (code == KeyEvent.VK_S || code==KeyEvent.VK_DOWN) {
                if(game.ui.commandLine!=1)
                    game.ui.commandLine++;
                else game.ui.commandLine=0;
            }
            if(code== KeyEvent.VK_ENTER)
            {
                switch (game.ui.commandLine)
                {
                    case 0:
                        game.setFightLevel(game.wnd.currentMap);
                        break;
                    case 1:
                        game.set3on4Gameplay(game.player1.savedTileX,game.player1.savedTileY,game.player1.lastSavedCurrentLife);
                        game.ui.commandLine=0;
                        break;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if (code== KeyEvent.VK_W) {
            up_command = false;
        }
        if (code== KeyEvent.VK_S)
            down_command=false;
        if (code== KeyEvent.VK_A)
            left_command=false;
        if (code== KeyEvent.VK_D)
            right_command=false;
        if(code == KeyEvent.VK_SPACE)
            jump=false;
        if (code == KeyEvent.VK_E) {
            e_command = false;
        }
        if(code==KeyEvent.VK_ENTER) {
            enter_command=false;
        }
    }

}
