package com.test.сurrency.config;

import com.test.сurrency.rest.RestClient;
import com.test.сurrency.utils.JsonUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultBeanConfiguration {

    @Bean
    public RestClient restClient() {
        return new RestClient();
    }

    @Bean
    public JsonUtils jsonUtils() {
        return new JsonUtils();
    }
}
