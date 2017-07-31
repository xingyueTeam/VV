package staym.vv.http;

import staym.vv.core.UrlUtils;
import staym.vv.network.HttpListener;
import staym.vv.network.NetworkManager;
import staym.vv.network.ParamsTool;

/**
 * Created by MooreLi on 2017/7/31.
 */

public class UserHttpUtils {
    /**
     * 测试
     *
     * @param listener
     */
    public static void test(HttpListener listener, int sex, int minAge) {
        String url = UrlUtils.BASE_URL + "/userReport/listUser";
//        String url = "http://182.92.8.118:8082/teamReport/getAreaList";
        ParamsTool tool = new ParamsTool();
        tool.addParams("sex", sex);
//        tool.addParams("minAge", minAge);
        NetworkManager manager = new NetworkManager(listener);
        manager.post(url, tool.getParamsString());
    }
}
