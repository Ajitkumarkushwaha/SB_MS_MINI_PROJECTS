package com.kushwaha.service;

import com.kushwaha.entity.ContactDtlsEntity;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 * @since 2020
 * 
 *
 */

public interface ContactDtlsService {

	public String saveContact(ContactDtlsEntity entity);
	public String modifyContact(ContactDtlsEntity entity);

}
