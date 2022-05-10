package com.example.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClassA {

    //field based injection
    @Autowired(required = false)
    private ClassB classB;

    //Constructor based injection(For mandatory dependencies or when u aim for immutability)
    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    public ClassB getClassB() {
        return classB;
    }

    //Setter based injection(for optional dependency or changeable dependency)
    @Autowired(required = false)
    public void setClassB(ClassB classB) {
        this.classB = classB;
    }

    @PostConstruct
    public void test() {
        if(classB == null) {
            System.out.println("null");
        } else {
            classB.greet();
        }
    }
}
