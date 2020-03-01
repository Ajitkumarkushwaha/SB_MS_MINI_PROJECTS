package com.kushwaha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushwaha.entity.UserAccountEntity;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Integer> {

	public UserAccountEntity findByEmail(String email);

	public UserAccountEntity findByPassword(String password);
}
