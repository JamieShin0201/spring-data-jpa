package stury.datajpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 스프링 부트 사용시 생략 가능
 */
@Configuration
@EnableJpaRepositories(basePackages = "stury.datajpa.repository")
public class AppConfig {
}
