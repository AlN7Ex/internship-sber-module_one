package ru.sber.internship.exception;

public class InvalidDataStructureException extends Exception {
    public InvalidDataStructureException(String msg) {
        super("Wrong structure of input data in file. Error in #" + msg + " row.");
    }
}
