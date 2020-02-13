package com.kushwaha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kushwaha.entity.ContactDtlsEntity;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 * @since 11-02-2020
 *
 */

public interface ContactRepository extends JpaRepository<ContactDtlsEntity, Integer>{
	
	@Query("SELECT C FROM ContactDtlsEntity C where C.activeSw='Y' ")
	public List<ContactDtlsEntity> getAllActiveContacts();
	
	@Query("UPDATE ContactDtlsEntity C  SET C.activeSw='N'  where C.contactId='contactId' ")
	public String removeContact(Integer contactId);

}
