package com.basicjava.abstractclass2;

public class StarCarLowGrade extends StarCar{

	private int tax = 1000;
	public StarCarLowGrade(String color, String tire, int displacement, String handle) {
		// TODO Auto-generated constructor stub
		super(color, tire, displacement, handle);
	}
	
	public void getSpec(){
		System.out.println("****************************");
		System.out.println("색상 : " + color);
		System.out.println("타이어 : " + tire);
		System.out.println("배기량 : " + displacement);
		System.out.println("핸들 : " + handle);
		
		if(displacement > 2000)
			tax = 2000;
		
		System.out.println("세금 : " + tax);
		System.out.println("****************************");
		
	}
}
