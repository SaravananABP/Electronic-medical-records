package electronic.medical.records;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class medicalRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(medicalRecordsApplication.class, args);
	}

}
