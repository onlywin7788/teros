package com.teros.data_service;

import com.teros.data_service.service.executor.ExecutorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Application implements CommandLineRunner {
	private final ExecutorService executorService;

	public Application(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		String configPath ="/opt/config/config.json";
		executorService.execute(configPath);
	}
}
