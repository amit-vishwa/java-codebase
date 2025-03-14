package com.efficient.multithreading.threads.alive;

import com.efficient.multithreading.threads.daemon.LoopTaskD;
import com.efficient.multithreading.threads.daemon.NamedDaemonThreadsFactory;
import com.efficient.multithreading.threads.naming.LoopTaskC;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;
import com.efficient.multithreading.threads.returned.executors.CalculationTaskA;

import java.util.concurrent.*;

/**
 * Executor Threads never die, they need to forcefully shutdown.
 * We are interested in task completion and that can be found using isDone().
 * */
public class ExecutorThreadAliveCheck {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        Future<?> future1 = executorService.submit(new LoopTaskC());
        Future<Integer> future2 = executorService.submit(new CalculationTaskA(3,4,700));

        FutureTask<?> futureTask3 = new FutureTask<Void>(new LoopTaskC(), null);
        FutureTask<Integer> futureTask4 = new FutureTask<Integer>(new LoopTaskC(), 999);
        FutureTask<Integer> futureTask5 = new FutureTask<Integer>(new CalculationTaskA(4,5,500));

        executorService.execute(futureTask3);
        executorService.execute(futureTask4);
        executorService.execute(futureTask5);

        executorService.shutdown();

        for(int i = 1; i <= 5; i++){
            TimeUnit.MILLISECONDS.sleep(300);

            System.out.println("[" + threadName + "] Iteration-" + i + " -> Is LoopTaskC-1 done? " + future1.isDone());
            System.out.println("[" + threadName + "] Iteration-" + i + " -> Is CalculationTaskA-1 done? " + future2.isDone());
        }

        System.out.println("[" + threadName + "] Retrieving results now...");

        System.out.println("[" + threadName + "] 'LoopTaskC-1' result = " + future1.get());
        System.out.println("[" + threadName + "] 'CalculationTaskA-1' result = " + future2.get());


        System.out.println("[" + threadName + "] 'LoopTaskC-2' result = " + futureTask3.get());
        System.out.println("[" + threadName + "] 'LoopTaskC-3' result = " + futureTask4.get());
        System.out.println("[" + threadName + "] 'CalculationTaskA-2' result = " + futureTask5.get());

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
