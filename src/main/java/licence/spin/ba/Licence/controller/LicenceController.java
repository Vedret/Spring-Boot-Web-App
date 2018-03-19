package licence.spin.ba.Licence.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import licence.spin.ba.Licence.Repository.CustomerRepository;

import licence.spin.ba.Licence.entity.Customer;
import licence.spin.ba.Licence.entity.Licence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class LicenceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerRepository customerRepository;
	

	
	
	/*@InitBinder("licence")
	    public void initBinder( WebDataBinder binder) {
		 
		System.out.println("Init Binderrr " +binder.getObjectName());
			try {
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				dateFormat.setLenient(false);
				binder.registerCustomEditor(Date.class, "pocetakTrajanjaLicence",
                        new CustomDateEditor(dateFormat, true));
				
				
			} catch (Exception e) {
				System.out.println("Catch bloookkk   ---------");
				e.printStackTrace();
			}
	    }*/
	
	@RequestMapping("/licence")
	public String licence(ModelMap model) {
		
		List<Customer> theCustomer= customerRepository.getCustomers();	
	
		Licence theLicence = new Licence();
		
		model.addAttribute("customer", theCustomer);
		model.addAttribute("licence", theLicence);
		
		for (int i = 0; i < theCustomer.size(); i++) {
			System.out.println("Print iz licencecee------------>>"+theCustomer.get(i));
		}
		
		return "licence";
	}
	

	
	@RequestMapping("/saveLicence")
	public String saveLicence(@RequestParam("customerid") String  customerid,@Valid @ModelAttribute("licence") Licence theLicence ,BindingResult result) {
		
		int id=Integer.parseInt(customerid);
		

		if(result.hasErrors()) {
			System.out.println("Greska " + result);
	            return "redirect:/licence";
	        }
		
		// save the customer using our service
		customerRepository.addLicenceForCustomer(theLicence,id);
		
		return "redirect:/licence";
	}
	
	

}
