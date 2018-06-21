package project1.exercise12;

import java.lang.*;
import java.util.*;

import project1.exercise12.*;

public class SJF {
    
    // output route
    public static String route = "./output/project1/exercise12/SJF Output.txt";

    // start time
    public static double startTime = 0d;
    // current time
    public static double currentTime = startTime;
    
    // process queue
    public static ArrayList<Process> processQ = new ArrayList<Process>();
    // record array
    public static int turn = 0;
    public static int numberOfProcess = 5;
    public static double[][] record = new double[numberOfProcess*2+1][5];  // id, start time, end time, turnaround time, waiting time
    
    public static void main(String[] args) {
        
        // create 5 processes in ready queue
        processQ.add(new Process(1, 3, 10d));
        processQ.add(new Process(2, 1, 1d));
        processQ.add(new Process(3, 3, 2d));
        processQ.add(new Process(4, 4, 1d));
        processQ.add(new Process(5, 2, 5d));
        
        for(; !processQ.isEmpty();) {
            // sort by burst time
            processQ = Sort.sort("burstTime", processQ);
            // get next process with smallest burst time
            Process prs = processQ.get(0);
            processQ.remove(0);
        
            // start running
            double _startTime = currentTime;
            prs.waitingTime = prs.waitingTime + _startTime - prs.lastStopTime;
            currentTime = currentTime + prs.burstTime;
            prs.turnaroundTime = currentTime - prs.arrivalTime;
            
            // record information
            record[turn][0] = prs.id;
            record[turn][1] = _startTime;
            record[turn][2] = currentTime;
            record[turn][3] = prs.turnaroundTime;
            record[turn][4] = prs.waitingTime;
            turn++;
        }
        
        // print out turnaround time and waiting time
        double totalWaitingTime = 0d;
        for(int i = 0; record[i][0] != 0d; i++) {
            System.out.println("Process "+T.doubleToInt(record[i][0])+" turnaround time: "+T.keepDecimalPlaces(record[i][3], 1));
            System.out.println("Process "+T.doubleToInt(record[i][0])+" waiting time: "+T.keepDecimalPlaces(record[i][4], 1));
            totalWaitingTime += T.keepDecimalPlaces(record[i][4], 1);
        }
        System.out.println("Average waiting time: "+T.keepDecimalPlaces(totalWaitingTime/5, 1));

        System.out.println("");
        
        // print out Gantt chart
        String r1 = "SJF:  |";
        String r2 = "      0";
        for(int i = 0; record[i][0] != 0d; i++) {
            r1 = r1 + "  P" + T.doubleToInt(record[i][0]) + "  |";
            r2 = r2 + "     " + String.format("%2s", T.doubleToInt(record[i][2]));
        }
        System.out.println(r1);
        System.out.println(r2);
        Output.export(route, r1+"\n");
        Output.export(route, r2+"\n\n");

    }

}
