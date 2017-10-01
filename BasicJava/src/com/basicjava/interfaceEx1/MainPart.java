package com.basicjava.interfaceEx1;

public class MainPart {

	public static void main(String args[]){
		
		IFunction aPhone = new PhoneA();
		IFunction bPhone = new PhoneB();
		IFunction cPhone = new PhoneC();
		
		IFunction[] iFunctions = {aPhone, bPhone, cPhone};
		
		for(int i=0; i < iFunctions.length ; i++)
		{
			iFunctions[i].callSenderRecive();
			iFunctions[i].canLte();
			iFunctions[i].tvRemoteController();
		}
	}
}
