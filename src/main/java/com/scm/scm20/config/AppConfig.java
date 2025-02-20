package com.scm.scm20.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfig {

    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", "dze09jdsb",
                        "api_key", "935275564326951",
                        "api_secret", "jq-xnW1IedaLup2dWu3UfU7FPQ8"));
    }

}
