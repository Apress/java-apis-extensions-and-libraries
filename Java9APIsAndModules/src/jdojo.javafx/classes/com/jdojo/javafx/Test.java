// Test.java
package com.jdojo.javafx;

import javafx.application.Application;
import javafx.collections.ObservableSet;
import javafx.print.Printer;
import javafx.stage.Stage;

public class Test extends Application {
    public Test() {
        System.out.println("constructor(): " + Thread.currentThread());
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        //Application.launch(args);

        ObservableSet<Printer> allPrinters = Printer.getAllPrinters();
        for (Printer p : allPrinters) {
            System.out.println(p.getName());
        }

    }

    @Override
    public void init() {
        System.out.println("init(): " + Thread.currentThread());
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello JavaFX Application");
        stage.show();
    }
}
