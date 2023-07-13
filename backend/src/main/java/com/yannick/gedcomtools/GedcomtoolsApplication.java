package com.yannick.gedcomtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GedcomtoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GedcomtoolsApplication.class, args);
	}

}
