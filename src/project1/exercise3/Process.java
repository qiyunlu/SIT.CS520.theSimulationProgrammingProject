package project1.exercise3;

import java.lang.*;

public class Process {
    public int id = -1;
    public double arrivalTime = -1d;
    public double burstTime = -1d;
    
    public double turnaroundTime = -1d;
    public String place = "start";
    
    public Process(int id, double arrivalTime, double burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}
