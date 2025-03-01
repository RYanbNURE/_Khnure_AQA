package org.khnure.service;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class HeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        // Додавання загальних заголовків
        template.header("Accept", "application/json");
        template.header("Authorization", "Bearer some-token");
    }
}