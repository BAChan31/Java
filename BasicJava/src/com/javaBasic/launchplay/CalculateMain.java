package com.javaBasic.launchplay;

public class CalculateMain {

	public static void main (String args[]) {
		
		LunchMenu Child1 = new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		LunchMenu Child2 = new Child2(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		
		
		System.out.println("첫번째 아이의 식대 : " + Child1.menuCalculate());
		System.out.println("두번째 아이의 식대 : " + Child2.menuCalculate());
	}
}
