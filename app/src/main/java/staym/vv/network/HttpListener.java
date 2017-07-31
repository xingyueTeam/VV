package staym.vv.network;

/**
 * Created by MooreLi on 2017/7/31.
 */

public interface HttpListener {
    void onSuccess(String result, String code, String retMessage);

    void onFail(String code, String retMessage);
}
