package Graphics.Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {
    Clip clip;
    private FloatControl volumeControl;
    private float actualVolume100;
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
        volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeControl.setValue((volumeControl.getMinimum()+volumeControl.getMaximum())/2);
        actualVolume100=Math.abs(volumeControl.getMinimum()-volumeControl.getMaximum());
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


    public void modifyVolume(float percent)
    {
        float comparedVolume=percent*actualVolume100/100;
        float newVolume = Math.min(volumeControl.getMaximum(), volumeControl.getMinimum()+comparedVolume);
        volumeControl.setValue(newVolume);
    }
}
