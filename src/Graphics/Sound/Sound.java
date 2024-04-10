package Graphics.Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL=new URL[6];
    public Sound()
    {
        //main music
        soundURL[0]=getClass().getResource("/res/Sounds+Music/main_sound/main_song_regea_v2.wav");
        //power up/down
        soundURL[1]=getClass().getResource("/res/Sounds+Music/power_up_down/power_up.wav");
        soundURL[2]=getClass().getResource("/res/Sounds+Music/power_up_down/power_down.wav");
        //open door
        soundURL[3]=getClass().getResource("/res/Sounds+Music/doors/open_door.wav");
    }

    public void setFile(int i)
    {
        try{
            AudioInputStream in= AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(in);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
}
