package com.example.billing;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private BillingService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Billing> listBilling = service.listAll();
		model.addAttribute("listBilling", listBilling);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewBillingPage(Model model) {
		Billing billing = new Billing();
		model.addAttribute("Billing", billing);
		
		return "new_billing";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBilling(@ModelAttribute("billing") Billing billing) {
		service.save(billing);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditBillingPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_billing");
		Billing billing = service.get(id);
		mav.addObject("billing", billing);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBilling(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}

