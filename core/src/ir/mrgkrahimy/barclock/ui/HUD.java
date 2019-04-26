package ir.mrgkrahimy.barclock.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import ir.mrgkrahimy.barclock.base.TheGame;
import ir.mrgkrahimy.barclock.helpers.AssetsLoader;
import ir.mrgkrahimy.barclock.helpers.Consts;
import ir.mrgkrahimy.barclock.helpers.Prefs;

/**
 * Created by Mojtaba on 10/14/2016.
 */
public class HUD implements InputProcessor {

    private BitmapFont font;
    int x,y;
    private TextureRegion heart, tick, soundOn, soundOff;
    private ToggleButton soundButton;

    private final TheGame game;

    public HUD(int x, int y, final TheGame game){
        font=new BitmapFont();
        soundOn = AssetsLoader.soundOn;
        soundOff=AssetsLoader.soundOff;

        this.game=game;

        this.x=x;
        this.y=y;

        soundButton = new ToggleButton(
                Consts.H /2,
                y ,
                1.5f,
                1.5f,
                soundOn,
                soundOff
        );


    }

    public void draw(SpriteBatch batch) {
        // // TODO: 10/14/2016  draw ui here
        soundButton.draw(batch);

    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override public boolean touchUp (int screenX, int screenY, int pointer, int button) {

        Vector3 touchPos = new Vector3();
        touchPos.set(screenX, screenY, 0);
        game.camera.unproject(touchPos);

        if (soundButton.isClicked((int) touchPos.x, (int)touchPos.y)){
            Gdx.app.log("HUD sound ", "Clicked");
            if(Prefs.isSoundOn()){
                Prefs.setSoundOff();
            }else Prefs.setSoundOn();

        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}