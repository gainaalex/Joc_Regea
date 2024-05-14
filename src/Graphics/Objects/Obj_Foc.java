package Graphics.Objects;

import Graphics.TileScaler;
import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obj_Foc extends Super_Obj{
    public BufferedImage[] animated_obj;
    public int next_animation=0;
    public int currentTempo=0;
    public Obj_Foc(Game game, int type)
    {
        super(game);
        name="Fire"+type;
        try{
            switch (type){
                case 0:
                    animated_obj=new BufferedImage[5];
                    animated_obj[0]= ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/foc/final/cazan_pe_foc1.png"));
                    animated_obj[1]= ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/foc/final/cazan_pe_foc2.png"));
                    animated_obj[2]= ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/foc/final/cazan_pe_foc3.png"));
                    animated_obj[3]= ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/foc/final/cazan_pe_foc4.png"));
                    animated_obj[4]= ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/foc/final/cazan_pe_foc5.png"));
                    image= animated_obj[next_animation];
                    next_animation++;
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
        if(currentTempo!=animation_Counter && animation_Counter%3==0)
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
