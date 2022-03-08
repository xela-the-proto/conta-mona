package com.xela;

public class FileException extends Exception{
    private String matter;

    public FileException(String matter){
        this.matter = matter;
    }

    public String getMatter() {
        return matter;
    }
}