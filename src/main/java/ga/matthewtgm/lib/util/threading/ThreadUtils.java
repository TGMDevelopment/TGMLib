package ga.matthewtgm.lib.util.threading;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUtils {

    private static ThreadUtils INSTANCE;
    private AtomicInteger threadCount = new AtomicInteger(0);
    private ThreadPoolExecutor executor;

    {
        executor = new ThreadPoolExecutor(50, 50, 0l, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), (r) -> {
            return new Thread(r, String.format("Thread %s", threadCount.incrementAndGet()));
        });
    }

    public static ThreadUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ThreadUtils();
        return INSTANCE;
    }

    public void runAsync(ThreadRunnable runnable) {
        executor.execute(runnable::run);
    }

}