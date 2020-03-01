package com.kushwaha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kushwaha.entity.ContactDtlsEntity;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.4
 * @since 13-02-2020
 *
 */

public interface ContactRepository extends JpaRepository<ContactDtlsEntity, Integer>{
	
	@Query("SELECT C FROM ContactDtlsEntity C where C.activeSw='Y' ")
	public List<ContactDtlsEntity> getAllActiveContacts();
	@Query("SELECT C FROM ContactDtlsEntity C where C.activeSw='N' ")
	public List<ContactDtlsEntity> getAllDeActiveContacts();
	
	@Transactional
	@Modifying
	@Query("UPDATE ContactDtlsEntity C  SET C.activeSw='N'  where C.contactId=:contactId ")
	public void removeContact(Integer contactId);
	
	public ContactDtlsEntity findByContactEmail(String contactEmail);

}
