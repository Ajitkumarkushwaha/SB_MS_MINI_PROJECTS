package com.kushwaha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 * @since 2020
 * 
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "CONTACT_DTLS_INFO")
public class ContactDtlsEntity {

	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue
	private Integer contactId;
	@NonNull
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@NonNull
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@NonNull
	@Column(name = "CONTACT_NUM")
	private Long contactNo;
	@NonNull
	@Column(name = "ACTIVE_SW")
	private String activeSw;
}
