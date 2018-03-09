// Test.java
package com.jdojo.swing.advanced;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class Test {
    public static void main(String[] args) {
        String windowsLAF = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            LookAndFeel laf = UIManager.createLookAndFeel("Windows");
            UIManager.setLookAndFeel(laf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(UIManager.getLookAndFeel());
        
        JFrame frame = new JFrame ("test");        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        
        container.add(new JLabel("Name:"));
        container.add(new JTextField("This is my name"));
        container.add(new JButton("Save"));
        
        frame.pack();
        frame.setVisible(true);

    }
}
