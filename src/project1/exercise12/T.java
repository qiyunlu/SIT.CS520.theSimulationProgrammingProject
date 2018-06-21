package project1.exercise12;

import java.lang.*;

import project1.exercise12.*;

public class T {
    // this tool class is for method and format that hard to classify
    
    // num keeps N decimal places
    public static double keepDecimalPlaces(double num, int N) {
        return (double) (Math.round(num * Math.pow(10, N)) / Math.pow(10, N));
    }
    
    // double to int
    public static int doubleToInt(double num) {
        return (new Double(num)).intValue();
    }
    
    
    
    
    
    
    
}
