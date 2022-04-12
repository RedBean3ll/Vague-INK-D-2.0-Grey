package com.softe.ris_team;

public class SystemInfo {

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }
    
    public static String programVersion() {
        return "v0.55 - Dev2";
    }

}