package com.javadesign.singletonEx;

public class FirstClass {

	public FirstClass(){
		
		SingletonClass singletonClass = SingletonClass.getSingletonClass();
		//��ü�� ������ �� new�� ����� �� ����. private���� ��ü������ �������ϱ�. �׷��� ��ü���� �޼ҵ带 ���� �����Ѵ�. ������ ������ ������.
		System.out.println("FirstClass");
		System.out.println(singletonClass.geti());
		singletonClass.seti(20);
		System.out.println(singletonClass.geti());
		
	}
}
