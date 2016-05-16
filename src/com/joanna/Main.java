package com.joanna;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main  {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        ConsolaImpl cimpl=new ConsolaImpl();
        cimpl.displayPrompt();
        String pattern = "(^cd)(\\s)(.*)";
        String patternPrompt="(^prompt)(\\s)(.*)";
        Pattern r = Pattern.compile(pattern);
        Pattern rPrompt=Pattern.compile(patternPrompt);
        boolean done = false;

        while (!done) {
            String command = buffer.readLine();
            Matcher m = r.matcher(command);
            Matcher mprompt=rPrompt.matcher(command);
            if (command.equals("dir")) {
                cimpl.displayCurrentWorkingDirectory();
                try {
                    cimpl.listWorkingDirectory();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cimpl.displayPrompt();

            } else if (command.equals("tree")) {
                cimpl.runTree();
                cimpl.displayPrompt();

            } else if (m.matches()) {
                cimpl.changeCurrentDir(m.group(3));
                cimpl.displayPrompt();

            } else if(mprompt.matches()) {
                cimpl.customizePrompt(mprompt.group(3));
                cimpl.displayPrompt();

            } else if (command.equals("exit")) {
                System.out.print("Bye");
                done = true;

            } else if (command.isEmpty()) {
                cimpl.displayPrompt();

            } else {
                System.out.print("Unknown command");
                cimpl.displayPrompt();
            }
        }
        isr.close();

    }

}