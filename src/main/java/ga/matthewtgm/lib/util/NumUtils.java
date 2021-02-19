package ga.matthewtgm.lib.util;

import java.util.Random;

public class NumUtils {

    private static NumUtils INSTANCE;
    private Random random = new Random();

    public static NumUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NumUtils();
        return INSTANCE;
    }

    public Integer getRandomNumber(int min, int max) {
        return random.nextInt(max - min) + min;
    }

}