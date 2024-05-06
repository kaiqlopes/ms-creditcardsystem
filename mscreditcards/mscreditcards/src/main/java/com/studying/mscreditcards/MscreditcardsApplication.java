package com.studying.mscreditcards;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class MscreditcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscreditcardsApplication.class, args);
	}

}
