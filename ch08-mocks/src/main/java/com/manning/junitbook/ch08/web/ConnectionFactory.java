package com.manning.junitbook.ch08.web;

import java.io.InputStream;

public interface ConnectionFactory {
    InputStream getData() throws Exception;
}
