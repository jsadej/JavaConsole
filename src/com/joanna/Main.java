package com.joanna;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        Consola c=new Consola();
        c.displayPrompt();

        while (scaner.hasNextLine()) {
            String command = scaner.next();
            if(command.equals("dir")) {
                System.out.print("dir");
                c.displayPrompt();


            }
            else  if(command.equals("tree")){
                System.out.print("tree");
                c.displayPrompt();

            }
            else if (command.equals("exit")) {
                System.out.print("Bye");
                break;

            }
            else if (scaner.next().equals("")) {
                System.out.print("Empty");
                c.displayPrompt();
            }
            else {
             System.out.print("Unknown command");
                c.displayPrompt();
            }



        }
        scaner.close();
    }
}
