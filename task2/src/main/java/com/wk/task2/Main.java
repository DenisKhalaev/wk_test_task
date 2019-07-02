package com.wk.task2;

import com.wk.task2.thread.Interrogator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Interrogator interrogator = new Interrogator();
        interrogator.start();

    }
}
