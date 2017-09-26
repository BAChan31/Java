package StudentManagement;

import java.util.ArrayList;

public class StudentExpel {

	ArrayList<Student> expelStudents;
	public StudentExpel(){
		expelStudents = new ArrayList<Student>();		
	}
	
	public void addExpelStudent(String name, int age, int studentNumber, String major){
		expelStudents.add(new Student(name, age, studentNumber, major));
		System.out.println("재적 학생 정보 등록 완료");
	}
}
