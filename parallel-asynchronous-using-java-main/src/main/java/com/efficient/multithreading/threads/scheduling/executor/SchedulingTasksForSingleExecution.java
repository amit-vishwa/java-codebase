package com.efficient.multithreading.threads.scheduling.executor;

import com.efficient.multithreading.threads.naming.NamedThreadsFactory;
import com.efficient.multithreading.threads.scheduling.normal.ScheduledTaskA;
import com.efficient.multithreading.threads.scheduling.normal.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.*;

/**
 *  Scheduling tasks for one time execution using Executors.
 *  When delay is added in particular thread, then just use same ScheduledExecutorService.
 *  No need to work with separate service like separate timers for normal threads.
 * */
public class SchedulingTasksForSingleExecution {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadsFactory());
        // below is for 3 scheduled services
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3, new NamedThreadsFactory());

        System.out.println("[" + threadName + "] Current time: " + dateFormatter.format(new Date()));

        ScheduledFuture<?> scheduledFuture1 = executorService.schedule(new ScheduledTaskB(3000), 4, TimeUnit.SECONDS);
        ScheduledFuture<Integer> scheduledFuture2 = executorService.schedule(new CalculationTaskD(2,3,2000), 6, TimeUnit.SECONDS);
        executorService.schedule(new ScheduledTaskB(0), 8, TimeUnit.SECONDS);
        ScheduledFuture<Integer> scheduledFuture4 = executorService.schedule(new CalculationTaskD(3, 4,0), 10, TimeUnit.SECONDS);

        executorService.shutdown();

        // retrieving results after cancel will give CancellationException
        scheduledFuture1.cancel(true);
        scheduledFuture2.cancel(true);

        System.out.println("[" + threadName + "] Retrieving the results now...\n");

//        System.out.println("[" + threadName + "] Task-1 result = " + scheduledFuture1.get());
//        System.out.println("[" + threadName + "] Task-2 result = " + scheduledFuture2.get());
        System.out.println("[" + threadName + "] Task-4 result = " + scheduledFuture4.get());

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
