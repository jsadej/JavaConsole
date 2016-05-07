package com.joanna;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scaner = new Scanner(System.in);
        Consola c = new Consola();
        c.displayPrompt();
        String pattern = "(^cd)(\\s+)(.*)+";
        Pattern r = Pattern.compile(pattern);
        boolean done = false;

        while (!done) {
            String command = scaner.nextLine();
            Matcher m = r.matcher(command);
            System.out.print(command);
            if (command.equals("dir")) {
                c.displayCurrentWorkingDirectory();
                try {
                    c.displayListWorkingDirectory();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                c.displayPrompt();


            } else if (command.equals("tree")) {
                System.out.print("tree");
                c.displayPrompt();

            } else if (m.matches()) {
                c.displayCurrentWorkingDirectory();
                c.displayPrompt();

            } else if (command.equals("exit")) {
                System.out.print("Bye");
                done = true;

            } else if (command.isEmpty()) {
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