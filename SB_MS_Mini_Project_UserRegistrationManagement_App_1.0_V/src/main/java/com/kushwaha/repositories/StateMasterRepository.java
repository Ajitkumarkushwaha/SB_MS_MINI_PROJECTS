package com.kushwaha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushwaha.entity.StateMasterEntity;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

public interface StateMasterRepository extends JpaRepository<StateMasterEntity, Integer> {

	public List<StateMasterEntity> findByCountryId(Integer countryId);
}
