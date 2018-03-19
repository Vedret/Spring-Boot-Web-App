package licence.spin.ba.Licence.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import licence.spin.ba.Licence.Repository.CustomerRepository;
import licence.spin.ba.Licence.Repository.LicenceRepository;
import licence.spin.ba.Licence.entity.Customer;
import licence.spin.ba.Licence.entity.Licence;
import licence.spin.ba.Licence.view.PDFView;

@Controller
public class HomeController {

	@Autowired
	private CustomerRepository customerService;

	@Autowired
	private LicenceRepository licenceService;
	
	@RequestMapping("/")
	public String home ( ModelMap model) {

		//List em all 
		List<Customer> theCustomer = customerService.getAllLicence();

		/*  Test List
		for (Customer cust : theCustomer) {
			for (Licence lic : cust.getLicence()) {
				System.out.println(lic.getTipLicence());
			}
		}
		Test list */

		model.addAttribute("customer", theCustomer);

		return "home";
	}

	@RequestMapping("/delete")
	public String deleteKorisnik(@RequestParam("licenceId") int theId) {

		
		customerService.deleteLicence(theId);

		return "redirect:/";
	}

	@RequestMapping(value = "/showFormUpdate", method = RequestMethod.GET)
	public  String showFormUpdate(@RequestParam("licenceId") int theId, Model theModel) {

		// get licence byID from servis
		Licence theLicenca = customerService.getLicenceCustomer(theId);

		// set Licence as model to populate form
		theModel.addAttribute("theLicenca", theLicenca);
			
		System.out.println("Licence id je opaaaala --------->" + theLicenca);

		// return
		return "modal";
	}
	
	@RequestMapping(value="/update",method = RequestMethod.GET)
	public String updateLicence(@RequestParam("id") String  licenceid ,@ModelAttribute("licence") Licence theLicenca) {
		
		int id=Integer.parseInt(licenceid);
		//Iz nekog razloga objekat thelicence ne sadrzi id, zato moram setId rucno
		theLicenca.setId(id);
		licenceService.updateLicence(theLicenca,id);
		
		return "redirect:/";
		
	}
	
	
    @RequestMapping(value = "/details/pdf", method = RequestMethod.GET)
    public ModelAndView showPriceInPDF(@ModelAttribute("licenceId") int theId  ) {
                
    	List<Licence> theLicence = licenceService.getAllByIdForPDF(theId);
    		
    	for (Licence lic : theLicence) {			
			System.out.println("Tip licence jeee============="+lic.getCustName());
			}
    	Map<String, Object> model = new HashMap<>();
        model.put("theLicence", theLicence);
    	return new ModelAndView(new PDFView(),model);
    }
	
	
}
