// Test.java
package com.jdojo.test;

import java.security.Provider;
import java.security.Security;



public class Test {
    public static void main(String[] args) {        
        Provider[] providers = Security.getProviders();
        Provider p = null;
        for(Provider p1 : providers) {
            p = p1;            
        }
        
        System.out.println(p.getName()  + "\n" + 
                     p.getInfo() + "\n"  + 
                     p.entrySet() );
        p.getInfo();
        
        System.out.println(p.keySet());
        System.out.println(p.values());
    }
}
