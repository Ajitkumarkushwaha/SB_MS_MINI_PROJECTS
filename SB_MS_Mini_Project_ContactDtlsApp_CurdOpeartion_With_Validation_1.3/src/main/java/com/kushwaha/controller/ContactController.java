package com.kushwaha.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kushwaha.doamin.Contact;
import com.kushwaha.service.ContactService;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.2
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
	public String saveContact(@ModelAttribute("contact") Contact contact, Model model) {
		boolean savedContact = contactservice.saveContact(contact);
		if (savedContact == true) {
			model.addAttribute("username", contact.getContactName());
			model.addAttribute("successMsg", "Your Contact Details Registration Successfully  Completed");
		} else {
			model.addAttribute("errorMsg", "Contact Details Registration Is Failed");
		}
		return "Register";
	}

	@RequestMapping(value = "/getAllContacts")
	public String retriveAllActiveContact(Model model) {
		Iterable<Contact> allActiveContacts = contactservice.getAllActiveContacts();
		model.addAttribute("contact", allActiveContacts);
		model.addAttribute("msg", "Contact Details Registration Is Successfully Completed");
		return "all_contacts";
	}
	@RequestMapping(value = "/getAllDeactiveContacts")
	public String retriveAllDeActiveContact(Model model) {
		Iterable<Contact> allDeActiveContacts = contactservice.getAllDeActiveContacts();
		model.addAttribute("deactivecontact", allDeActiveContacts);
		model.addAttribute("msg", "Contact Details Registration Is Successfully Completed");
		return "all_contacts";
	}

	@RequestMapping(value = "/getContactById")
	public String handleEditLink(HttpServletRequest req, Model model) {
		String cid = req.getParameter("contactId");
		Contact c = contactservice.findByContactId(Integer.parseInt(cid));
		model.addAttribute("contact", c);
		return "Register";
	}

	@RequestMapping(value = "/deleteContact")
	public String deleteContact(HttpServletRequest req, Model model) {
		String cid = req.getParameter("contactId");
		boolean removedContact = contactservice.removeContact(Integer.parseInt(cid));
		if (removedContact == true) {
			model.addAttribute("successMsg", "Your Contact Details  Successfully  Deleted");
		} else {
			model.addAttribute("errorMsg", "Contact Details Deletion Is Failed");
		}
		return "all_contacts";
	}

}
