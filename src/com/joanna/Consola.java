package com.joanna;
import java.io.File;
import java.io.IOException;



/**
 * Created by jonna on 2016-05-05.
 */
public class Consola {
    File currentDirectory = new File(System.getProperty("user.dir"));
    String currentPrompt = "$";

    public void displayPrompt() {
        StringBuilder builder = new StringBuilder();
        builder.append(currentPrompt).append(" ");

        String s = builder.toString();
        System.out.print(s);
    }

    public void listWorkingDirectory() throws IOException {
        File[] files = currentDirectory.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.print("Dir:");
            } else {
                System.out.print("File:");
            }
            System.out.println(f.getName());
        }

    }

    public void displayCurrentWorkingDirectory() {
        System.out.println(currentDirectory);
    }

    public void changeCurrentDir(String newPath) throws IOException {

        File NewFilePath = new File(newPath);
        // used to check if exist
        File newCanonicalFile = NewFilePath.getCanonicalFile();
        // used to set proper new user.dir
        String newCanonicalPath = NewFilePath.getCanonicalPath();

        System.out.println("canonical path: " + newCanonicalFile);
        if (newCanonicalFile.exists()) {
            System.setProperty("user.dir", newCanonicalPath);
            currentDirectory = newCanonicalFile;
            System.out.print("Katalog zmieniony na: " + currentDirectory);
        } else {
            System.out.print("No such directory: " + newCanonicalPath);
        }


    }

    public void customizePrompt(String prompt) throws IOException {

        if (prompt.equals("cwd")) {
            System.out.print("jestem w cwd " + currentDirectory.getCanonicalPath());
            currentPrompt = currentDirectory.getCanonicalPath();
            System.out.print("moj prompt " + currentPrompt);

        } else if (prompt.equals("reset")) {
            currentPrompt = "$";

        } else {
            currentPrompt=prompt;

        }

    }
}