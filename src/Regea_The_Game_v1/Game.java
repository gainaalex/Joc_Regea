package Regea_The_Game_v1;

import Entity.Entity;
import Entity.Player;
import Graphics.*;
import Graphics.Objects.Super_Obj;
import Graphics.Sound.Sound;
import Regea_The_Game_v1.UI.UI;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{
    public GameWindow wnd;
    private boolean runState;
    private Thread  gameThread;
    private BufferStrategy bs;
    private boolean isSwitching=true;

    public Graphics g;

    public int gameStatus;

    public UI ui;

    public final int titleScreen_Status=0;
    public final int playStatus=1;
    public final int pauseStatus=2;
    public final int dialogueStatus=3;
    public final int fightStatus=4;
    public int previousStatus;


    CommandKeys keyboard_command= new CommandKeys(this);
    Assets assets;
    public Player player1;
    public Collision collision;
    public Super_Obj[][] obj_list;
    public Obj_Placement obj_setter;
    public EventInterpretor eventInterpretor;
    public Entity[][] npc_list;
    public Entity[][] bosses;
    public NPC_Placement npcPlacement;

    public Sound background_music;
    public Sound sound;
    //private Tile tile;

    public Game(String title)
    {
        wnd = new GameWindow(title);

        previousStatus=playStatus;
        gameStatus=playStatus;

        ui=new UI(this);


        npc_list=new Entity[wnd.maxMaps][10];
        bosses=new Entity[wnd.maxMaps][10];

        npcPlacement=new NPC_Placement(this);
        npcPlacement.setNPCs();


        collision=new Collision(this);

        obj_list=new Super_Obj[wnd.maxMaps][100];
        obj_setter=new Obj_Placement(this);
        obj_setter.setObjects();
        eventInterpretor=new EventInterpretor(this);
        background_music=new Sound();
        background_music.setFile(0);
        background_music.play();
        background_music.loop();
        background_music.modifyVolume(50);
        sound=new Sound();

        wnd.BuildGameWindow();
        wnd.GetCanvas().addKeyListener(keyboard_command);
        wnd.GetCanvas().setFocusable(true);
        runState = false;
        assets=new Assets(this);
        player1=new Player(this,keyboard_command);
    }


    final int framesPerSecond   = 120;
    final double timeFrame      = 1000000000 / framesPerSecond; //0.16 seconds

    public void run()
    {
        /// Initializeaza obiectul game
        /////////////////////////////////////////////////////////  //Assets.Init();

        long oldTime = System.nanoTime();   /*!< Retine timpul in nanosecunde aferent frame-ului anterior.*/
        long curentTime;                    /*!< Retine timpul curent de executie.*/

        /// Apelul functiilor Update() & Draw() trebuie realizat la fiecare 16.7 ms
        /// sau mai bine spus de 60 ori pe secunda.

        /// Atat timp timp cat threadul este pornit Update() & Draw()
        while (runState == true)
        {
            /// Se obtine timpul curent
            curentTime = System.nanoTime();
            /// Daca diferenta de timp dintre curentTime si oldTime mai mare decat 16.6 ms
            if((curentTime - oldTime) > timeFrame)
            {
                /// Actualizeaza pozitiile elementelor
                Update();
                /// Deseneaza elementele grafica in fereastra.
                Draw();

                oldTime = curentTime;
            }
        }

    }

    public synchronized void StartGame()
    {
        if(runState == false)
        {
            /// Se actualizeaza flagul de stare a threadului
            runState = true;
            /// Se construieste threadul avand ca parametru obiectul Game. De retinut faptul ca Game class
            /// implementeaza interfata Runnable. Threadul creat va executa functia run() suprascrisa in clasa Game.
            gameThread = new Thread(this);
            /// Threadul creat este lansat in executie (va executa metoda run())
            gameThread.start();
        }
        else
        {
            /// Thread-ul este creat si pornit deja
            return;
        }
    }

    public synchronized void StopGame()
    {
        if(runState == true)
        {
            /// Actualizare stare thread
            runState = false;
            /// Metoda join() arunca exceptii motiv pentru care trebuie incadrata intr-un block try - catch.
            try
            {
                /// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
                /// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                /// In situatia in care apare o exceptie pe ecran vor fi afisate informatii utile pentru depanare.
                ex.printStackTrace();
            }
        }
        else
        {
            return;
        }
    }

    private void Update()
    {
        if (gameStatus==playStatus) {
            player1.Update();
            for (int i = 0; i < 10; i++) {
                if (npc_list[wnd.currentMap][i] != null)
                    npc_list[wnd.currentMap][i].Update();
                if(bosses[wnd.currentMap][i]!=null)
                    bosses[wnd.currentMap][i].Update();
            }
            if(obj_list[wnd.currentMap][0]!=null)
                obj_list[wnd.currentMap][0].Update();
        }
        if(gameStatus==fightStatus)
        {
            player1.Update_InFights();
        }
    }

    private void Draw() {
        bs = wnd.GetCanvas().getBufferStrategy();
        if (bs == null) {
            /// Se executa doar la primul apel al metodei Draw()
            try {
                /// Se construieste tripul buffer
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            } catch (Exception e) {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }
        /// Se obtine contextul grafic curent in care se poate desena.
        g = bs.getDrawGraphics();
        /// Se sterge ce era
        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());
        if(gameStatus==titleScreen_Status)
        {
            ui.Draw(g);
        }
        else if(previousStatus==playStatus){
            if(isSwitching==true)
            {
                wnd.currentMap=0;
                player1.set_position(50,47);
                isSwitching=false;
            }
            assets.Draw(g);

            for (int i = 0; i < obj_list[wnd.currentMap].length; i++) {
                if (obj_list[wnd.currentMap][i] != null && obj_list[wnd.currentMap][i].priority_over_player == false)
                    obj_list[wnd.currentMap][i].Draw(g, this);
            }
            for (int i = 0; i < npc_list[wnd.currentMap].length; i++) {
                if (npc_list[wnd.currentMap][i] != null)
                    npc_list[wnd.currentMap][i].Draw(g);
            }

            for (int i = 0; i < bosses[wnd.currentMap].length; i++) {
                if (bosses[wnd.currentMap][i] != null)
                    bosses[wnd.currentMap][i].Draw(g);
            }
            player1.Draw(g);
            assets.Draw_Over_player(g);
            for (int i = 0; i < obj_list[wnd.currentMap].length; i++) {
                if (obj_list[wnd.currentMap][i] != null && obj_list[wnd.currentMap][i].priority_over_player == true)
                    obj_list[wnd.currentMap][i].Draw(g, this);
            }

            ui.Draw(g);
        }
        else if(previousStatus==fightStatus)
        {
            if(isSwitching==true)
            {
                wnd.currentMap=1;
                player1.set_position(0,0);
                isSwitching=false;
            }
            assets.Draw(g);
            player1.Draw(g);
        }

        bs.show();
        g.dispose();
    }

    public int GetWndWidth()
    {
        return wnd.GetWndWidth();
    }
    public int GetWndHeight()
    {
        return wnd.GetWndHeight();
    }
    public int GetmaxWidth()
    {
        return wnd.GetmaxWidth();
    }
    public int GetmaxHeigth()
    {
        return wnd.GetmaxHeigth();
    }
    public int Tile_Size()
    {
        return wnd.Tile_Size;
    }

    public void stopMusic()
    {
        background_music.stop();
    }
    public void PlaySoundEffect(int i)
    {
        sound.setFile(i);
        sound.play();
    }
}