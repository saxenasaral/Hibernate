package com.saral.training.inheritence.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

public class FourWheeler extends VehicleParent {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
