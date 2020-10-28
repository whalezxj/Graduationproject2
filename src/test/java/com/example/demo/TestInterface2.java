package com.example.demo;

public interface TestInterface2 {
    default void sameMethod() { System.out.println("Invoke TestInterface2 method！"); }
}
