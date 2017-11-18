package licence.spin.ba.Licence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("licence.spin.ba")

public class LicenceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(LicenceApplication.class, args);
		
	}
}
