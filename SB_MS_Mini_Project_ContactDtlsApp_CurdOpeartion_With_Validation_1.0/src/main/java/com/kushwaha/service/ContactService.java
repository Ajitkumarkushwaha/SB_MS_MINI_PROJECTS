package com.kushwaha.service;

import com.kushwaha.doamin.Contact;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 * @since 11-02-2020
 *
 */


public interface ContactService {
	
	public boolean saveContact(Contact contact);
	public Iterable<Contact> getAllActiveContacts();
	public Contact findByContactId(Integer contactId);
	public boolean updateContact(Contact contact);
	public boolean removeContact(Integer contactId);

}
