package com.saral.training.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
		joinColumns=@JoinColumn(name="USER_ID")
			)
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> listofAddresses = new ArrayList();

	@Lob
	@Column(name = "USER_DES")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_JOINING_DATE")
	private Date joinedDate;

	@Transient
	private String breif;




	public Collection<Address> getListofAddresses() {
		return listofAddresses;
	}

	public void setListofAddresses(Collection<Address> listofAddresses) {
		this.listofAddresses = listofAddresses;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBreif() {
		return breif;
	}

	public void setBreif(String breif) {
		this.breif = breif;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * public Address getHomeAddress() { return homeAddress; }
	 * 
	 * public void setHomeAddress(Address homeAddress) { this.homeAddress =
	 * homeAddress; }
	 * 
	 * public Address getOfficeAddress() { return officeAddress; }
	 * 
	 * public void setOfficeAddress(Address officeAddress) { this.officeAddress
	 * = officeAddress; }
	 */
	/*
	 * @Embedded private Address homeAddress;
	 * 
	 * @Embedded
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name="street",column=@Column(name="HOME_STREET")),
	 * 
	 * @AttributeOverride(name="city",column=@Column(name="HOME_CITY")),
	 * 
	 * @AttributeOverride(name="state",column=@Column(name="HOME_STATE")),
	 * 
	 * @AttributeOverride(name="pincode",column=@Column(name="HOME_PINCODE")) })
	 * private Address officeAddress;
	 */

}
