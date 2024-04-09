package Regea_The_Game_v1;

import Entity.Player;
import Graphics.*;
import Graphics.Objects.Super_Obj;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{
    public GameWindow      wnd;
    private boolean         runState;
    private Thread          gameThread;
    private BufferStrategy bs;

    private Graphics g;
    CommandKeys keyboard_command= new CommandKeys();
    Assets assets;
    public Player player1;
    public Collision collision;
    public Super_Obj[] obj_list;
    public Obj_Placement obj_setter;
    //private Tile tile;

    public Game(String title)
    {
        wnd = new GameWindow(title);

        player1=new Player(this,keyboard_command);

        collision=new Collision(this);

        obj_list=new Super_Obj[3];
        obj_setter=new Obj_Placement(this);
        obj_setter.setObjects();

        wnd.BuildGameWindow();
        wnd.GetCanvas().addKeyListener(keyboard_command);
        wnd.GetCanvas().setFocusable(true);
        runState = false;
        assets=new Assets(this);
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
        player1.Update();
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

        assets.Draw(g);

        for (int i=0;i< obj_list.length;i++)
        {
            if(obj_list[i]!=null)
                obj_list[i].Draw(g,this);
        }

        player1.Draw(g);

        //g.setColor(Color.white);
        //g.fillRect(player1.x,player1.y, wnd.Tile_Size, wnd.Tile_Size);

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
}

/*
    private void Draw()
    {
        /// Returnez bufferStrategy pentru canvasul existent
        bs = wnd.GetCanvas().getBufferStrategy();
        /// Verific daca buffer strategy a fost construit sau nu
        if(bs == null)
        {
            /// Se executa doar la primul apel al metodei Draw()
            try
            {
                /// Se construieste tripul buffer
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }
        /// Se obtine contextul grafic curent in care se poate desena.
        g = bs.getDrawGraphics();
        /// Se sterge ce era
        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());


        /// operatie de desenare
        // ...............
        Tile.grassTile.Draw(g, 0 * Tile.TILE_WIDTH, 0);
        Tile.soilTile.Draw(g, 1 * Tile.TILE_WIDTH, 0);
        Tile.waterTile.Draw(g, 2 * Tile.TILE_WIDTH, 0);
        Tile.mountainTile.Draw(g, 3 * Tile.TILE_WIDTH, 0);
        Tile.treeTile.Draw(g, 4 * Tile.TILE_WIDTH, 0);

        g.drawRect(1 * Tile.TILE_WIDTH, 1 * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);


        // end operatie de desenare
        /// Se afiseaza pe ecran
        bs.show();

        /// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
        /// elementele grafice ce au fost desenate pe canvas).
        g.dispose();
    }
}
*/