package com.joanna;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.print("enter command");
        while (scaner.hasNextLine()) {
            String command = scaner.next();
            System.out.print(command);
            if(command.equals("dir")) {
                System.out.print("$ dir");

            }
            else  if(command.equals("tree")){
                System.out.print("$ tree");
            }
            else if (command.equals("exit")) {
                System.out.print("Bye");
                break;

            }
            else if (command.isEmpty()) {
                System.out.print("$");
                break;

            }
            else {
             System.out.print("Unknown command"); }



        }
        scaner.close();
    }
}
