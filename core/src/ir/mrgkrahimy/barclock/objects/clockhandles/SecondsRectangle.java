package ir.mrgkrahimy.barclock.objects.clockhandles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Mojtaba on 10/14/2016.
 */
public class SecondsRectangle {

    private int x, y, w, h;
    private Color color;
    private String digit;

    public SecondsRectangle(int x, int y, int w, int h, String digit, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.color = color;
        this.digit = digit;
    }

    public void update(float delta){
        System.out.println(System.currentTimeMillis()/1000000000000L+"");
        x-=1;
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, w, h);
        shapeRenderer.end();
    }

    public int getH() {
        return h;
    }

    public Color getColor() {
        return color;
    }

    public int getW() {
        return w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDigit() {
        return digit;
    }
}
