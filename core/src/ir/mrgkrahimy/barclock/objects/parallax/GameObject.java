package ir.mrgkrahimy.barclock.objects.parallax;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Mojtaba on 10/14/2016.
 */
public class GameObject {

    public final Vector2 position;
    public final Rectangle bounds;

    public GameObject(float x, float y, float width, float height) {
        this.position = new Vector2(x,y);
        this.bounds = new Rectangle(x - width/2f, y - height/2f, width, height);
    }
}

