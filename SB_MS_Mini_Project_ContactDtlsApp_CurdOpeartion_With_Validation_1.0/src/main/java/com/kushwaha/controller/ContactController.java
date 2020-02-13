package com.kushwaha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.kushwaha.doamin.Contact;
import com.kushwaha.service.ContactService;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 * @since 11-02-2020
 *
 */

@Controller
public class ContactController {

	@Autowired
	private ContactService contactservice;

	@RequestMapping("/register")
	public String showWelcomePage(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "Register";
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("contact")Contact contact, Model model) {
		boolean savedContact = contactservice.saveContact(contact);
		if (savedContact == true) {
			model.addAttribute("username", contact.getContactName());
			model.addAttribute("msg", "Your Contact Details Registration Successfully  Completed");
		} else {
			model.addAttribute("msg", "Contact Details Registration Is Failed");
		}
		return "Register";
	}

	@RequestMapping(value = "/getAllContacts", method = RequestMethod.GET)
	public String retriveAllActiveContact(Model model) {
		Iterable<Contact> allActiveContacts = contactservice.getAllActiveContacts();
		model.addAttribute("allActiveContacts", allActiveContacts);
		model.addAttribute("msg", "Contact Details Registration Is Successfully Completed");
		return "all_contacts";
	}

	public String updateContact(Contact contact, Model model) {

		/**
		 * Logic
		 */
		return "Welcome";
	}

	@RequestMapping(value = "/removeContact", method = RequestMethod.PUT)
	public String deleteContact(@RequestParam("contactId") Integer contactId, Model model) {
		boolean removedContact = contactservice.removeContact(contactId);
		if (removedContact == true) {
			model.addAttribute("msg", "Your Contact Details are Successfully Removed");
		} else {
			model.addAttribute("msg", "Your Contact Details Is Not Removed Because Of Some Technical Issue");
		}
		return "Register";
	}

}
