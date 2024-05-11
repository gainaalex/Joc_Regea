package Graphics.Objects;

import Graphics.TileScaler;
import Regea_The_Game_v1.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obj_Fountain extends Super_Obj{
    public BufferedImage[] animated_obj;
    public int next_animation=0;
    public Obj_Fountain(Game game,int type)
    {
        super(game);
        name="Fountain"+type;
        try{
            switch (type){
                case 0:
                    animated_obj=new BufferedImage[2];
                    animated_obj[0]=ImageIO.read(getClass().getResourceAsStream("/res/Castle/fantana/faltana animata/tile000.png"));
                    animated_obj[1]=ImageIO.read(getClass().getResourceAsStream("/res/Castle/fantana/faltana animata/tile001.png"));
                    image= animated_obj[next_animation];
                    next_animation++;
                    break;
                case 1:
                    animated_obj=new BufferedImage[3];
                    animated_obj[0]=ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/arteziana/tile000.png"));
                    animated_obj[1]=ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/arteziana/tile001.png"));
                    animated_obj[2]=ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/arteziana/tile002.png"));
                    image= animated_obj[next_animation];
                    next_animation++;
                    break;
                case 2:
                    animated_obj=new BufferedImage[1];
                    animated_obj[0]=ImageIO.read(getClass().getResourceAsStream("/res/Village/de adaugat/fantana/fantana.png"));
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
            animated_obj[i]=TileScaler.scaleImage(animated_obj[i],width,height);
        }
    }
    @Override
    public void set_image() {
        if(animation_Counter%3==0 && !isUpdated)
        {
            image=animated_obj[next_animation];
            if(next_animation==animated_obj.length-1)
                next_animation=0;
            else
                next_animation++;
            isUpdated=true;
        }
    }
}
