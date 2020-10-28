package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author
 * @date 2020/8/27
 **/
@SpringBootTest
public class Tester {
    public static void main(String[] args) {
        TestObject testObject = new TestObject();
        testObject.sameMethod();
    }
}
