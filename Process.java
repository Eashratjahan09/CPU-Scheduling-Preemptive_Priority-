import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Process implements Comparable<Process> {
    private String name;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    public Process(String name, int arrivalTime, int burstTime, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Process other) {
        // Lower priority value means higher priority
        return Integer.compare(this.priority, other.priority);
    }
}