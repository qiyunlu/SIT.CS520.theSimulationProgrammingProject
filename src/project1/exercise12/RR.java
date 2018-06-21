package project1.exercise12;

import java.lang.*;
import java.util.*;

import project1.exercise12.*;

public class RR {
    
    // output route
    public static String route = "./output/project1/exercise12/RR Output.txt";

    // start time
    public static double startTime = 0d;
    // current time
    public static double currentTime = startTime;
    
    // process queue
    public static ArrayList<Process> processQ = new ArrayList<Process>();
    // RR quantum
    public static double quantum = 1d;
    // record array list for Gantt chart
    public static ArrayList<double[]> recordQ = new ArrayList<double[]>();  // recordQ: double[]: id, start time, end time
    // process state after completion
    public static double[][] record = new double[6][2];  // record[id]: turnaround time, waiting time
    
    public static void main(String[] args) {
        
        // create 5 processes in ready queue
        processQ.add(new Process(1, 3, 10d));
        processQ.add(new Process(2, 1, 1d));
        processQ.add(new Process(3, 3, 2d));
        processQ.add(new Process(4, 4, 1d));
        processQ.add(new Process(5, 2, 5d));
        
        for(; !processQ.isEmpty();) {
            // get next process
            Process prs = processQ.get(0);
            processQ.remove(0);
            
            // start running
            double _startTime = currentTime;
            prs.waitingTime = prs.waitingTime + _startTime - prs.lastStopTime;
            currentTime = currentTime + Math.min(prs.burstTime, quantum);
            prs.burstTime = prs.burstTime - quantum;
            prs.lastStopTime = currentTime;
            prs.turnaroundTime = currentTime - prs.arrivalTime;
            
            // record information
            double[] _r = new double[3];
            _r[0] = prs.id;
            _r[1] = _startTime;
            _r[2] = currentTime;
            recordQ.add(_r);
            
            // is this process completed
            if(prs.burstTime <= 0d) {
                record[prs.id][0] = prs.turnaroundTime;
                record[prs.id][1] = prs.waitingTime;
            }
            else {
                processQ.add(prs);
            }
        }
        
        // print out turnaround time and waiting time
        double totalWaitingTime = 0d;
        for(int i = 1; i <= 5; i++) {
            System.out.println("Process "+i+" turnaround time: "+T.keepDecimalPlaces(record[i][0], 1));
            System.out.println("Process "+i+" waiting time: "+T.keepDecimalPlaces(record[i][1], 1));
            totalWaitingTime += T.keepDecimalPlaces(record[i][1], 1);
        }
        System.out.println("Average waiting time: "+T.keepDecimalPlaces(totalWaitingTime/5, 1));

        System.out.println("");
        
        // print out Gantt chart
        String r1 = "RR:  |";
        String r2 = "     0";
        for(int i = 0; i < recordQ.size(); i++) {
            double[] _re = recordQ.get(i);
            r1 = r1 + " P" + T.doubleToInt(_re[0]) + " |";
            r2 = r2 + "   " + String.format("%2s", T.doubleToInt(_re[2]));
        }
        System.out.println(r1);
        System.out.println(r2);
        Output.export(route, r1+"\n");
        Output.export(route, r2+"\n\n");

    }

}
