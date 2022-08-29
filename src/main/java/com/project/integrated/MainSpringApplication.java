package com.project.integrated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainSpringApplication {

    private static ConfigurableApplicationContext CONTEXT;

    public static void run(String[] args) {
        CONTEXT = SpringApplication.run(MainSpringApplication.class, args);
    }

    public static void stop() {
        SpringApplication.exit(CONTEXT);
    }

    public static boolean isActive() {

        if (CONTEXT == null) {
            return false;
        }

        return CONTEXT.isActive();
    }
}