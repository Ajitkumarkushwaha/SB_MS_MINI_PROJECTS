package com.kushwaha.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
 * @version 1.2
 * @since 11-02-2020
 *
 */


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "CONTACT_INFO_MANAGER")
public class ContactDtlsEntity {

	@Id
	@GeneratedValue
	private Integer contactId;
	@NonNull
	private String contactName;
	@NonNull
	private String contactEmail;
	private Long contactNum;
	@NonNull
	private String activeSw;
	@NonNull
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
}
