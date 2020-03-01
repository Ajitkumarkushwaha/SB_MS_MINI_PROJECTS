package com.kushwaha.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kushwaha.constant.AppConstant;
import com.kushwaha.domain.UnlockAccount;
import com.kushwaha.domain.UserAccount;
import com.kushwaha.entity.CityMasterEntity;
import com.kushwaha.entity.CountryMasterEntity;
import com.kushwaha.entity.StateMasterEntity;
import com.kushwaha.entity.UserAccountEntity;
import com.kushwaha.repositories.CityMasterRepository;
import com.kushwaha.repositories.CountryMasterRepositroy;
import com.kushwaha.repositories.StateMasterRepository;
import com.kushwaha.repositories.UserAccountRepository;
import com.kushwaha.utils.EmailUtils;
import com.kushwaha.utils.PasswordUtils;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

@Service
public class UserAccountManagementServiceImpl implements UserAccountManagementService {

	private static final Logger logger = LoggerFactory.getLogger(UserAccountManagementServiceImpl.class);
	@Autowired
	private UserAccountRepository userAccountRepo;
	@Autowired
	private CountryMasterRepositroy countryMasterRepo;
	@Autowired
	private StateMasterRepository stateMasterRepo;
	@Autowired
	private CityMasterRepository cityMasterRepo;
	@Autowired
	private EmailUtils emailUtils;

	public Map<Integer, String> getAllCountries() {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		List<CountryMasterEntity> contriesList = countryMasterRepo.findAll();
		Map<Integer, String> map = new LinkedHashMap<>();
		contriesList.forEach(countryEntity -> map.put(countryEntity.getCountryId(), countryEntity.getCountryName()));
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return map;
	}

	public Map<Integer, String> findAllByCountryId(Integer countryId) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		List<StateMasterEntity> statesList = stateMasterRepo.findByCountryId(countryId);
		Map<Integer, String> map = new LinkedHashMap<>();
		statesList.forEach(stateEntity -> map.put(stateEntity.getStateId(), stateEntity.getStateName()));
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return map;
	}

	public Map<Integer, String> findAllByStateId(Integer stateId) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		List<CityMasterEntity> cityList = cityMasterRepo.findByStateId(stateId);
		Map<Integer, String> map = new LinkedHashMap<>();
		cityList.forEach(cityEntity -> map.put(cityEntity.getCityId(), cityEntity.getCityName()));
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return map;
	}

	public String validateEmail(String email) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		UserAccountEntity userEmail = userAccountRepo.findByEmail(email);
		if (userEmail== null) {
			return "UNIQUE";
		}
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return "DUPLICATE";
	}

	public boolean createUserAccount(UserAccount userAccount) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		userAccount.setActiveSw("Y");
		userAccount.setAccountStatus("LOCKED");
		userAccount.setPassword(PasswordUtils.userTempPassword(6));
		UserAccountEntity userAccountEntity = new UserAccountEntity();
		BeanUtils.copyProperties(userAccount, userAccountEntity);
		UserAccountEntity savedEntity = userAccountRepo.save(userAccountEntity);
		if (savedEntity.getUserId() != null) {
			try {
				emailUtils.sendUserAccUnlockEmail(userAccount);
			} catch (IOException e) {
				logger.info(AppConstant.EXCEPTION_OCCURED_STR);
			}
		}
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return savedEntity.getUserId() != null;
	}

	public String validateTempPwd(String temporaryPassword) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		UserAccountEntity userTempEntity = userAccountRepo.findByPassword(temporaryPassword);
		if (userTempEntity != null) {
			return "VALID_TEMP_PWD";
		}
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return "INVALID_TEMP_PWD";
	}

	public boolean unlockUserAccount(String temporaryPassword, UnlockAccount unlockAccount) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		UserAccountEntity userAccountEntity = userAccountRepo.findByPassword(temporaryPassword);
		if (userAccountEntity == null) {
			return false;
		}
		userAccountEntity.setAccountStatus("UNLOCKED");
		userAccountEntity.setPassword(unlockAccount.getNewPassword());
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return userAccountRepo.save(userAccountEntity) != null;
	}
}
