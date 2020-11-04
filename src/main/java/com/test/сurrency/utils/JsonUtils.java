package com.test.сurrency.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtils {

    public String makeJsonStringError(String error) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonError = mapper.createObjectNode();
        jsonError.put("error", error);
        return jsonError.toPrettyString();
    }
}
