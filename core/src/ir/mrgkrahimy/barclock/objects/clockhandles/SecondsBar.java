package ir.mrgkrahimy.barclock.objects.clockhandles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import ir.mrgkrahimy.barclock.helpers.Consts;

/**
 * Created by Mojtaba on 10/14/2016.
 */
public class SecondsBar {

    private Array<SecondsRectangle> seconds;
    private BitmapFont font;

    public SecondsBar(int yPos, BitmapFont font) {
        seconds = new Array<SecondsRectangle>(60);
        font.getData().setScale(.4f, .4f);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        this.font = font;

        int d = 0;
        for (int i = 0; i < 60; i++) {
            //String digit = String.valueOf(d++);
            String digit = String.format("%02d", d++);
            SecondsRectangle secondsRectangle = new SecondsRectangle(
                    i * Consts.SECONDS_WIDTH, yPos,
                    Consts.SECONDS_WIDTH, Consts.HANDLE_HEIGHT, digit,
                    new Color(1, 1, 1, 1));
            seconds.add(secondsRectangle);
        }
    }

    private Vector2 getSecondCenter(SecondsRectangle second) {
        return new Vector2(second.getX() + second.getW() / 2, second.getY() + second.getH() / 2);
    }

    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        for (SecondsRectangle secondsRectangle : seconds) {
            secondsRectangle.draw(shapeRenderer);

            batch.begin();

            float x = secondsRectangle.getX();
            if (Integer.valueOf(secondsRectangle.getDigit()) < 10) x += Consts.SECONDS_WIDTH / 3;
            else x += Consts.SECONDS_WIDTH / 5;

            font.draw(batch, secondsRectangle.getDigit(),
                    x, secondsRectangle.getY() + secondsRectangle.getH() / 1.4f
            );

            batch.end();
        }
    }

    public void update(float delta) {
        for (SecondsRectangle secondsRectangle : seconds) {
            secondsRectangle.update(delta);
        }

    }
}
