package project2;

import java.io.*;

import project2.*;

public class Output {
    
    /*
     * copy from "http://blog.csdn.net/malik76/article/details/6408726/"
     * to add content(String) in route(a file)
     */
    public static void export(String route, String content) {
        FileWriter writer = null;
        try {
            // open a new writer. "true" means we add things behind.
            writer = new FileWriter(route, true);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
