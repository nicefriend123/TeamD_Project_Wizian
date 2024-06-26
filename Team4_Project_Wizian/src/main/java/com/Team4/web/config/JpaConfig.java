package com.Team4.web.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.Team4.web.entity")
public class JpaConfig {
    // JPA 설정 추가할 수 있음
}
