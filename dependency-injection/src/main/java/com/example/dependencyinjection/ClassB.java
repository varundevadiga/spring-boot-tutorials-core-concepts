package com.example.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class ClassB {
    public void greet() {
        System.out.println("Hello from India");
    }
}
