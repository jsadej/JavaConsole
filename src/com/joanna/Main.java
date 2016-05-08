package com.joanna;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        Consola c = new Consola();
        c.displayPrompt();
        String pattern = "(^cd)(\\s)(.*)";
        Pattern r = Pattern.compile(pattern);
        boolean done = false;

        while (!done) {
            String command = buffer.readLine();
            Matcher m = r.matcher(command);
            //System.out.print(command);
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
                c.changeCurrentDir(m.group(3));
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
        isr.close();

    }

}