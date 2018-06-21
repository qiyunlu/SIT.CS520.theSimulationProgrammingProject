package project2;

import java.lang.*;

// time unit: ms
public class Process {
    
    public int id = 0;
    
    public int leftBurstTime = 0;
    public int nextStartTime = 0;
    public int lastEndTime = 0;
    
    public int meanInterIOInterval = 0;
    public int thisRunningTime = 0;
    
    public String place = "start";
    
    public int turnaroundTime = 0;
    public int runningTime = 0;
    public int waitingTime = 0;
    
    // for SJF
    public int predictBurstTime = 0;
    
    public Process(int id, int burstTime, int meanInterIOInterval) {
        this.id = id;
        this.leftBurstTime = burstTime;
        this.meanInterIOInterval = meanInterIOInterval;
    }
    
}
