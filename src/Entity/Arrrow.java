package Entity;

import Regea_The_Game_v1.Game;

import java.io.IOException;

public class Arrrow extends Projectile{

    public Arrrow(Game g) {
        super(g);
        name="Arrow";
        speed=3;
        maxTimeOnScreen=240;
        timeOnScreen=maxTimeOnScreen;
        damage=20;
        alive=false;
        getImage();
    }
    private void getImage()
    {
        projectileImage=setup("/res/Fights_resource/sageata/tile000.png");
    }
}
