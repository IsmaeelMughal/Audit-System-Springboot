package com.prototype.auditmanagemenetsystem.config;

import com.prototype.auditmanagemenetsystem.utils.Common;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class Config {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Common.CORS_ALLOWED_ORIGINS);
        corsConfiguration.setAllowedHeaders(Common.CORS_ALLOWED_HEADERS);
        corsConfiguration.setExposedHeaders(Common.CORS_EXPOSED_HEADERS);
        corsConfiguration.setAllowedMethods(Common.CORS_ALLOWED_METHODS);
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration(Common.CORS_CONFIGURATION_PATTERN, corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
