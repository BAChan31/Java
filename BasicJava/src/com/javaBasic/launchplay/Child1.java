package com.javaBasic.launchplay;

public class Child1 extends LunchMenu{

	public Child1(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
	}
	
	public int menuCalculate() {
		return rice + bulgogi + banana;
	}
}
