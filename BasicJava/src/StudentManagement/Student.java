package StudentManagement;

public class Student {
	
	private String name;
	private int age;
	private int studentNumber;
	private String major;
	
	public Student(String name, int age, int studentNumber, String major){
		this.name = name;
		this.age = age;
		this.studentNumber = studentNumber;
		this.major = major;
	}

	public void updateInfo(int i, String info){
		switch(i){
		case 1:
			setName(info);
			break;
		case 2:
			setAge(Integer.parseInt(info));
			break;
		case 3:
			setStudentNumber(Integer.parseInt(info));
			break;
		case 4:
			setMajor(info);
			break;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
