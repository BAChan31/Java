package com.javaBasic.launchplay;

public class Child2 extends LunchMenu{

	public Child2 (int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
	}
	
	public int menuCalculate() {
		return rice + bulgogi + almond + milk;
	}
}
