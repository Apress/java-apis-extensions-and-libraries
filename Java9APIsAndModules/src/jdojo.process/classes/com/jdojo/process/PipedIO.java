// PipedIO.java
package com.jdojo.process;

import java.io.IOException;

public class PipedIO {
    public static void main(String[] args) {
        // Get the path of the java program that started this program
        String javaPath = ProcessHandle.current()
                                       .info()
                                       .command().orElse(null);        
        if(javaPath == null) {
            System.out.println("Could not get the java command's path.");
            return;
        }
             
        // Configure the ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder(javaPath,  "--version");
        
        try {
            // Start a new java process
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}
