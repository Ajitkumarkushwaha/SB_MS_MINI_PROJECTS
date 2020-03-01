package com.kushwaha.service;

import java.util.Map;

import com.kushwaha.domain.UnlockAccount;
import com.kushwaha.domain.UserAccount;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

public interface UserAccountManagementService {

	public Map<Integer, String> getAllCountries();

	public Map<Integer, String> findAllByCountryId(Integer countryId);

	public Map<Integer, String> findAllByStateId(Integer stateId);

	public String validateEmail(String email);

	public boolean createUserAccount(UserAccount userAccount);

	public String validateTempPwd(String temporaryPassword);

	public boolean unlockUserAccount(String temporaryPassword, UnlockAccount unlockAccount);
}
