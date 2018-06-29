package licence.spin.ba.Licence;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.Bean;

import licence.spin.ba.Licence.Repository.CustomerRepository;


@SpringBootApplication

public class LicenceApplication extends SpringBootServletInitializer  {
	
	@Autowired
	CustomerRepository repository;
	
	private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LicenceApplication.class);

	}

	public static void main(String[] args) {
		SpringApplication.run(LicenceApplication.class, args);

	}
	
	@Bean
    public TomcatServletWebServerFactory tomcatEmbedded() {

		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });

        return tomcat;

    }
    
}
