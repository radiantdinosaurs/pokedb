package io.radiantdinosaurs.pokedb.utils;

/**
 * Created by Bethany Corder on 12/13/2016.
 */
public class DimensionUtil {
    public static final int BASELINE_FONT_SIZE = 12;
    public static final int BASELINE_WIDTH = 1280;
    public static final int BASELINE_HEIGHT = 720;

    public static final int FONT_SCALING_FACTOR = 150;
    public static final int WINDOW_SCALING_FACTOR = 2;

    private DimensionUtil() {
    }

    public static int computerBaseFontSize(int width, int height) {
        double ratio;
        if(width >= height) {
            ratio = width / (double) BASELINE_WIDTH;
        }
        else {
            ratio = height / (double) BASELINE_HEIGHT;
        }

        return (int)(BASELINE_FONT_SIZE * ratio);
    }

    public static int computerComponentSize(int targetLength, int targetPercent) {
        return targetLength * targetPercent;
    }
}
