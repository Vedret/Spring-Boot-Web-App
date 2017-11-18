package licence.spin.ba.Licence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import licence.spin.ba.Licence.Repository.CustomerRepository;
import licence.spin.ba.Licence.entity.Customer;

@Controller
public class LicenceController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@RequestMapping("licence")
	public String licence(Model model) {
		
		List<Customer> theCustomer= customerRepository.getCustomers();
		
		model.addAttribute("customer", theCustomer);
		return "licence";
	}

}
