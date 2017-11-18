package licence.spin.ba.Licence.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import licence.spin.ba.Licence.entity.Customer;
import licence.spin.ba.Licence.entity.Licence;

@Repository
@Transactional
public class CustomerRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Customer> getCustomers() {
		List<Customer> listCutomers = 
		em.createQuery("SELECT e FROM Customer e").getResultList();

		return listCutomers;
	}
	
	public Customer findById(int id) {
		
		
		return em.find(Customer.class,id);
	}
	
	public Customer saveCustomer(Customer customer) {
		
		if(customer==null) {
			em.persist(customer);
		}else {
			em.merge(customer);
		}
		return customer;
	}
	
	public void deleteById(int id) {
		
		Customer customer=findById(id);
		em.remove(customer);
	}
	
	public void addLicenceForCustomer(Licence licence , int id) {
		
		//get customer by id
		Customer customer=findById(id);
		
		//setting relationship
		customer.addLicence(licence);
		licence.setCustomer(customer);
		//save to db
		em.persist(licence);		
	}
	
	

}
