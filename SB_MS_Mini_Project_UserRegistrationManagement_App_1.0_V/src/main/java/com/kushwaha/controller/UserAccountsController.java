package com.kushwaha.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kushwaha.constant.AppConstant;
import com.kushwaha.domain.UnlockAccount;
import com.kushwaha.domain.UserAccount;
import com.kushwaha.service.UserAccountManagementService;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

@Controller
public class UserAccountsController {

	private static final Logger logger = LoggerFactory.getLogger(UserAccountsController.class);
	@Autowired
	UserAccountManagementService userAccountService;


	/**
	 * 
	 * This method will be invoked when 404 is occurred
	 * 
	 * @return
	 */

	@GetMapping("/errorPage")
	public String errorPage() {
		logger.info("errorPage page is generated due to 404");
		return AppConstant.ERROR_L_V_NAME;
	}

	/**
	 * 
	 * This method will be invoked when user will make GET request by using / Url
	 * 
	 * @param model
	 * @return This method will load UserRegistration Page
	 */
	@GetMapping(value = "/")
	public String loadForm(Model model) {
		logger.info(AppConstant.METHOD_STARTED_STR);
		UserAccount userAccount = new UserAccount();
		model.addAttribute(AppConstant.USER_ACC_STR, userAccount);
		Map<Integer, String> ac = userAccountService.getAllCountries();
		model.addAttribute("ac", ac);
		logger.info(AppConstant.METHOD_ENDED_STR);
		return AppConstant.USER_REG_LOG_V_NAME;
	}

	/**
	 * 
	 * This method will be invoked when user will enter email
	 * 
	 * @param email
	 * @return This method will return DUPLICATE if user is already registered with
	 *         given mail id Other Wise UNIQUE
	 */

	@GetMapping(value = "/validateEmail")
	@ResponseBody
	public String validateEmail(@RequestParam("email") String email) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		String validateEmail = userAccountService.validateEmail(email);
		logger.info(AppConstant.METHOD_ENDED_STR);
		return validateEmail;
	}

	/**
	 * 
	 * This method will be invoked when user try to select the Country
	 * 
	 * @param countryId
	 * @return This method will return states based on selected countryId
	 */

	@GetMapping(value = "/getStates")
	@ResponseBody
	public Map<Integer, String> reteriveStateByCountryId(@RequestParam("countryId") Integer countryId) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		Map<Integer, String> allStates = userAccountService.findAllByCountryId(countryId);
		logger.info(AppConstant.METHOD_ENDED_STR);
		return allStates;
	}

	/**
	 * 
	 * This method will be invoked when user try to select the State
	 * 
	 * @param stateId
	 * @return This method will return cities based on selected stateId
	 */
	@GetMapping(value = "/getCities")
	@ResponseBody
	public Map<Integer, String> reteriveCityByStateId(@RequestParam("stateId") Integer stateId) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		Map<Integer, String> allCities = userAccountService.findAllByStateId(stateId);
		logger.info(AppConstant.METHOD_ENDED_STR);
		return allCities;
	}

	/**
	 * 
	 * This method will be invoked when user CLICK on Register Button Or (Try To
	 * Submit)
	 * 
	 * @param userAccount
	 * @param attributes
	 * @return After Registration Is Completed Then It Will Show Success Message
	 */
	@PostMapping(value = "/saveUser")
	public String handleRegisterButton(@ModelAttribute("userAccount") UserAccount userAccount,
			RedirectAttributes attributes) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		boolean accountCretaed = userAccountService.createUserAccount(userAccount);
		if (accountCretaed) {
			attributes.addFlashAttribute(AppConstant.SUCCESS_MSG_KEY_STR, "Welcome " + userAccount.getFirstName()
					+ " Your Account Creation Is Almost Complete Please Verify Your Email Id");
		} else {
			attributes.addFlashAttribute(AppConstant.ERROR_MSG_KEY_STR, "Your Account Creation Is Failed");
		}
		logger.info(AppConstant.METHOD_ENDED_STR);
		return AppConstant.USER_REDIRECT_REG_SUCC_PAGE;
	}

	/**
	 * This method will be called when user is completed
	 * 
	 * @return
	 */
	@RequestMapping(value = "/regSuccess")
	public String showSuccessPage() {
		logger.info(AppConstant.METHOD_STARTED_STR);
		return AppConstant.USER_REG_SUCC_V_NAME;
	}

	/**
	 * This method will be called when user click on Unlock Account Lock Email Link In Email
	 * @param email
	 * @param model
	 * @return This Method Will Load The Unlock Account Form
	 */
	
	@RequestMapping(value = "/unlockAccount")
	public String unlockUserAccountPage(@RequestParam String email, Model model) {
		logger.info(AppConstant.METHOD_STARTED_STR);
		UnlockAccount unlockAccount = new UnlockAccount();
		model.addAttribute(AppConstant.UNLOCK_ACC_STR, unlockAccount);
		model.addAttribute("userEmail", email);
		logger.info(AppConstant.METHOD_ENDED_STR);
		return AppConstant.USER_UNLOCK_V_NAME;
	}

	/**
	 * This method will be called Validate Temporary Password it is used for JQuery Validation
	 * @param tempPwd
	 * @return it will return INVALID_TEMP_PWD or VALID_TEMP_PWD
	 */
	
	@RequestMapping(value = "/validateTempPwd")
	@ResponseBody
	public String validateTempPassword(@RequestParam("tempPwd") String tempPwd) {
		logger.info(AppConstant.METHOD_STARTED_STR);
		userAccountService.validateTempPwd(tempPwd);
		logger.info(AppConstant.METHOD_ENDED_STR);
		return userAccountService.validateTempPwd(tempPwd);
	}

	/**
	 * This method will be called when user click on UnlockAccount Button
	 * @param unlockAccount
	 * @param attributes
	 * @return This method will update AccounttStatus As UNLOCKED And Update The Password
	 */
	
	@PostMapping(value = "/unlockUserAccount")
	public String unlockUserAccount(@ModelAttribute("unlockAccount") UnlockAccount unlockAccount,
			RedirectAttributes attributes) {
		logger.info(AppConstant.METHOD_STARTED_STR);
		boolean validatedTempPassword = userAccountService.unlockUserAccount(unlockAccount.getTemporaryPassword(),
				unlockAccount);
		if (validatedTempPassword) {
			attributes.addFlashAttribute(AppConstant.SUCCESS_MSG_KEY_STR,
					"Welcome  Your Account Creation Is Successfully Completed Now You Can Login By Using UserName And Password");
		} else {
			attributes.addFlashAttribute(AppConstant.ERROR_MSG_KEY_STR, "Your Account Creation Is Failed");
		}
		logger.info(AppConstant.METHOD_ENDED_STR);
		return AppConstant.USER_REDIRECT_REG_SUCC_PAGE;
	}
}
