package com.kushwaha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kushwaha.doamin.Contact;
import com.kushwaha.entity.ContactDtlsEntity;
import com.kushwaha.repository.ContactRepository;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.4
 * @since 13-02-2020
 * @see ContactService
 *
 */

@Service
public class ContactserviceImpl implements ContactService {

	private static Logger logger = LoggerFactory.getLogger(ContactserviceImpl.class);

	@Autowired
	private ContactRepository contactRepository;

	public ContactserviceImpl() {
	logger.info("Service Class Is Initialized");
	}
	
	/**
	 * @author AJIT KUMAR
	 * @param Contact contact(Domain Class Object)
	 * @return
	 */
	
	@Override
	public boolean saveContact(Contact contact) {
		logger.debug("Contact Service saveContact(): Method Is Called");
		contact.setActiveSw("Y");
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity savedContact = contactRepository.save(entity);
		logger.debug("Contact Repository save(): Method Is Called ");
		logger.info("Contact Service saveContact(): Method Is Completed");
		return savedContact.getContactId() != null;

	}
	
	/**
	 * @author AJIT KUMAR
	 * @param NONE
	 * @return This Method Will Return  If Record Is Inserted  Then true OtherWise false .
	 */

	@Override
	public Iterable<Contact> getAllActiveContacts() {
		logger.debug("Contact Service getAllActiveContacts(): Method Is Called");
		List<ContactDtlsEntity> allContacts = contactRepository.getAllActiveContacts();
		List<Contact> contactList = new ArrayList<>();
		for (ContactDtlsEntity contactEntity : allContacts) {

			Contact contact = new Contact();
			BeanUtils.copyProperties(contactEntity, contact);
			contactList.add(contact);
		}
		logger.debug("Contact Repsitory getAllContact(): Custom Method Is Called");
		logger.info("Contact Service getAllActiveContacts(): Method Is Completed");
		return contactList;
	}

	/**
	 * @author AJIT KUMAR
	 * @param contactId
	 * @return This Method Will Return Contact Object Based On contactId
	 */ 
	
	@Override
	public Contact findByContactId(Integer contactId) {
		logger.debug("Contact Service findByContactId(): Method Is Called");
		Optional<ContactDtlsEntity> contactById = contactRepository.findById(contactId);
		if (contactById.isPresent()) {
			ContactDtlsEntity contactDtlsEntity = contactById.get();
			Contact contact = new Contact();
			BeanUtils.copyProperties(contactDtlsEntity, contact);
			return contact;
		}
		logger.debug("Contact Repsitory findByContactId: Custom Method Is Called");
		logger.info("Contact Service findByContactId(): Method Is Completed");
		return null;
	}

	/**
	 * @author AJIT KUMAR
	 * @param Contact contact(Domain Class Object)
	 * @return This Method Will Return  If Record Is Updated  Then true OtherWise false .
	 */
	@Override
	public boolean updateContact(Contact contact) {
		logger.debug("Contact Service updateContact(): Method Is Completed");
		contact.setActiveSw("Y");
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity updatedContact = contactRepository.save(entity);
		logger.debug("Contact Repsitory save: Method Is Called");
		logger.info("Contact Service updateContact(): Method Is Completed");
		return updatedContact != null;
	}

	/**
	 * @author AJIT KUMAR
	 * @param contactId
	 * @return This Method Will Return,  If Record Is Deleted Based On contactId Then true OtherWise false .
	 */
	@Override
	public boolean removeContact(Integer contactId) {
		logger.debug("Contact Service removeContact(): Method Is Completed");
		contactRepository.removeContact(contactId);
		logger.debug("Contact Repsitory removeContact(): Method Is Called");
		logger.info("Contact Service removeContact(): Method Is Completed");
		return true;
	}
	
	@Override
	public String validateEmail(String contactEmail) {
		ContactDtlsEntity cEmail = contactRepository.findByContactEmail(contactEmail);
		if(cEmail!=null) {
			return "DUPLICATE";
		}
		return "UNIQUE";
	}

}
