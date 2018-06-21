package project1.exercise3;

import java.lang.*;
import java.util.*;

import project1.exercise3.*;

//exercise 5.3 b and c
public class SJF {
    
    // output route
    public static String route = "./output/project1/exercise3/SJF Output.txt";

    // start time
    public static double startTime = 0d;
    // end time
    public static double endTime = -1d;
    // current time
    public static double currentTime = 0d;
    
    // process queue
    public static ArrayList<Process> processQ = new ArrayList<Process>();
    // record array
    public static double[][] record = new double[3*2][4];
    public static int turn = 0;

    public static void main(String[] args) {
        
        // create 3 processes
        processQ.add(new Process(1, 0.0d, 8d));
        processQ.add(new Process(2, 0.4d, 4d));
        processQ.add(new Process(3, 1.0d, 1d));
        
        //* the CPU is left idle for the first 1 unit
        processQ.add(new Process(-1, 0.0d, 1d));
        //*/
        
        for(; !processQ.isEmpty();) {
            // import processes in ready queue
            boolean _empty = true;
            for(int i = 0; i < processQ.size(); i++) {
                Process _p = processQ.get(i);
                if(_p.arrivalTime <= currentTime) {
                    _p.place = "readyQueue";
                    processQ.set(i, _p);
                    _empty = false;
                }
            }
            // if no process is imported in ready queue
            if(_empty) {
                processQ = Sort.sort("arrivalTime", processQ);
                double _currentTime = currentTime;
                currentTime = processQ.get(0).arrivalTime;
                
                // recording
                record[turn][0] = -1;                // -1 means CPU is not running any process
                record[turn][1] = _currentTime;      // start time
                record[turn][2] = currentTime;       // finish time
                record[turn][3] = 0d;
                turn++;
                
                continue;
            }
            
            // now have at least one process in ready queue
            // sort process queue by burst time
            processQ = Sort.sort("burstTime", processQ);
            
            // get next process in ready queue
            Process prs = null;
            for(int i = 0; i < processQ.size(); i++) {
                prs = processQ.get(i);
                if(prs.place.equals("readyQueue")) {
                    processQ.remove(i);
                    break;
                }
                prs = null;
            }
            
            // now CPU is running the process which is stored in prs
            double _currentTime = currentTime;
            currentTime = _currentTime + prs.burstTime;
            prs.turnaroundTime = currentTime - prs.arrivalTime;
            
            // recording
            record[turn][0] = prs.id;
            record[turn][1] = _currentTime;      // start time
            record[turn][2] = currentTime;       // finish time
            record[turn][3] = prs.turnaroundTime;
            if(prs.id < 0) {
                record[turn][3] = 0d;
            }
            turn++;
        }
        
        // print out average turnaround time
        double toatalTT = 0d;
        for(int i = 0; i < record.length; i++) {
            toatalTT += record[i][3];
        }
        double averageTurnaroundTime = T.keepDecimalPlaces(toatalTT/3, 1);
        System.out.println("average turnaround time: "+averageTurnaroundTime);
        Output.export(route, "average turnaround time: "+averageTurnaroundTime+"\n");
        
        // print out Gantt chart
        String r1 = "SJF:  |";
        String r2 = "      0";
        for(int i = 0; record[i][0] != 0.0d; i++) {
            String row1 = "";
            if(record[i][0] < 0) {
                row1 = "      |";
            }
            else {
                row1 = "  P"+(new Double(record[i][0])).intValue()+"  |";
            }
            r1 = r1 + row1;
            r2 = r2 + "     " + String.format("%2s", (new Double(record[i][2])).intValue());
        }
        System.out.println(r1);
        System.out.println(r2);
        Output.export(route, r1+"\n");
        Output.export(route, r2+"\n\n");

    }
    
}
