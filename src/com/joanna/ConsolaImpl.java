package com.joanna;
import java.io.File;
import java.io.IOException;




/**
 * Created by jonna on 2016-05-05.
 */
public class ConsolaImpl implements InterfaceConsola{

   Consola c=new Consola();
    public void displayPrompt() {
        StringBuilder builder = new StringBuilder();
        builder.append(c.getCurrentPrompt()).append(" ");

        String s = builder.toString();
        System.out.print(s);
    }



    public void displayCurrentWorkingDirectory() {
        System.out.println(c.getCurrentDirectory());
    }

    public void changeCurrentDir(String newPath) throws IOException {

        File NewFilePath = new File(newPath);
        // used to check if exist
        File newCanonicalFile = NewFilePath.getCanonicalFile();
        // used to set proper new user.dir
        String newCanonicalPath = NewFilePath.getCanonicalPath();

        if (newCanonicalFile.exists()) {
            System.setProperty("user.dir", newCanonicalPath);
            c.setCurrentDirectory(newCanonicalFile);
            System.out.print(c.getCurrentDirectory());
        } else {
            System.out.print("No such directory: " + newCanonicalPath);
        }


    }

    public void customizePrompt(String prompt) throws IOException {

        if (prompt.equals("$cwd")) {
            System.out.print(c.getCurrentDirectory().getCanonicalPath());
            c.setCurrentPrompt(c.getCurrentDirectory().getCanonicalPath());

        } else if (prompt.equals("reset")) {
            c.setCurrentPrompt("$");

        } else {
            c.setCurrentPrompt( prompt);

        }

    }
    public void listWorkingDirectory() throws IOException {
        File[] files = c.getCurrentDirectory().listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.print("Dir:");
            } else {
                System.out.print("File:");
            }
            System.out.println(f.getName());
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
        System.out.print(displayTree(c.getCurrentDirectory(), indent, sb));

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