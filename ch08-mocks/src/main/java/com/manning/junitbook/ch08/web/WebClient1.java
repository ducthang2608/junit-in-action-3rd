package com.manning.junitbook.ch08.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient1 {
    public String getContent(URL url) {
        StringBuffer buffer = new StringBuffer();

        try {
            HttpURLConnection connection = createConnection(url);
            InputStream is = connection.getInputStream();
            int count;

            while (-1 != (count = is.read())) {
                buffer.append(new String(Character.toChars(count)));
            }
        } catch (IOException e) {
            return null;
        }

        return buffer.toString();
    }

    private HttpURLConnection createConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
