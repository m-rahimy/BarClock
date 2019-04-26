package ir.mrgkrahimy.barclock.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Mojtaba on 10/14/2016.
 */
public class Prefs {
    public static Preferences preferences;

    public static void  init(){
        preferences = Gdx.app.getPreferences("ir.mrgkrahimy.barclock");
    }

    public static void setSoundOn(){
        preferences.putBoolean("sound", true);
        preferences.flush();
    }

    public static void setSoundOff(){
        preferences.putBoolean("sound", false);
        preferences.flush();
    }

    public static boolean isSoundOn(){
        return preferences.getBoolean("sound");
    }
}
