package licence.spin.ba.Licence.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import licence.spin.ba.Licence.Repository.CustomerRepository;
import licence.spin.ba.Licence.entity.Customer;
import licence.spin.ba.Licence.entity.Licence;


@Controller
public class LicenceController {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerRepository customerRepository;

	private Path path;

	@RequestMapping("/licence")
	public String licence(ModelMap model) {

		List<Customer> theCustomer = customerRepository.getCustomers();

		Licence theLicence = new Licence();

		model.addAttribute("customer", theCustomer);
		model.addAttribute("licence", theLicence);

		for (int i = 0; i < theCustomer.size(); i++) {
			System.out.println("Print iz licencecee------------>>" + theCustomer.get(i));
		}

		return "licence";
	}

	@PostMapping("/saveLicence")
	public String saveLicence(@RequestParam("customerid") String customerid,
			
		 @Valid @ModelAttribute("licence") Licence theLicence, 
			BindingResult result, HttpServletRequest request, 
			RedirectAttributes redirectAttributes)throws IOException {

		int id = Integer.parseInt(customerid);

		if (result.hasErrors()) {
			System.out.println("Greska " + result);
			return "redirect:/licence";
		}

		// save the customer using our service
		customerRepository.addLicenceForCustomer(theLicence, id);
		

		
		//Save document
		MultipartFile productImage = theLicence.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "resources\\documents\\" + theLicence.getId() + "_"
				+ productImage.getOriginalFilename());
		
		

		  if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
				redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded "); 
				System.out.println("Snimio fileeee????????");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed", e);
			}
		}
		 
		return "redirect:/licence";
	}
	



}
