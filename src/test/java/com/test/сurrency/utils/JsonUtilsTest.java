package com.test.сurrency.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonUtilsTest {

    @Autowired
    private JsonUtils jsonUtils;

    @Test
    void makeJsonStringError() {
        String expectedError = "{\n" +
        "  \"error\" : \"Funny error\"\n" +
        "}";
        String actualError = jsonUtils.makeJsonStringError("Funny error");
        assertEquals(expectedError, actualError);
    }
}