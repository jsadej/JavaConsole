package com.joanna;

import java.io.IOException;

/**
 * Created by jonna on 2016-05-16.
 */
public interface InterfaceConsola {

    public void listWorkingDirectory() throws IOException;
    public void displayPrompt();
    public void displayCurrentWorkingDirectory();
    public void changeCurrentDir(String newPath) throws IOException ;
    public void customizePrompt(String prompt) throws IOException;
    public void runTree();
}
