package com.shapetool.shapetool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.shapetool")
public class ShapetoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShapetoolApplication.class, args);
    }
}