package licence.spin.ba.Licence;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private Path path;
	@Test
	@Transactional
	public void retrievLicenceForKorisnik() {
		
		
		String test="026_wedret123.txt";
		String test1=test.split("_")[0];
		System.out.println(test1);
		
		String skratiGa="E:\\MyDocuments\\Documents\\Licence\\src\\main\\webapp\\resources\\documents\\22.doc";
		String sss=skratiGa.substring(skratiGa.lastIndexOf("/"));
		System.out.println(sss);
		
	}
}
