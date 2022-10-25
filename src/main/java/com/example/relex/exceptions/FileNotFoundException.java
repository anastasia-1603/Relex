package com.example.relex.exceptions;

public class FileNotFoundException extends RuntimeException{

    public FileNotFoundException() {
        super("File not found");
    }
}
