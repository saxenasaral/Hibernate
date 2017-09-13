package com.saral.training.dto1;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS1")
public class UserDetailsVehicles {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@ManyToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	private Collection<Vehicles> vehicleList = new ArrayList<>();

	public Collection<Vehicles> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(Collection<Vehicles> vehicleList) {
		this.vehicleList = vehicleList;
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
