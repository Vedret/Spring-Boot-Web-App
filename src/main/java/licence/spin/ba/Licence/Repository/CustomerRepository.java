package licence.spin.ba.Licence.Repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import licence.spin.ba.Licence.entity.Customer;
import licence.spin.ba.Licence.entity.Licence;

@Repository
@Transactional
public class CustomerRepository {
	
	@PersistenceContext
	EntityManager em;
	
	
	//get all customers 
	public List<Customer> getCustomers() {
		List<Customer> listCutomers = 
		em.createQuery("SELECT e FROM Customer e").getResultList();
		
		return listCutomers;
		}
	
	//Find customer by id
	public Customer findById(int id) {
				
		return em.find(Customer.class,id);
	}
	
	//Save Customer
	public Customer saveCustomer(Customer customer) {
		
		if(customer==null) {
			em.persist(customer);
		}else {
			em.merge(customer);
		}
		return customer;
	}
	
	//delete customer by id
	public Customer deleteById(int id) {
		
		Customer customer=findById(id);
		em.remove(customer);
		return customer;
	}
	
	//Add licence for customer by id
	public void addLicenceForCustomer(Licence licence , int id) {
		
		//get customer by id
		Customer customer=findById(id);
		
		//setting relationship
		customer.addLicence(licence);
		licence.setCustomer(customer);
		//save to db
		em.persist(licence);		
	}
	
	//Get All licence
	public List<Customer> getAllLicence() {
		List<Customer> listEmAllLicence = 
		em.createQuery("SELECT e FROM Customer e ").getResultList();

		
		return listEmAllLicence;
	}
	
	

	//Find licence by id
    public Licence findLicenceById(int id) {

		return em.find(Licence.class,id);
	}
	
    //Delete licence by id
	public void deleteLicence(int theId) {
		
		Licence licence=findLicenceById(theId);
		em.remove(licence);	
	}
 
	public Licence getLicenceCustomer(int theId) {

			return em.find(Licence.class,theId);
	}
	
	

	

}
