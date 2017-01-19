package com.generallibrary.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池封装
 * Created by yueguang on 15-8-18.
 */
public class LibBackgroundWorker {
    private ExecutorService mThreadPool;
    private static LibBackgroundWorker mWorker;

    private LibBackgroundWorker() {
        mThreadPool = Executors.newCachedThreadPool();
    }

    public static LibBackgroundWorker getInstance() {
        if (mWorker == null) {
            mWorker = new LibBackgroundWorker();
        }
        return mWorker;
    }

    public Future submitTask(Runnable task) {
        return mThreadPool.submit(task);
    }

    public void executeTask(Runnable task) {
        mThreadPool.execute(task);
    }
}
