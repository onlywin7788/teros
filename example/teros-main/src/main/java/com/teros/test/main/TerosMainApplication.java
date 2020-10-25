package com.teros.test.main;

import com.teros.test.main.component.RunTest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TerosMainApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TerosMainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RunTest t = new RunTest();
		t.execute();
	}
}
