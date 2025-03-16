package com.efficient.multithreading.threads.scheduling.executor;

import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *  Schedule tasks for fixed rate using executor with repeated execution.
 *  Only Runnables (and not Callables) can be scheduled for fixed rate executions.
 *  Fixed rate will only reduce difference between start of tasks.
 * */
public class SchedulingTasksForFixedRateRepeatedExecution {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadsFactory());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3, new NamedThreadsFactory());

        System.out.println("[" + threadName + "] Current time: " + dateFormatter.format(new Date()));

        // tasks will take 1s with initial delay of 4s and interval of 2s between end of first and start of next
        ScheduledFuture<?> scheduledFuture = executorService.scheduleWithFixedDelay(new ScheduledTaskB(1000),
                4, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture2 = executorService.scheduleWithFixedDelay(new ScheduledTaskB(1000),
                4, 2, TimeUnit.SECONDS);

//        scheduledFuture2.cancel(true); // cancels the task-2

//        for (int i = 0; i < 5; i++){
//            System.out.print("[" + threadName + "] Next run of Task-1 scheduled at approx: ");
//            Date scheduledTime = TimeUtils.getFutureTime(new Date(), scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
//            System.out.println(dateFormatter.format(scheduledTime));
//
//            TimeUnit.MILLISECONDS.sleep(3000); // service will shutdown post 3s after 5 iterations
//        }

        TimeUnit.MILLISECONDS.sleep(20000); // service will shutdown post 20s
        executorService.shutdown();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
