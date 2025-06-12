package com.arcadia.core.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EngineLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String GRAY = "\u001B[90m";
    private static final String BLUE = "\u001B[94m";
    private static final String YELLOW = "\u001B[93m";
    private static final String RED = "\u001B[91m";
    private static final String GREEN = "\u001B[92m";

    private static String now() {
        return LocalDateTime.now().format(formatter);
    }

    public static void info(String msg) {
        System.out.println(GREEN + "[" + now() + "] [INFO] [Arcadia] " + msg + RESET);
    }

    public static void debug(String msg) {
        System.out.println(BLUE + "[" + now() + "] [DEBUG] [Arcadia] " + msg + RESET);
    }

    public static void error(String msg) {
        System.err.println(RED + "[" + now() + "] [ERROR] [Arcadia] " + msg + RESET);
    }
}
