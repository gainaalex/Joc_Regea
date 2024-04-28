package Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileScaler {
    static public BufferedImage scaleImage(BufferedImage original,int width,int height)
    {
        BufferedImage rezultat=new BufferedImage(width,height,original.getType());
        Graphics2D g= rezultat.createGraphics();
        g.setBackground(new Color(0,0,0));
        g.drawImage(original,0,0,width,height,null);
        g.dispose();
        return rezultat;
    }
}
