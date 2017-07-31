package staym.vv.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池的管理
 * Created by MooreLi on 2017/7/31.
 */

public class ThreadManager {

    private ThreadPoolExecutor mLongExecutor;
    private ExecutorService mShortExecutor;

    private static final ThreadManager mInstance = new ThreadManager();

    public static ThreadManager getInstance() {
        return mInstance;
    }

    public ThreadPoolExecutor getLongExecutor() {
        return mLongExecutor;
    }

    private ThreadManager() {
        int num = Runtime.getRuntime().availableProcessors();
        mLongExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2 * num + 1);
        mShortExecutor = Executors.newSingleThreadExecutor();
    }

    public void executeLongTask(Runnable runnable) {
        mLongExecutor.execute(runnable);
    }

    public void executeShortTash(Runnable runnable) {
        mShortExecutor.execute(runnable);
    }

    public boolean remove(Runnable runnable) {
        if (mLongExecutor != null && !mLongExecutor.isShutdown()) {
            return mLongExecutor.remove(runnable);
        }
        return false;
    }
}
