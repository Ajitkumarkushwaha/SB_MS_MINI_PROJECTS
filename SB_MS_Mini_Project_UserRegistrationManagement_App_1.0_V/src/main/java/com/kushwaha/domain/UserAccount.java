package com.kushwaha.domain;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

@Data
public class UserAccount {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private String gender;
	private Integer country;
	private Integer state;
	private Integer city;
	private String password;
	private String accountStatus;
	private String activeSw;
}
