package com.epam.ta.service;

public class ObtainingValidData {
    public static Integer castString (String string){
        String tmp = string;
        int startIndex = tmp.indexOf("0");
        int endIndex = tmp.length();
        String replacement = "0";
        String toBeReplaced = tmp.substring(startIndex + 1, endIndex);
        return Integer.parseInt(tmp.replace(toBeReplaced, replacement));
    }
    public static Integer quantity (String string){
        String tmp = string;
        int startIndex = tmp.indexOf(" ");
        int endIndex = tmp.length();
        String replacement = "";
        String toBeReplaced = tmp.substring(startIndex, endIndex);
        return Integer.parseInt(tmp.replace(toBeReplaced, replacement));
    }


}
