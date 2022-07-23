package com.manning.junitbook.ch08.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestWebClient {

    @Test
    public void testGetContentOk() throws Exception {
        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
        MockInputStream mockInputStream = new MockInputStream();
        mockInputStream.setBuffer("It works");
        mockConnectionFactory.setData(mockInputStream);
        WebClient2 webClient2 = new WebClient2();
        String content = webClient2.getContent(mockConnectionFactory);

        Assertions.assertEquals("It works", content);
        mockInputStream.verify();
    }
}
