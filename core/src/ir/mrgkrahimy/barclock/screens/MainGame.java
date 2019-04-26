package ir.mrgkrahimy.barclock.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import ir.mrgkrahimy.barclock.base.TheGame;
import ir.mrgkrahimy.barclock.helpers.AssetsLoader;
import ir.mrgkrahimy.barclock.helpers.Consts;
import ir.mrgkrahimy.barclock.helpers.Prefs;
import ir.mrgkrahimy.barclock.helpers.SoundHandler;
import ir.mrgkrahimy.barclock.objects.clockhandles.SecondsBar;
import ir.mrgkrahimy.barclock.ui.HUD;

/**
 * Created by Mojtaba on 10/13/2016.
 */
public class MainGame extends InputAdapter implements Screen {

    private final TheGame game;

    private HUD hud;

    private TextureRegion bg;
    private ShapeRenderer shapeRenderer;

    private float w, h;
    private int MARGIN = Consts.MARGIN;

    private SecondsBar secondsBar;

    public MainGame(final TheGame game, float w, float h) {
        this.w = w;
        this.h = h;
        this.game = game;
    }

    @Override
    public void show() {

        Prefs.init();
        SoundHandler.init();
        SoundHandler.playMusic();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(game.camera.combined);

        bg = AssetsLoader.background;

        hud=new HUD(0,0, game);

        // set two Inputs for one screen
        InputMultiplexer inputMultiplexer = new InputMultiplexer();

        InputProcessor inputProcessorOne = this;
        InputProcessor inputProcessorTwo = hud;

        inputMultiplexer.addProcessor(inputProcessorOne);
        inputMultiplexer.addProcessor(inputProcessorTwo);

        Gdx.input.setInputProcessor(inputMultiplexer);

        secondsBar = new SecondsBar((int) (w/4), game.font);
    }

    @Override
    public void render(float delta) {

        SoundHandler.check();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        game.batch.setProjectionMatrix(game.camera.combined);

        // draw margin
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(-w / 2 + MARGIN, -h / 2 + MARGIN, w - MARGIN * 2, h - MARGIN * 2);
        shapeRenderer.end();

        // draw handles
        secondsBar.draw(game.batch,shapeRenderer);

        // update handles
        secondsBar.update(delta);

        game.batch.begin();

        hud.draw(game.batch);

        game.batch.end();


        // drawing index on top
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.line(0, -h / 2, 0, 0, h / 2, 0);
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        //debugRenderer.dispose();
        AssetsLoader.dispose();
        game.batch.dispose();

    }

    Vector3 tmp = new Vector3();
    @Override
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {

        tmp.set(screenX, screenY, 0);
        game.camera.unproject(tmp);

        return true;
    }

    @Override
    public boolean touchUp (int screenX, int screenY, int pointer, int button) {


        return false;
    }

    @Override
    public boolean touchDragged (int screenX, int screenY, int pointer) {

        tmp.set(screenX, screenY, 0);
        game.camera.unproject(tmp);

        return true;
    }

}
