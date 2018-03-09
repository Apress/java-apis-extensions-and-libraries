// InheritParentIO.java
package com.jdojo.process;

import java.io.File;
import java.io.IOException;

public class InheritParentIO {
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
        ProcessBuilder pb = new ProcessBuilder(javaPath, "--version")
                .redirectOutput(ProcessBuilder.Redirect.to(new File("java_product_details.txt")));

        try {
            // Start a new java process
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
