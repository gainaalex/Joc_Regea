package Graphics.Objects;

import Graphics.TileScaler;
import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obj_SuperFarm extends Super_Obj{
    public BufferedImage[] animated_obj;
    public int next_animation=0;
    public int currentTempo=-1;
    public Obj_SuperFarm(Game game, int type)
    {
        super(game);
        name="Farm"+type;
        try{
            switch (type){
                //case moara vant
                case 0:
                    animated_obj=new BufferedImage[8];
                    animated_obj[0]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara1.png"));
                    animated_obj[1]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara2.png"));
                    animated_obj[2]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara3.png"));
                    animated_obj[3]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara4.png"));
                    animated_obj[4]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara5.png"));
                    animated_obj[5]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara6.png"));
                    animated_obj[6]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara7.png"));
                    animated_obj[7]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara de vant/final/moara8.png"));
                    image= animated_obj[next_animation];
                    next_animation++;
                    break;
                //case moara rau
                case 1:
                    animated_obj=new BufferedImage[4];
                    animated_obj[3]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara/final/moara1.png"));
                    animated_obj[2]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara/final/moara2.png"));
                    animated_obj[1]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara/final/moara3.png"));
                    animated_obj[0]= ImageIO.read(getClass().getResourceAsStream("/res/Ferma/moara/final/moara4.png"));
                    image= animated_obj[next_animation];
                    next_animation++;
                    break;
                //case ferma
                case 2:
                    animated_obj=new BufferedImage[1];
                    animated_obj[0]=ImageIO.read(getClass().getResourceAsStream("/res/Ferma/bard/sura.png"));
                    image=animated_obj[0];
                    break;


            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision=true;
        priority_over_player=true;
    }
    @Override
    public void scaleImages(int width,int height)
    {
        for (int i=0;i<animated_obj.length;i++)
        {
            animated_obj[i]= TileScaler.scaleImage(animated_obj[i],width,height);
        }
    }
    @Override
    public void set_image() {
        if(currentTempo!=animation_Counter)
        {
            image = animated_obj[next_animation];
            if (next_animation == animated_obj.length - 1)
                next_animation = 0;
            else
                next_animation++;
            currentTempo=animation_Counter;
        }
    }
}
