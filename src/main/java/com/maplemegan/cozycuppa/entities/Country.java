package com.maplemegan.cozycuppa.entities;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Countries")
public class Country implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Country_Id")
	private Integer countryId;
	
	@Column(name="Country_Name", nullable=false)
	private String countryName;
	
	/*
	private String gpsCoordinates;
	*/
	
	@Column(name="Country_Code")
	private String countryCode;
	
	@Column(name="Country_SVG")
	private String countrySvg;
	
	@Column(name="hasDrinks")
	private Boolean hasDrinks;

	public Boolean getHasDrinks() {
		return hasDrinks;
	}

	public void setHasDrinks(Boolean hasDrinks) {
		this.hasDrinks = hasDrinks;
	}

	//for the relationships
	@OneToMany(mappedBy = "userCountryId")
	private Set<User> usersInCountry;
	@OneToMany(mappedBy = "drinkCountryId")
	private Set<Drink> drinksInCountry;
	public Country() {
		super();
	}
	
	// getters and setters for  countryId;
	public void setCountryId(Integer id) {
		this.countryId=id;
	}
	public Integer getCountryId() {
		return this.countryId;
	}
	// getters and setters for countryName;
	public void setCountryName(String name) {
		this.countryName=name;
	}
	public String getCountryName() {
		return this.countryName;
	}
	
	/*
	// getters and setters for gpsCoordinates;
	public void setgpsCoordinates(String gps) {
		this.gpsCoordinates=gps;
	}
	public String getGpsCoordinates() {
		return this.gpsCoordinates;
	}
	*/
	
	

	// getters and setters for countryCode;
	public void setCountryCode(String code) {
		this.countryCode=code;
	}
	public Country(String countryName, String countryCode, String countrySvg) {
		super();
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.countrySvg = countrySvg;
	}

	public String getCountryCode() {
		return this.countryCode;
	}
	
	// getters and setters for countrySvg;
	public void setCountrySvg(String svgUrl) {
		this.countrySvg=svgUrl;
	}
	public String getCountrySvg() {
		return this.countrySvg;
	}
	//for the relationships
	// getters and setters for  Set<User> usersInCountry;
	public void setUsersInCountry(Set<User> usersin) {
		this.usersInCountry=usersin;
	}
	public Set<User> getUsersInCountry(){
		return this.usersInCountry;
	}
	
	// getters and setters for  drinksInCountry;
	public void setDrinksInCountry(Set<Drink> drinks) {
		this.drinksInCountry=drinks;
	}
	public Set<Drink> getDrinksInCountry(){
		return this.drinksInCountry;
	}
	
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName 
				+ ", countryCode=" + countryCode + "]";
	}
	

}
