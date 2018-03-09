// MappedSharedLibraryName.java
package com.jdojo.jni;

public class LibraryNameMapper {
    public static void main(String[] args) {
        String libName = "beginningjava";
        String mappedName = System.mapLibraryName(libName);

        System.out.println("Shared Library Name: " + libName);
        System.out.println("Mapped Shared Library Name: " + mappedName);
    }
}
