package com.joanna;

/**
 * Created by jonna on 2016-05-05.
 */
public class Consola {
     public void displayPrompt(){
         StringBuilder builder=new StringBuilder();
         builder.append(System.getProperty("line.separator")).append("$");
         String s=builder.toString();
         System.out.print(s);



 }
}
