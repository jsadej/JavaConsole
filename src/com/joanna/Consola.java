package com.joanna;
import java.io.File;
import java.io.IOException;

/**
 * Created by jonna on 2016-05-05.
 */
public class Consola {
    String currentDirectory;

    public void displayPrompt() {
        StringBuilder builder = new StringBuilder();
        builder.append(System.getProperty("line.separator")).append("$");
        String s = builder.toString();
        System.out.print(s);
    }

    public void showWorkingDirectory() throws IOException {
        File file = new File(".");
        currentDirectory = file.getAbsolutePath();
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

}
