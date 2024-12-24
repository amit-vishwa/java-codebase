package tutorial.dsa.datastructures.queues.priority;

// Structure for the elements in the priority queue
public class PriorityQueue{
    private int value;
    private int priority;
    public PriorityQueue(){}
    public PriorityQueue(int value, int priority){
        this.value = value;
        this.priority = priority;
    }
    public int getValue(){
        return value;
    }
    public int getPriority(){
        return priority;
    }
}
