package com.manning.junitbook.ch02.assumptions.environment;

public class JavaSpecification {
    private String version;

    public JavaSpecification(String version) {
        this.version = version;
    }

    String getVersion() {
        return version;
    }
}
