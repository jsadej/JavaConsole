package com.joanna;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(isr);
            ConsolaImpl c_impl = new ConsolaImpl();
            c_impl.displayPrompt();

            while (!c_impl.isDone()) {
                String command = buffer.readLine();
                c_impl.SetandRun(command);

            }
            isr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}