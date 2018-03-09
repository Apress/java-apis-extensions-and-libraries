// QueryingRuntime.java
package com.jdojo.process;

public class QueryingRuntime {
    public static void main(String[] args) {
        // Get the Runtime instance
        Runtime rt = Runtime.getRuntime();

        // Get the JVM memory
        long maxMemoery = rt.maxMemory();
        long totalMemory = rt.totalMemory();
        long freeMemory = rt.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.format("Max memory = %d, Total memoery = %d,"
                + "Free memoery = %d, Used memory = %d.%n", 
                maxMemoery, totalMemory, freeMemory, usedMemory);
        
        // Print the number of processors available to the JVM
        int processors = rt.availableProcessors();
        System.out.format("Number of processors = %d%n", processors);
        
        // Print the version of the Java runtime
        Runtime.Version version = rt.version();
        System.out.format("Number of processors = %s%n", version);        
    }
}
