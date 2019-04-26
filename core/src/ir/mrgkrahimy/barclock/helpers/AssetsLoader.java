package ir.mrgkrahimy.barclock.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Mojtaba on 10/13/2016.
 */
public class AssetsLoader {

    private static Texture texture;
    public static Texture logo, about;

    public static TextureRegion
            seconds, minutes,hours,days, months, years,
            soundOff, soundOn, background,
            beginButton, beginButtonEn, aboutButton, aboutButtonEn, menuButton, menuButtonEn;

    public static Sound tickSound;
    public static Music music;

    public static Preferences preferences;

    public static float barsAspectRatio;

    public static void load() {

        // loading all textures
        texture = new Texture(Gdx.files.internal("image/texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        logo = new Texture(Gdx.files.internal("image/logo.png"));
        logo.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        about = new Texture(Gdx.files.internal("image/about.jpg"));
        about.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        //todo: loading handles

        // todo: these are not correct
        soundOn = new TextureRegion(texture, 325,240,380-325, 44);
        soundOff = new TextureRegion(texture,383, 240,422-383,44);

        music = Gdx.audio.newMusic(Gdx.files.internal("sound/music.ogg"));
        music.setLooping(true);

        //: buttons
        beginButton = new TextureRegion(texture, 0, 287, 179, 465 - 286);
        beginButtonEn = new TextureRegion(texture, 0, 466, 179, 645 - 466);

        aboutButton = new TextureRegion(texture, 180, 287, 359-180, 465 - 286);
        aboutButtonEn = new TextureRegion(texture, 180, 466, 359-180, 645 - 466);

        menuButton = new TextureRegion(texture, 360,286,540-360,465-286);
        menuButtonEn = new TextureRegion(texture,360,466,540-360,645-466);
    }

    public static void dispose() {

        texture.dispose();
        logo.dispose();
        about.dispose();

        music.dispose();

    }
}
