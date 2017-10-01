package com.javadesign.singletonEx;

public class SingletonClass {

	private static SingletonClass SINGLETON_CLASS_INSTANCE = new SingletonClass();
	//static 변수를 선언함으로써 heap 메모리에서의 생성이 아닌 데이터영역의 메모리에서 객체의 주소값을 할당. 또한, private 선언을 통해 어디에서도 접근이 불가능하게 만듬.
	public int i = 10;
	
	private SingletonClass(){
		//private 선언을 통해 자기 자신만이 생성할 수 있게 설정.
	}
	
	public static SingletonClass getSingletonClass(){
		if(SINGLETON_CLASS_INSTANCE == null)
			SINGLETON_CLASS_INSTANCE = new SingletonClass();
		
		return SINGLETON_CLASS_INSTANCE;
		
		// 생성자를 private으로 막아놨기 때문에 외부에서 인스턴스를 생성하기 위한 메소드를 따로 만들어준다. 인스턴스가 없는 경우(null) 자체적으로 객체를 인스턴스에 할당하고 있으면 그냥 인스턴스를 반환.
	}
	
	public int geti(){
		return i;
	}
	
	public void seti(int num){
		this.i = num;
	}
}
