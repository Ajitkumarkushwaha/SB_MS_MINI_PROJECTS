package com.kushwaha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kushwaha.doamin.Contact;
import com.kushwaha.entity.ContactDtlsEntity;
import com.kushwaha.repository.ContactRepository;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 * @since 11-02-2020
 *
 */

@Service
public class ContactserviceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity savedContact = contactRepository.save(entity);
		return savedContact.getContactId() != null;
	}

	@Override
	public Iterable<Contact> getAllActiveContacts() {
		List<ContactDtlsEntity> allContacts = contactRepository.getAllActiveContacts();
		List<Contact> contactList = new ArrayList<>();
		for (ContactDtlsEntity contactEntity : allContacts) {

			Contact contact = new Contact();
			BeanUtils.copyProperties(contactEntity, contact);
			contactList.add(contact);
		}
		return contactList;
	}

	@Override
	public Contact findByContactId(Integer contactId) {

		Optional<ContactDtlsEntity> contactById = contactRepository.findById(contactId);
		if (contactById.isPresent()) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(contactById, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		contact.setActiveSw("Y");
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity updatedContact = contactRepository.save(entity);
		return updatedContact != null;
	}

	@Override
	public boolean removeContact(Integer contactId) {
		contactRepository.removeContact(contactId);
		return true;
	}

}
