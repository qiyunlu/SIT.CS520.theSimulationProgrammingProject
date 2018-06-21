package project1.exercise3;

import java.lang.*;
import java.util.*;

import project1.exercise3.*;

// exercise 5.3 a
public class FCFS {
    
    // output route
    public static String route = "./output/project1/exercise3/FCFS Output.txt";

    // start time
    public static double startTime = 0d;
    // end time
    public static double endTime = -1d;
    // current time
    public static double currentTime = startTime;
    
    // ready queue
    public static ArrayList<Process> readyQ = new ArrayList<Process>();
    // record array
    public static double[][] record = new double[3][3];
    
    public static void main(String[] args) {
        
        // insert 3 processes in arrival time order
        readyQ.add(new Process(1, 0.0d, 8d));
        readyQ.add(new Process(2, 0.4d, 4d));
        readyQ.add(new Process(3, 1.0d, 1d));
        
        for(int turn = 0; !readyQ.isEmpty(); turn++) {
            // get next process
            Process prs = readyQ.get(0);
            readyQ.remove(0);
            
            // start running
            currentTime = Math.max(currentTime, prs.arrivalTime);
            currentTime = currentTime + prs.burstTime;
            prs.turnaroundTime = currentTime - prs.arrivalTime;
            
            // record turnaroundTime
            record[turn][0] = prs.id;
            record[turn][1] = prs.turnaroundTime;
            record[turn][2] = currentTime;
        }
        
        // print out average turnaround time
        double averageTurnaroundTime = T.keepDecimalPlaces((record[0][1]+record[1][1]+record[2][1])/3, 1);
        System.out.println("average turnaround time: "+averageTurnaroundTime);
        Output.export(route, "average turnaround time: "+averageTurnaroundTime+"\n");
        
        // print out Gantt chart
        String r1 = "FCFS: |";
        String r2 = "      0";
        for(int i = 0; i < record.length; i++) {
            r1 = r1 + "  P" + (new Double(record[i][0])).intValue() + "  |";
            r2 = r2 + "     " + String.format("%2s", (new Double(record[i][2])).intValue());
        }
        System.out.println(r1);
        System.out.println(r2);
        Output.export(route, r1+"\n");
        Output.export(route, r2+"\n\n");
        
    }

}
