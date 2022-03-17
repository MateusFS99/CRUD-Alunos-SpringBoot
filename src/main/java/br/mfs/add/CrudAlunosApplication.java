package br.mfs.add;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CrudAlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAlunosApplication.class, args);
	}
}
