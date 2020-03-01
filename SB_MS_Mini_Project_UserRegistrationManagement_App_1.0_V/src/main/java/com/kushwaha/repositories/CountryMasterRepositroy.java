package com.kushwaha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushwaha.entity.CountryMasterEntity;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

public interface CountryMasterRepositroy extends JpaRepository<CountryMasterEntity, Integer> {

}
