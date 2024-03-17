package com.aston.logistictestingspring;

import com.aston.logistictestingspring.server.TomcatServer;

public class App {
    public static void main(String[] args) {
        new TomcatServer().start();
    }
}
