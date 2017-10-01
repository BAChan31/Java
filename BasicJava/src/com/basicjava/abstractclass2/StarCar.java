package com.basicjava.abstractclass2;

public abstract class StarCar {

	public String color;
	public String tire;
	public int displacement;
	public String handle;
	
	public StarCar(String color, String tire, int displacement, String handle) {
		// TODO Auto-generated constructor stub
		
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	public abstract void getSpec();
}
