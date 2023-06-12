package com.yannick.gedcomtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GedcomtoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GedcomtoolsApplication.class, args);
	}
	
	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

}
