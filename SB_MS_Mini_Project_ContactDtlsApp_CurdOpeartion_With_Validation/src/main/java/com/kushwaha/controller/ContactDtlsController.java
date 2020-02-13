package com.kushwaha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kushwaha.entity.ContactDtlsEntity;
import com.kushwaha.repository.ContactDtlsRepository;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 * @since 2020
 * 
 *
 */

@Controller
public class ContactDtlsController {

	@Autowired
	private ContactDtlsRepository contactRepository;

	@RequestMapping("/register")
	public String showPage() {
		return "Register";
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContactDetails(ContactDtlsEntity entity, Model model) {
		entity.setActiveSw("Y");
		ContactDtlsEntity savedContact = contactRepository.save(entity);
		if(savedContact.getContactId()!=null) {
			model.addAttribute("username", savedContact.getContactName());
			model.addAttribute("msg", "Contact Details Are Successfully Completed");
		}
		else {
			model.addAttribute("msg", "Contact Details Registration Are Failed");
		}
		return "Register";
	}

	@RequestMapping("/getAllContacts")
	public String getAllContacts(Model model) {
		List<ContactDtlsEntity> list = contactRepository.getAllContacts();
		model.addAttribute("list", list);
		return "all_contacts";
	}

	@RequestMapping(value= "/modifyContact", method = RequestMethod.PUT)
	public String modifyContacts(ContactDtlsEntity entity, Model model) {
		ContactDtlsEntity modifiedContact = contactRepository.save(entity);
		if (modifiedContact.getContactId()!=null) {
			model.addAttribute("username", modifiedContact.getContactName());
			model.addAttribute("msg", "Contact Details Updation Are Successfully Completed");
		} else {
			model.addAttribute("msg", "Contact Details Updation Are Failed");
		}
		return "redirect:saveContact";
	}

	@RequestMapping(value= "/removeContact", method= RequestMethod.PUT)
	public String removeContactsDetails(@RequestParam("conatctId") Integer contactId, Model model) {
		String removedContact = contactRepository.removeContact(contactId);
		if (removedContact == null) {
			model.addAttribute("msg", "Contact Details Are Failed to Delete");
		} else {
			model.addAttribute("msg", "Contact Details  Successfully Deleted");
		}
		return "redirect:saveContact";
	}
}
