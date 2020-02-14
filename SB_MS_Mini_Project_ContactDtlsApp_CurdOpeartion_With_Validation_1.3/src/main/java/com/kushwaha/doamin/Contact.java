package com.kushwaha.doamin;

import lombok.Data;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.2
 * @since 11-02-2020
 *
 */

@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNum;
	private String activeSw;
}
