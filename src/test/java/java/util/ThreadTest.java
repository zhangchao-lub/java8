package java.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/6 16:47
 * @descrption
 */
public class ThreadTest {
    private static final Logger logger = LoggerFactory.getLogger(ThreadTest.class);

    @Test
    public void createThread() throws ExecutionException, InterruptedException {
        // 首先我们创建了一个线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
// futureTask 我们叫做线程任务，构造器的入参是 Callable
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                // 返回一句话
                return "我是子线程" + Thread.currentThread().getName();
            }
        });
// 把任务提交到线程池中，线程池会分配线程帮我们执行任务
        executor.submit(futureTask);
// 得到任务执行的结果
        String result = (String) futureTask.get();
        logger.info("result is {}", result);
    }
}
