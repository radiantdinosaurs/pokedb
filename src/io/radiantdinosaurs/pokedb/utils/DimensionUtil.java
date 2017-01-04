package io.radiantdinosaurs.pokedb.utils;

/**
 * Contains functions needed to resize GUI components based on monitor dimensions
 * @author radiantdinosaurs
 */
public class DimensionUtil {
    private static final int BASELINE_FONT_SIZE = 12;
    private static final int BASELINE_WIDTH = 1280;
    private static final int BASELINE_HEIGHT = 720;

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
}
