package com.joanna;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scaner = new Scanner(System.in);
        Consola c = new Consola();
        c.displayPrompt();

        while (scaner.hasNextLine()) {
            String command = scaner.next();
            if (command.equals("dir")) {
                c.displayCurrentWorkingDirectory();
                try {
                    c.showWorkingDirectory();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                c.displayPrompt();


            } else if (command.equals("tree")) {
                System.out.print("tree");
                c.displayPrompt();

            } else if (command.equals("cd..")) {
                c.displayCurrentWorkingDirectory();
                c.displayPrompt();

            } else if (command.equals("exit")) {
                System.out.print("Bye");
                break;

            } else if (command.equals("")) {
                System.out.print("Empty");
                c.displayPrompt();
            } else {
                System.out.print("Unknown command");
                c.displayPrompt();
            }


        }
        scaner.close();
    }
}
