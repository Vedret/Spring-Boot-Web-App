package licence.spin.ba.Licence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import licence.spin.ba.Licence.Repository.CustomerRepository;
import licence.spin.ba.Licence.entity.Customer;

@SpringBootApplication

public class LicenceApplication extends SpringBootServletInitializer  {
	
	@Autowired
	CustomerRepository repository;
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LicenceApplication.class);
        
        
    
	}

	public static void main(String[] args) {
		SpringApplication.run(LicenceApplication.class, args);
		
		
        
		
		
		
	}
}
