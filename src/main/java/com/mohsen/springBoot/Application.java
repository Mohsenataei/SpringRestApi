package com.mohsen.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		Object obj = new String[]{"one","two","three"};
		for (String s : (String[])obj){
			System.out.print(s + ",");
		}
	}

}
