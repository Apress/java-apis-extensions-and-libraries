// CapturePipedIO.java
package com.jdojo.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapturePipedIO {
    public static void main(String[] args) {        
        // Get the path of the java program that started thsi program
        String javaPath = ProcessHandle.current()
                .info()
                .command().orElse(null);
        if (javaPath == null) {
            System.out.println("Could not get the java command's path.");
            return;
        }

        // Configure the ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder(javaPath, "--version");

        try {
            // Start a new java process
            Process p = pb.start();

            // Read and print the standard output stream of the process
            try (BufferedReader input = 
                    new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
