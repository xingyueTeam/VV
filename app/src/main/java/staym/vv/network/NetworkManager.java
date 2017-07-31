package staym.vv.network;

import com.squareup.okhttp.Request;

import staym.vv.utils.Logs;

/**
 * Created by MooreLi on 2017/7/31.
 */

public class NetworkManager {
    private final String TAG = "NetworkManager";
    private HttpListener mListener;

    public NetworkManager(HttpListener listener) {
        this.mListener = listener;
    }

    public NetworkManager() {

    }

    public void post(final String url, final String params) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Logs.i(TAG,"requestUrl:"+url);
                Logs.i(TAG,"requestParams:"+params);
                OkHttpClientManager.getInstance().getPostDelegate().postAsyn(url, params, new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Logs.i(TAG, "error===>" + e.getMessage());
                        if (mListener != null) {
                            mListener.onFail("3000", e.getMessage());
                        }
                    }

                    @Override
                    public void onResponse(String response) {
                        Logs.i(TAG, "response===>" + response);
                        if (mListener != null) {
                            mListener.onSuccess(response, "2000", "");
                        }
                    }
                });
            }
        };
        ThreadManager.getInstance().executeLongTask(runnable);
    }
}
