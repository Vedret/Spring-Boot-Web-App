package licence.spin.ba.Licence;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import licence.spin.ba.Licence.Repository.CustomerRepository;
import licence.spin.ba.Licence.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LicenceApplication.class)
public class LicenceApplicationTests {
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	CustomerRepository repository; 
	


	@Test
	@Transactional
	public void retrievLicenceForKorisnik() {
		System.out.println("TEST");
		
		Customer customer =repository.findById(1);
		System.out.println("Customer---->" + customer);
		//logger.info("{}",customer.getLicence());
	}
}
