package com.manning.junitbook.ch08.web;

import java.io.InputStream;

public class WebClient2 {

    public String getContent(ConnectionFactory connectionFactory) {
        String workingContent;

        StringBuffer buffer = new StringBuffer();
        try (InputStream is = connectionFactory.getData()) {
            int count;
            while (-1 != (count = is.read())) {
                buffer.append(new String(Character.toChars(count)));
            }
            workingContent = buffer.toString();
        } catch (Exception e) {
            workingContent = null;
        }

        return workingContent;
    }
}
