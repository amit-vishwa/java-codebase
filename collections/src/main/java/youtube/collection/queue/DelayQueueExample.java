package youtube.collection.queue;

import java.time.LocalTime;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue is a thread-safe unbounded (capacity optional) blocking queue.
 * It uses PriorityQueue internally.
 * Elements can only be taken from the queue when their delay has expired.
 * It is useful for scheduling tasks to be executed after a certain delay.
 * */
public class DelayQueueExample {

    public static void main(String[] args) {
        simpleDelayQueueExample();
    }

    private static void simpleDelayQueueExample() {
        try {
            BlockingQueue<DelayedTask> delayedTaskBlockingQueue = new DelayQueue<>();
            delayedTaskBlockingQueue.put(new DelayedTask("Task 1",4,TimeUnit.SECONDS));
            delayedTaskBlockingQueue.put(new DelayedTask("Task 2",2,TimeUnit.SECONDS));
            delayedTaskBlockingQueue.put(new DelayedTask("Task 3",5,TimeUnit.SECONDS));
            System.out.println(delayedTaskBlockingQueue); // stores in sorted manner as per priority

            while (!delayedTaskBlockingQueue.isEmpty()){
                DelayedTask task = delayedTaskBlockingQueue.take();
                System.out.println("Executed " + task.getTaskName() + " at " + LocalTime.now());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //////////////////////////////   Helper Class    /////////////////////////////////////

    static class DelayedTask implements Delayed{

        private final String taskName;
        private final long startTime;

        public DelayedTask(String taskName, long delay, TimeUnit unit) {
            this.taskName = taskName;
            this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remaining = startTime - System.currentTimeMillis();
            return unit.convert(remaining,TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(startTime < ((DelayedTask) o).startTime){
                return -1;
            }
            if(startTime > ((DelayedTask) o).startTime){
                return 1;
            }
            return 0;
        }

        public String getTaskName(){
            return taskName;
        }

        @Override
        public String toString() {
            return  "taskName='" + taskName + '\'' +
                    ": startTime=" + startTime;
        }
    }

}
