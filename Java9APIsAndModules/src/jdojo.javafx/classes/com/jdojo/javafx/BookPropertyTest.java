// BookPropertyTest.java
package com.jdojo.javafx;

import javafx.beans.property.ReadOnlyProperty;

public class BookPropertyTest {
    public static void main(String[] args) {
        Book book = new Book("Beginning Java 9", 49.99, "148422843X");

        System.out.println("After creating the Book object...");

        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());

        // Change the book's properties
        book.setTitle("Learn JavaFX 8");        
        book.setPrice(59.99);

        System.out.println("\nAfter changing the Book properties...");

        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());
    }

    public static void printDetails(ReadOnlyProperty<?> p) {
        String name = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();

        System.out.print(propClassName);
        System.out.print("[Name:" + name);
        System.out.print(", Bean Class:" + beanClassName);
        System.out.println(", Value:" + value + "]");
    }
}
