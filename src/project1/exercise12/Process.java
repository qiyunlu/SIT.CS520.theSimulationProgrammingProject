package project1.exercise12;

import java.lang.*;

public class Process {
    public int id = 0;
    public int priority = 0;
    public double arrivalTime = 0d;
    
    public double burstTime = 0d;
    public double lastStopTime = 0d;
    public double turnaroundTime = 0d;
    public double waitingTime = 0d;
    
    // not used
    public String place  = "ready queue";
    
    public Process(int id, int priority, double burstTime) {
        this.id = id;
        this.priority = priority;
        this.burstTime = burstTime;
    }
}
