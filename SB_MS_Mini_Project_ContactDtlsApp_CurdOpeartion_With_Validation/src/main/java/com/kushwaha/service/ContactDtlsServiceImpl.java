/*
package com.kushwaha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
/*
@Service
public class ContactDtlsServiceImpl implements ContactDtlsService{

	@Autowired
	private ContactDtlsRepository contactRepository;

	@Override
	public String saveContact(ContactDtlsEntity entity) {
		ContactDtlsEntity savedContact = contactRepository.save(entity);
		return "Contact Details Are Saved" + savedContact;
	}

	public List<ContactDtlsEntity> getAllContacts() {
		List<ContactDtlsEntity> allContacts = contactRepository.getAllContacts();
		return allContacts;
	}

	@Override
	public String modifyContact(ContactDtlsEntity entity) {
		ContactDtlsEntity updatedContact = contactRepository.save(entity);
		return "Contact Details Are Modified" + updatedContact;
	}
	public void removeContact(Integer contactId) {
		contactRepository.removeContact(contactId);
	}

}
*/