package staym.vv.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by MooreLi on 2017/7/31.
 */

public class ParamsTool {
    private JSONObject params;

    public ParamsTool() {
        params = new JSONObject();
        /**
         * 在此添加必传参数
         */

    }

    public void addParams(String name, String value) {
        try {
            params.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addParams(String name, int value) {
        try {
            params.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addParams(String name, double value) {
        try {
            params.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addParams(String name, Object value) {
        try {
            params.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addParams(String name, JSONArray value) {
        try {
            params.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getParamsString() {
        /**
         * 如果加密，在此加密
         */
        return params.toString();
    }
}
