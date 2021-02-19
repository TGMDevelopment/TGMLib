package ga.matthewtgm.lib.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class WebUtils {

    private static WebUtils INSTANCE;

    public static WebUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new WebUtils();
        return INSTANCE;
    }

    /**
     * @param url the url to fetch the json from.
     * @return the json in the form of a string.
     */
    public String getJsonOnline(String url) {
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            reader.lines().forEach(builder::append);
            return builder.toString();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}