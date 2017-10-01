package com.javadesign.singletonEx;

public class FirstClass {

	public FirstClass(){
		
		SingletonClass singletonClass = SingletonClass.getSingletonClass();
		//객체를 생성할 때 new를 사용할 수 없다. private으로 객체생성을 막았으니까. 그래서 객체생성 메소드를 통해 생성한다. 데이터 영역에 생성됨.
		System.out.println("FirstClass");
		System.out.println(singletonClass.geti());
		singletonClass.seti(20);
		System.out.println(singletonClass.geti());
		
	}
}
