package staym.vv.core;

/**
 * Created by MooreLi on 2017/7/31.
 */

public class UrlUtils {

    public static String IP;
    public static String port;

    static {
        if (BuildCons.NET_TYPE == 0) {
            IP = "http://106.14.175.20:";
            port = "8082";
        } else if (BuildCons.NET_TYPE == 1) {
            IP = "http://106.14.175.20:";
            port = "8083";
        }
    }

    public final static String BASE_URL = IP + port;
}
