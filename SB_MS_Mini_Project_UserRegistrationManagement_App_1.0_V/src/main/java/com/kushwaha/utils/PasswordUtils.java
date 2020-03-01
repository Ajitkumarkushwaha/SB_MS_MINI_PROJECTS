package com.kushwaha.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kushwaha.constant.AppConstant;
import com.kushwaha.service.UserAccountManagementServiceImpl;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

public class PasswordUtils {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final Logger logger = LoggerFactory.getLogger(UserAccountManagementServiceImpl.class);

	private PasswordUtils() {
	}

	public static String userTempPassword(int count) {
		logger.debug(AppConstant.METHOD_STARTED_STR);
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		logger.debug(AppConstant.METHOD_ENDED_STR);
		return builder.toString();
	}
}
