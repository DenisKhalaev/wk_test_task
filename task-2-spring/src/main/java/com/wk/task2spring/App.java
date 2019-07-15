package com.wk.task2spring;

import com.wk.task2spring.thread.Interrogator;

import java.io.IOException;

/**
 * @author Denis Khalaev
 */
public class App {
    public static void main(String[] args) {
        Interrogator interrogator = new Interrogator();
        interrogator.start();
    }
}
