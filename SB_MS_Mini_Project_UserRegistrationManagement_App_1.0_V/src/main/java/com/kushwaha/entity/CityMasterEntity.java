package com.kushwaha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CITY_MASTER")
public class CityMasterEntity {
	@Id
	@GeneratedValue
	@Column(name = "city_ID")
	private Integer cityId;
	@Column(name = "city_NAME")
	private String cityName;
	@Column(name = "STATE_ID")
	private Integer stateId;
}
