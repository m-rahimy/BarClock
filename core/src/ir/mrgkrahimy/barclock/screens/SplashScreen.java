package ir.mrgkrahimy.barclock.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ir.mrgkrahimy.barclock.base.TheGame;
import ir.mrgkrahimy.barclock.helpers.AssetsLoader;
import ir.mrgkrahimy.barclock.helpers.Consts;

/**
 * Created by Mojtaba on 10/13/2016.
 */
public class SplashScreen extends InputAdapter implements Screen {

    final TheGame game;
    float w,h;
    float time=0.f;

    ShapeRenderer renderer;

    private Texture logo;

    public SplashScreen(final TheGame game, float w, float h){

        this.game=game;
        this.w=w;
        this.h=h;

        AssetsLoader.load();

        Gdx.input.setInputProcessor(this);

    }
    @Override
    public void show() {

        logo =AssetsLoader.logo;

        renderer = new ShapeRenderer();
        renderer.setProjectionMatrix(game.camera.combined);
        game.batch.setProjectionMatrix(game.camera.combined);

        time=0;
    }

    @Override
    public void render(float delta) {

        time += delta;

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(logo, -logo.getWidth()/2, -logo.getHeight()/2);
        game.batch.end();

        if (time > Consts.SPLASH_SCREEN_TIME) {
            logo.dispose();
            AssetsLoader.logo.dispose();
            game.setScreen(new MainGame(game, w, h));
        }
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

    }

    public boolean touchUp (int screenX, int screenY, int pointer, int button) {
        game.setScreen(new MainGame(game, w, h));
        return true;
    }

}