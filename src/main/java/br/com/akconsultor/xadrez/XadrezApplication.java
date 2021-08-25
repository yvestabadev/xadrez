package br.com.akconsultor.xadrez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class XadrezApplication {

	public static void main(String[] args) {
		SpringApplication.run(XadrezApplication.class, args);
	}

}
