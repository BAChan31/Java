package com.javadesign.singletonEx;

public class SingletonClass {

	private static SingletonClass SINGLETON_CLASS_INSTANCE = new SingletonClass();
	//static ������ ���������ν� heap �޸𸮿����� ������ �ƴ� �����Ϳ����� �޸𸮿��� ��ü�� �ּҰ��� �Ҵ�. ����, private ������ ���� ��𿡼��� ������ �Ұ����ϰ� ����.
	public int i = 10;
	
	private SingletonClass(){
		//private ������ ���� �ڱ� �ڽŸ��� ������ �� �ְ� ����.
	}
	
	public static SingletonClass getSingletonClass(){
		if(SINGLETON_CLASS_INSTANCE == null)
			SINGLETON_CLASS_INSTANCE = new SingletonClass();
		
		return SINGLETON_CLASS_INSTANCE;
		
		// �����ڸ� private���� ���Ƴ��� ������ �ܺο��� �ν��Ͻ��� �����ϱ� ���� �޼ҵ带 ���� ������ش�. �ν��Ͻ��� ���� ���(null) ��ü������ ��ü�� �ν��Ͻ��� �Ҵ��ϰ� ������ �׳� �ν��Ͻ��� ��ȯ.
	}
	
	public int geti(){
		return i;
	}
	
	public void seti(int num){
		this.i = num;
	}
}
