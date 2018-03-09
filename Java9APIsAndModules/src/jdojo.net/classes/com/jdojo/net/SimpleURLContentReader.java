// SimpleURLContentReader.java
package com.jdojo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SimpleURLContentReader {
    public static void main(String[] args) {
        String urlStr = "http://httpbin.org/get?year=1969";
        String content = getURLContent(urlStr);
        System.out.println(content);
    }

    public static String getURLContent(String urlStr) {
        BufferedReader br = null;
        try {
            URL url = new URL(urlStr);

            // Get the input stream wrapped into a BufferedReader
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder sb = new StringBuilder();
            String msg = null;
            while ((msg = br.readLine()) != null) {
                sb.append(msg);
                sb.append("\n"); // Append a new line 
            }

            return sb.toString();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // If we get here it means there was an error 
        return null;
    }

}
