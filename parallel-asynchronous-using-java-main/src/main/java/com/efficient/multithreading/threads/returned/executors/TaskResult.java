package com.efficient.multithreading.threads.returned.executors;

public class TaskResult<S, V> {
    private S taskId;
    private V result;

    public TaskResult(S taskId, V result) {
        this.taskId = taskId;
        this.result = result;
    }

    public S getTaskId() {
        return taskId;
    }

    public V getResult() {
        return result;
    }

    @Override
    public String toString(){
        return "TaskResult: [task=" + taskId + ", result=" + result + "]";
    }

}
