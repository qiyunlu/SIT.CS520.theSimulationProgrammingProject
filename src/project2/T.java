package project2;

import java.lang.*;

import project2.*;

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
    
    
    
    // generate random execution time with length uniformly distributed between 2 and 4 minutes
    public static int uniformlyExecutionTime() {
        return T.doubleToInt((Math.random()*120000)+120000);
    }
    
    // generate exponential random time between I/O requests
    public static int exponentiallyIOTime(int perLambda) {
        int m = 65536;
        double Z = (-perLambda)*Math.log((Math.random()*m+1)/m);
        return T.doubleToInt(Z);
    }
    
    
}
