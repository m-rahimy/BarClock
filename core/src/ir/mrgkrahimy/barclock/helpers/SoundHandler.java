package ir.mrgkrahimy.barclock.helpers;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Mojtaba on 10/14/2016.
 */
public class SoundHandler {

    private static Sound tick;
    private static Music music;

    public enum SOUND{
        correct, wrong
    }

    public static void init(){
        music = AssetsLoader.music;
    }

    public static void playTick(SOUND sound){
        if(Prefs.isSoundOn()) {
            tick.play();
        }
    }

    public static void playMusic(){
        if (!music.isPlaying() && Prefs.isSoundOn())
            music.play();
    }

    public static void stopMusic(){
        if (music.isPlaying())
            music.stop();
    }

    public static void check(){
        if (!music.isPlaying() && Prefs.isSoundOn())
            music.play();
        music.setVolume(1.f);
        if(!Prefs.isSoundOn()) music.setVolume(0.f);
    }
}
