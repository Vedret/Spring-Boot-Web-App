package licence.spin.ba.Licence.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
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
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;

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
	private Path path;

	// HOME
	@RequestMapping("/home")
	public String home(ModelMap model) {

		// List em all
		List<Customer> theCustomer = customerService.getAllLicence();

		/*
		 * Test List for (Customer cust : theCustomer) { for (Licence lic :
		 * cust.getLicence()) { System.out.println(lic.getTipLicence()); } } Test list
		 */

		model.addAttribute("customer", theCustomer);

		return "home";
	}

	// Controller, Obrisi
	@RequestMapping("/delete")
	public String deleteKorisnik(@RequestParam("licenceId") int theId, HttpServletRequest request) throws IOException {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		String id = Integer.toString(theId);
		String putanja = dajDocument(id, rootDirectory);
		path = Paths.get(putanja);

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		customerService.deleteLicence(theId);

		return "redirect:/home";
	}

	// MODAL ,Prikazi formu za update korisnika i licenci
	@RequestMapping(value = "/showFormUpdate", method = RequestMethod.GET)
	public String showFormUpdate(@RequestParam("licenceId") int theId, Model theModel) {

		// get licence byID from servis
		Licence theLicenca = customerService.getLicenceCustomer(theId);

		// set Licence as model to populate form
		theModel.addAttribute("theLicenca", theLicenca);

		System.out.println("Licence id je opaaaala --------->" + theLicenca);

		// return
		return "modal";
	}

	// Update controlerr
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateLicence(@RequestParam("id") String licenceid, @ModelAttribute("licence") Licence theLicenca) {

		int id = Integer.parseInt(licenceid);
		// Iz nekog razloga objekat thelicence ne sadrzi id, zato moram setId rucno
		theLicenca.setId(id);
		licenceService.updateLicence(theLicenca, id);

		return "redirect:/home";

	}

	// Download OLP documents by ID
	@RequestMapping(value = "/downloadDoc", method = RequestMethod.GET)
	public StreamingResponseBody getSteamingFile(@RequestParam("licenceId") int theId, HttpServletResponse response,
			HttpServletRequest request) throws IOException {

		String id = Integer.toString(theId);
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		String putanja = dajDocument(id, rootDirectory);

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Disposition",
				"attachment; filename=" + putanja.substring(putanja.lastIndexOf("\\")));
		InputStream inputStream = new FileInputStream(new File(putanja));

		return outputStream -> {
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				outputStream.write(data, 0, nRead);
			}
			inputStream.close();
		};
	}

	// Kreiraj PDF
	@RequestMapping(value = "/details/pdf", method = RequestMethod.GET)
	public ModelAndView showPriceInPDF(@ModelAttribute("licenceId") int theId) {

		List<Licence> theLicence = licenceService.getAllByIdForPDF(theId);

		for (Licence lic : theLicence) {
			System.out.println("Tip licence jeee=============" + lic.getCustName());
		}
		Map<String, Object> model = new HashMap<>();
		model.put("theLicence", theLicence);
		return new ModelAndView(new PDFView(), model);
	}

	//funkcija  Vrati putanju i ime dokumenta 
	public String dajDocument(String id, String rootDirectory) {

		String putanja = null;
		path = Paths.get(rootDirectory + "resources\\documents\\");

		File root = new File(rootDirectory + "resources\\documents\\");
		FilenameFilter beginswithm = new FilenameFilter() {
			public boolean accept(File directory, String filename) {
				return filename.startsWith(id);
			}
		};

		// Svi koji pocinju sa id
		File[] files = root.listFiles(beginswithm);
		for (File f : files) {
			putanja = f.toString();
		}

		return putanja;
	}

}
