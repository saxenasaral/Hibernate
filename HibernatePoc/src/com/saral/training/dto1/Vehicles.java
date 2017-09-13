package com.saral.training.dto1;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "VEHICLES")
public class Vehicles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn private UserDetailsVehicles user;
	 * 
	 * public UserDetailsVehicles getUser() { return user; }
	 * 
	 * public void setUser(UserDetailsVehicles user) { this.user = user; }
	 */
	@ManyToMany
	@NotFound(action=NotFoundAction.IGNORE)
	private Collection<UserDetailsVehicles> user=new ArrayList<>();

	public Collection<UserDetailsVehicles> getUser() {
		return user;
	}

	public void setUser(Collection<UserDetailsVehicles> user) {
		this.user = user;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
