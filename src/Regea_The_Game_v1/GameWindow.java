package Regea_The_Game_v1;

import javax.swing.*;
import java.awt.*;
public class GameWindow
{
    private JFrame  wndFrame;
    private String  wndTitle;
    private final int BTile=16;
    public final int Tile_Size=3*BTile;//48x48
    private final int maxWidth=20;
    private final int maxHeight=15;
    private final int wndWidth=maxWidth*Tile_Size;
    private final int wndHeight=maxHeight*Tile_Size;

    //World manager
    public final int maxWorldCol=100;
    public final int maxWorldRow=70;

    public final int worldWidth= Tile_Size*maxWorldCol;
    public final int worldHeigth= Tile_Size*maxWorldRow;
    private Canvas  canvas;

    public GameWindow(String title){
        wndTitle    = title;
        wndFrame    = null;
    }

    public void BuildGameWindow()
    {
        if(wndFrame != null)
        {
            return;
        }

        wndFrame = new JFrame(wndTitle);

        wndFrame.setSize(wndWidth, wndHeight);
        wndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wndFrame.setResizable(false);
        wndFrame.setLocationRelativeTo(null);
        wndFrame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(wndWidth, wndHeight));
        canvas.setMaximumSize(new Dimension(wndWidth, wndHeight));
        canvas.setMinimumSize(new Dimension(wndWidth, wndHeight));
        canvas.setBackground(Color.BLACK);
        //canvas.setBackground(new Color(27,63,24));
        wndFrame.add(canvas);
        wndFrame.pack();
    }
    public int GetWndWidth()
    {
        return wndWidth;
    }
    public int GetWndHeight()
    {
        return wndHeight;
    }
    public int GetmaxWidth()
    {
        return maxWidth;
    }
    public int GetmaxHeigth()
    {
        return maxHeight;
    }
    public Canvas GetCanvas() {
        return canvas;
    }
}
