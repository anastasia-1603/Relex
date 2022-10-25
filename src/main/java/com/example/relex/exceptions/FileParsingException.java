package com.example.relex.exceptions;

public class FileParsingException extends RuntimeException{

    public FileParsingException() {
        super("Incorrect format a numeric value");
    }
}
