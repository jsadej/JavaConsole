package com.joanna;

import java.io.File;
import java.io.IOException;


/**
 * Created by jonna on 2016-05-16.
 */
public class Consola {
    private File currentDirectory = new File(System.getProperty("user.dir"));
    private String currentPrompt = "$";
    private String command;

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setCurrentDirectory(File currentDirectory) {

        this.currentDirectory = currentDirectory;
    }

    public String getCurrentPrompt() {
        return currentPrompt;
    }

    public void setCurrentPrompt(String currentPrompt) {
        this.currentPrompt = currentPrompt;
    }

}
