package com.joanna;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jonna on 2016-05-05.
 */
public class Consola {
    File file = new File(".");
    String currentDirectory;


    public void displayPrompt() {
        StringBuilder builder = new StringBuilder();
        builder.append(System.getProperty("line.separator")).append("$");
        String s = builder.toString();
        System.out.print(s);
    }

    public void displayListWorkingDirectory() throws IOException {

        file.getAbsolutePath();
        File[] files = file.listFiles();
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
        currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
    }

    public void changeCurrentDir(String newPath) {

        //System.out.print(newPath);
        System.setProperty("user.dir", newPath);

    }
}