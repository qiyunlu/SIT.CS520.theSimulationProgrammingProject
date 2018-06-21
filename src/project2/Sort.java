package project2;

import java.lang.*;
import java.util.*;

import project2.*;

public class Sort {
    
    // sort array list by key order ASE
    public static ArrayList<Process> sort(String key, ArrayList<Process> pl) {
        
        // sort by predictBurstTime
        if(key.equals("predictBurstTime")) {
            for(int i = 0; i < pl.size()-1; i++) {
                int _flag = 0;
                for(int j = 0; j < pl.size()-1; j++) {
                    if(pl.get(j).predictBurstTime > pl.get(j+1).predictBurstTime) {
                        Process _p = pl.get(j+1);
                        pl.set(j+1, pl.get(j));
                        pl.set(j, _p);
                        _flag = 1;
                    }
                }
                if(_flag == 0) {
                    // _flag == 0 means no order change in the queue, sort ends
                    break;
                }
            }
        }
        
        // sort by arrival time
        if(key.equals("nextStartTime")) {
            for(int i = 0; i < pl.size()-1; i++) {
                int _flag = 0;
                for(int j = 0; j < pl.size()-1; j++) {
                    if(pl.get(j).nextStartTime > pl.get(j+1).nextStartTime) {
                        Process _p = pl.get(j+1);
                        pl.set(j+1, pl.get(j));
                        pl.set(j, _p);
                        _flag = 1;
                    }
                }
                if(_flag == 0) {
                    // _flag == 0 means no order change in the queue, sort ends
                    break;
                }
            }
        }
        
        
        // other method
        
        
        
        
        return pl;
    }
    
}
