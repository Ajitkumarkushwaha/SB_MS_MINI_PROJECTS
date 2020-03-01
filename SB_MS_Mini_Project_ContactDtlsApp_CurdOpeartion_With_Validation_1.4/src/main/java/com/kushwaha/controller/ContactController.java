package com.kushwaha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kushwaha.doamin.Contact;
import com.kushwaha.service.ContactService;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.4
 * @since 13-02-2020
 *
 */

@Controller
public class ContactController {

	@Autowired 
	private ContactService contactservice;

	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	private static final String CONTACT_OBJ_KY = "contact";
	
	public ContactController() {
	logger.debug("Controller Class Is Initialized");
	}

	/**
	 * @author AJIT KUMAR 
	 * This Method Is Used For Load The Form
	 * This Method Will Be Called When User Make A Request By Using /register url
	 * @param model
	 * @return
	 */

	@RequestMapping("/register")
	public String showWelcomePage(Model model) {
		logger.debug("showWelcomePage(): Method Is Called With /register url");
		Contact c = new Contact();
		model.addAttribute(CONTACT_OBJ_KY, c);
		logger.info("Empty Contact(Domain) Class Object is Loaded");
		return "Register";
	}

	/**
	 * This Method Will be Called When Resource Not found(Wrong Url)
	 */
	@RequestMapping("/errorPage")
	public String showErrorPage() {
		logger.debug("showErrorPage(): Method Is Called");
		return "error";
	}

	/**
	 * @author AJIT KUMAR 
	 * This Method Will be Called When User Submit The Contact
	 *         Form
	 * 
	 * @param contact
	 * @param model
	 * @return
	 */
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute(CONTACT_OBJ_KY) Contact contact, RedirectAttributes attributes) {
		logger.debug("Contact Controller saveContact() Method Is Called ");
		boolean savedContact = contactservice.saveContact(contact);
		logger.debug("Contact Controller contactservice.saveContact() Method Is Called ");
		if (savedContact) {
			attributes.addFlashAttribute("successMsg", "Your Contact Details Registration Successfully  Completed :");
		} else {
			attributes.addFlashAttribute("errorMsg", "Contact Details Registration Is Failed");
			logger.error("Contact Details Registration is failed");
		}
		logger.debug("Contact Controller saveContact Method Is Called");
		return "redirect:/register";
	}

	/**
	 * 
	 * @author AJIT KUMAR 
	 * This Method Will Be Called When User Click On Get All
	 *         Contact
	 * 
	 * @param Model model
	 * @return
	 */

	@RequestMapping(value = "/getAllContacts")
	public String retriveAllActiveContact(Model model) {
		logger.debug("Contact Cntroller retriveAllActiveContact(): Method Is Called");
		Iterable<Contact> allActiveContacts = contactservice.getAllActiveContacts();
		logger.debug("Contact Controller contactservice.getAllActiveContacts(): Method Is Called");
		model.addAttribute(CONTACT_OBJ_KY, allActiveContacts);
		model.addAttribute("msg", "Contact Details Registration Is Successfully Completed");
		logger.info("Contact Controller retriveAllActiveContact(): Method Execution Is Complete");
		return "all_contacts";
	}

	/**
	 * 
	 * @author AJIT KUMAR 
	 * This Method Will Be Called When User will Click On EDIT
	 *         HyperLink
	 * 
	 * @param HttpServletRequest req
	 * @param Model              model
	 * @return
	 */

	@RequestMapping(value = "/getContactById")
	public String handleEditLink(@RequestParam("contactId")Integer contactId, Model model) {
		logger.debug("Contact Controller handleEditLink(): Method Is Called ");
		Contact c = contactservice.findByContactId(contactId);
		logger.debug("Contact Controller contactservice.findByContactId(): Method IS Called");
		model.addAttribute(CONTACT_OBJ_KY, c);
		logger.info("Contact Controller handleEditLink(): Method Execution Is Completed ");
		return "Register";
	}
	
	@RequestMapping(value = "/viewContactById")
	public String handleViewLink(@RequestParam("contactId")Integer contactId, Model model) {
		logger.debug("Contact Controller handleEditLink(): Method Is Called ");
		Contact c = contactservice.findByContactId(contactId);
		logger.debug("Contact Controller contactservice.findByContactId(): Method IS Called");
		model.addAttribute(CONTACT_OBJ_KY, c);
		logger.info("Contact Controller handleEditLink(): Method Execution Is Completed ");
		return "DetalViewPage";
	}
	
	/**
	 *
	 * @author AJIT KUMAR
	 * 
	 * This Method Will Be Called When User Will Click On DELETE Link
	 * 
	 * @param HttpServletRequest req
	 * @param Model model
	 * @return
	 */

	@RequestMapping(value = "/deleteContact")
	public String deleteContact(@RequestParam("contactId")Integer contactId, RedirectAttributes attributes) {
		logger.debug("Contact Controller deleteContact(): Method Is Called ");
		boolean removedContact = contactservice.removeContact(contactId);
		logger.debug("Contact Controller contactservice.removeContact(): Method Is Called ");
		if (removedContact) {
			attributes.addFlashAttribute("successMsg", "Your Contact Details  Successfully  Deleted");
		} else {
			attributes.addFlashAttribute("errorMsg", "Contact Details Deletion Is Failed");
		}
		logger.info("Contact Controller deleteContact(): Method Is Called ");
		return "redirect:/getAllContacts";
	}
	@RequestMapping(value = "/validateEmail")
	@ResponseBody
	public String validateUserEmail(@RequestParam("contactEmail")String contactEmail) {
		String validatedEmail = contactservice.validateEmail(contactEmail);
		return validatedEmail;
	}

}
