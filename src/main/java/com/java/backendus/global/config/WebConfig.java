package com.java.backendus.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		WebMvcConfigurer.super.addCorsMappings(registry);
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:5173") // 허용할 출처
			.allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
			.allowedHeaders("*") // 허용할 헤더
			.allowCredentials(true); // 자격 증명 허용
	}

}

