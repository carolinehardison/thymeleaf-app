package com.thymeleaf.thymeleafapp.Exception;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super("Could not find Student");
    }
    public StudentNotFoundException(int id) {
        super("Could not find Student "+ id);
    }

}
