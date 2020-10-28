package com.example.demo;

public interface TestInterface1 {
    default void sameMethod() { System.out.println("Invoke TestInterface1 method！"); }
}
