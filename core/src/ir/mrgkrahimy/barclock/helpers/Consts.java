package ir.mrgkrahimy.barclock.helpers;

/**
 * Created by Mojtaba on 10/13/2016.
 */
public class Consts {

    public static final int H = 320;
    public static final float ASPECT_RATIO = 600.0f/14.0f;
    public static final float SPLASH_SCREEN_TIME = 1.5f;

    public static final int HANDLE_HEIGHT = 14;
    public static final int HANDLE_WIDTH = 600;

    public static final int SECONDS_WIDTH = HANDLE_WIDTH /60;
    public static final int MINUTES_WIDTH = SECONDS_WIDTH;
    public static final int HOURS_WIDTH = HANDLE_WIDTH/24;
    //public static final int days_width = HANDLE_WIDTH/31

    public static final int FRUIT_LINE_COUNT = 3;

    public static final int FRUIT_COUNT = 14;

    public static final float INIT_SPAWN_TIME = 3.f;

    public static final float WORLD_TO_BOX = 0.01f;
    public static final float BOX_TO_WORLD = 100f;

    public static final float GRAVITY = -9.8f;

    public static final float animationDuration = 0.8f;
    public static final int MARGIN = 10;

    public static short collide_help = -1;

    public static float step = 1.0f / 60.0f;
}
