package project1.exercise12;

import java.lang.*;
import java.util.*;

import project1.exercise12.*;

public class Sort {
    
    // sort array list by key order ASE
    public static ArrayList<Process> sort(String key, ArrayList<Process> pQ) {
        // sort by burst time
        if(key.equals("burstTime")) {
            for(int i = 0; i < pQ.size()-1; i++) {
                int _flag = 0;
                for(int j = 0; j < pQ.size()-1; j++) {
                    if(pQ.get(j).burstTime > pQ.get(j+1).burstTime) {
                        Process _p = pQ.get(j+1);
                        pQ.set(j+1, pQ.get(j));
                        pQ.set(j, _p);
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
        if(key.equals("arrivalTime")) {
            for(int i = 0; i < pQ.size()-1; i++) {
                int _flag = 0;
                for(int j = 0; j < pQ.size()-1; j++) {
                    if(pQ.get(j).arrivalTime > pQ.get(j+1).arrivalTime) {
                        Process _p = pQ.get(j+1);
                        pQ.set(j+1, pQ.get(j));
                        pQ.set(j, _p);
                        _flag = 1;
                    }
                }
                if(_flag == 0) {
                    // _flag == 0 means no order change in the queue, sort ends
                    break;
                }
            }
        }
        
        // sort by priority
        if(key.equals("priority")) {
            for(int i = 0; i < pQ.size()-1; i++) {
                int _flag = 0;
                for(int j = 0; j < pQ.size()-1; j++) {
                    if(pQ.get(j).priority > pQ.get(j+1).priority) {
                        Process _p = pQ.get(j+1);
                        pQ.set(j+1, pQ.get(j));
                        pQ.set(j, _p);
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
        
        
        
        
        return pQ;
    }
    
}
