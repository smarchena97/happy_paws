package co.edu.uniquindio.ingsoft3.HappyPaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HappyPawsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyPawsApplication.class, args);
	}


}
