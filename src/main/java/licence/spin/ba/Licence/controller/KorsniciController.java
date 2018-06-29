package licence.spin.ba.Licence.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import licence.spin.ba.Licence.Repository.CustomerRepository;
import licence.spin.ba.Licence.entity.Customer;

@Controller
public class KorsniciController {
	
	@Autowired
	private CustomerRepository customerService;
	
	@RequestMapping("/korisnici")
	public String korisnici(ModelMap model) {
		
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		return "korisnici";
		
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult result) {
		
		 if(result.hasErrors()) {
	            return "korisnici";
	        }
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);	
		
		return "redirect:korisnici";
	}

}
