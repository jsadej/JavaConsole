package com.joanna;
import java.io.File;
import java.io.IOException;



/**
 * Created by jonna on 2016-05-05.
 */
public class Consola {
    private File currentDirectory = new File(System.getProperty("user.dir"));
    private String currentPrompt = "$";


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

        if (newCanonicalFile.exists()) {
            System.setProperty("user.dir", newCanonicalPath);
            currentDirectory = newCanonicalFile;
            System.out.print(currentDirectory);
        } else {
            System.out.print("No such directory: " + newCanonicalPath);
        }


    }

    public void customizePrompt(String prompt) throws IOException {

        if (prompt.equals("$cwd")) {
            System.out.print(currentDirectory.getCanonicalPath());
            currentPrompt = currentDirectory.getCanonicalPath();

        } else if (prompt.equals("reset")) {
            currentPrompt = "$";

        } else {
            currentPrompt = prompt;

        }

    }

    private static String getIndentString(int indent) {
        StringBuilder indent_sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            indent_sb.append("-");
        }
        return indent_sb.toString();
    }

    public void runTree() {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        System.out.print(displayTree(currentDirectory, indent, sb));

    }

    public String displayTree(File currentDirectory, int indent, StringBuilder sb) {
        if (!currentDirectory.isDirectory()) {
            throw new IllegalArgumentException(currentDirectory + " folder is not a Directory");
        }
        sb.append(getIndentString(indent));
        sb.append(currentDirectory.getName());
        sb.append(System.getProperty("line.separator"));
        for (File file : currentDirectory.listFiles()) {
            if (file.isDirectory()) {
                displayTree(file, indent + 1, sb);
            }

        }
        return sb.toString();
    }

}