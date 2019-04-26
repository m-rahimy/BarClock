package ir.mrgkrahimy.barclock.objects.parallax;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Mojtaba on 10/14/2016.
 */
public class DynamicGameObject extends GameObject {

    public final Vector2 velocity;
    public final Vector2 accel;

    public DynamicGameObject(float x, float y, float width, float height) {
        super(x, y, width, height);
        velocity = new Vector2();
        accel = new Vector2();
    }
}

