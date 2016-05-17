package com.joanna;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by jonna on 2016-05-05.
 */
public class ConsolaImpl implements InterfaceConsola {
    private boolean done = false;
    Consola c = new Consola();

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public void displayPrompt() {
        StringBuilder builder = new StringBuilder();
        builder.append(c.getCurrentPrompt()).append(" ");
        String s = builder.toString();
        System.out.print(s);
    }

    @Override
    public void displayCurrentWorkingDirectory() {
        System.out.println(c.getCurrentDirectory());
    }

    @Override
    public void changeCurrentDir(String newPath) {
        try {
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
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void customizePrompt(String prompt) {
        try{

        if (prompt.equals("$cwd")) {
            c.setCurrentPrompt(c.getCurrentDirectory().getCanonicalPath() + ">");

        } else if (prompt.equals("reset")) {
            c.setCurrentPrompt("$>");

        } else {
            c.setCurrentPrompt(prompt + ">");

        }
    }catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
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

    @Override
    public void runTree() {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        System.out.print(displayTree(c.getCurrentDirectory(), indent, sb));
    }

    @Override
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

    @Override
    public void SetandRun(String command) throws IOException {

        String pattern = "(^cd)(\\s)(.*)";
        String patternPrompt = "(^prompt)(\\s)(.*)";
        Pattern r = Pattern.compile(pattern);
        Pattern rPrompt = Pattern.compile(patternPrompt);
        Matcher m = r.matcher(command);
        Matcher mprompt = rPrompt.matcher(command);
        if (command.equals("dir")) {
            displayCurrentWorkingDirectory();
            try {
                listWorkingDirectory();
            } catch (IOException e) {
                e.printStackTrace();
            }
            displayPrompt();

        } else if (command.equals("tree")) {
            runTree();
            displayPrompt();

        } else if (m.matches()) {
            changeCurrentDir(m.group(3));
            displayPrompt();

        } else if (mprompt.matches()) {
            customizePrompt(mprompt.group(3));
            displayPrompt();

        } else if (command.equals("exit")) {
            System.out.print("Bye");
            setDone(true);
            isDone();

        } else if (command.isEmpty()) {
            displayPrompt();

        } else {
            System.out.print("Unknown command");
            displayPrompt();
        }
    }
}