package com.kushwaha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushwaha.entity.CityMasterEntity;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

public interface CityMasterRepository extends JpaRepository<CityMasterEntity, Integer> {
	public List<CityMasterEntity> findByStateId(Integer stateId);
}
