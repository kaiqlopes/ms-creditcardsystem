package com.studying.mscreditcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscreditcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscreditcardsApplication.class, args);
	}

}
