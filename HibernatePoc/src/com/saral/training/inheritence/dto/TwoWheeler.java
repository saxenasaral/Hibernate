package com.saral.training.inheritence.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

public class TwoWheeler extends VehicleParent {

	private String steeringHandler;

	public String getSteeringHandler() {
		return steeringHandler;
	}

	public void setSteeringHandler(String steeringHandler) {
		this.steeringHandler = steeringHandler;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
