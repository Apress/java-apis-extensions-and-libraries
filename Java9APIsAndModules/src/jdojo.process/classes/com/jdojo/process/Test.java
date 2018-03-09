// Test.java
package com.jdojo.process;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.util.Arrays;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        ProcessHandle.Info info = ProcessHandle.current()
                                               .info();
        String javaPath = info.command().orElse("");
        
        System.out.println("command: " + javaPath);
                
        ProcessBuilder pb = new ProcessBuilder(javaPath,  "--module-path", "dist", 
                "--module", "jdojo.process/com.jdojo.process.QueryingRuntime", "101")
                .directory(new File("C:\\"));
       // pb.inheritIO();
       
       Map<String,String> env = pb.environment();
       env.put("arg1", "value1");
       env.put("arg2", "value2");
       
        try {            
            Process p = pb.start();
            
            ProcessHandle child = p.toHandle();
            ProcessHandle parent = child.parent().orElse(null);
            System.out.println("Paremt  :" + parent);
            System.out.println("Current :" + ProcessHandle.current());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
