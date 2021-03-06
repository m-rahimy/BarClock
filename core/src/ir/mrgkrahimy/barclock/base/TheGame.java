package ir.mrgkrahimy.barclock.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import ir.mrgkrahimy.barclock.helpers.Consts;
import ir.mrgkrahimy.barclock.screens.SplashScreen;

public class TheGame extends Game {

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public FitViewport viewport;
	public BitmapFont font;

	float w,h;

	public TheGame(){
	}

	@Override
	public void create () {

		float height= Consts.H;
		float ppu = Gdx.graphics.getHeight() / height;

		h=height;
		w= Gdx.graphics.getWidth() / ppu;
		System.out.println("THE_GAME: "+ "w: " + w+ "h: "+ h);

		camera=new OrthographicCamera();
		viewport = new FitViewport(w,h,camera);
		viewport.apply();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		font = new BitmapFont();

		setScreen(new SplashScreen(this,w,h));

	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
