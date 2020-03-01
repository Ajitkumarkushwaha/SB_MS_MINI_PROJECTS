package com.kushwaha.domain;

import lombok.Data;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 * This Class Is Used For Unlock Account Form
 */

@Data
public class UnlockAccount {

	private String temporaryPassword;
	private String newPassword;
	private String confirmPassword;
	private String email;
}
