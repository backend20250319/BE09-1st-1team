package com.bookmark.library;

public class Main {
    public static void main(String[] args) {
        String version = System.getProperty("java.version");
        String runtimeVersion = System.getProperty("java.runtime.version");
        String vendor = System.getProperty("java.vendor");

        System.out.println("Java Version: " + version);
        System.out.println("Java Runtime Version: " + runtimeVersion);
        System.out.println("Java Vendor: " + vendor);
    }
}
