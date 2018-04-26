package com.techvision.common;


public class PetrolPump {
	private int petrol;
	private int nextPetrolPumpDist;
	public PetrolPump(int petrol, int nextPetrolPumpDist) {
		super();
		this.petrol = petrol;
		this.nextPetrolPumpDist = nextPetrolPumpDist;
	}
	public int getPetrol() {
		return petrol;
	}
	public void setPetrol(int petrol) {
		this.petrol = petrol;
	}
	public int getNextPetrolPumpDist() {
		return nextPetrolPumpDist;
	}
	public void setNextPetrolPumpDist(int nextPetrolPumpDist) {
		this.nextPetrolPumpDist = nextPetrolPumpDist;
	}
}
