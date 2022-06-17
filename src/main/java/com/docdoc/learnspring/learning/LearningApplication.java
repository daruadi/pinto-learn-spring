package com.docdoc.learnspring.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.docdoc.learnspring"})
@ImportResource("classpath:/link4IntegratingData/integration.xml")
@EnableJpaRepositories("com.docdoc.learnspring.link6")
@EntityScan("com.docdoc.learnspring.link6")
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

}
