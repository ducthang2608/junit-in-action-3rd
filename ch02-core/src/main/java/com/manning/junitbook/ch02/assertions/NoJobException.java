package com.manning.junitbook.ch02.assertions;

public class NoJobException extends RuntimeException {
    NoJobException(String message) {
        super(message);
    }
}
