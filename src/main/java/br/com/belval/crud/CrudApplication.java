package br.com.belval.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args ) {
		SpringApplication.run(CrudApplication.class, args);
	}
	@GetMapping("/")
	public String olaMundo() {
		return "Ola Mundo!!";
	}
}	
