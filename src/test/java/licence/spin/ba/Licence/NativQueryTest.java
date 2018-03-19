package licence.spin.ba.Licence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import licence.spin.ba.Licence.Repository.CustomerRepository;
import licence.spin.ba.Licence.entity.Customer;
import licence.spin.ba.Licence.entity.Licence;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LicenceApplication.class)
public class NativQueryTest {
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	CustomerRepository repository; 
	
	@Autowired
	EntityManager em;


	@Test
	
	public void nativeQueryBasic() {
		
		Query query = em.createNativeQuery("SELECT * FROM LICENCE WHERE ID=?",Licence.class);
		query.setParameter(1, 1);
		List resultList=query.getResultList();
		logger.info("Select * from Licence -> []",resultList);
		
		
	}
	
	
	@Test
	public void  getAllByID() {
		
		Query query = em.createNativeQuery("SELECT * FROM licence WHERE ID=?",Licence.class);
		query.setParameter(1, 11);
		List<Licence> theLicence=query.getResultList();
		
		
		
		
		
		List<Licence> theLicence1 = 
				em.createQuery("SELECT e FROM Licence e where ID=? ",Licence.class).setParameter(1, 11).getResultList();
		for (Licence lic : theLicence1) {
			
			System.out.println("Tip licence jeee============="+lic.getCustName());
			}
	
	}
}
	

