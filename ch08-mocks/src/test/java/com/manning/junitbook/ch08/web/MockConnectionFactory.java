package com.manning.junitbook.ch08.web;

import java.io.InputStream;

public class MockConnectionFactory implements ConnectionFactory {

    private InputStream inputStream;

    @Override
    public InputStream getData() throws Exception {
        return inputStream;
    }

    public void setData(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
