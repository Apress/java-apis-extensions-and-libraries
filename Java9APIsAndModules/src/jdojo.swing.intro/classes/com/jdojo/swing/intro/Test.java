// Test.java
package com.jdojo.swing.intro;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        for (int i = 1; i <= 30; i++) {
            frame.getContentPane().add(new JButton("Button " + i));
        }

        frame.pack();
        frame.setVisible(true);

    }
}
