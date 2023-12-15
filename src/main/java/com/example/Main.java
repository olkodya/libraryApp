package com.example;

import com.example.utils.Menu;

import java.util.logging.Level;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        LogManager.getLogManager().getLogger("").setLevel(Level.OFF);
        Menu.run();

    }
}