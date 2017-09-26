package StudentManagement;
import java.util.ArrayList;

public class StudentManger {
	
	ArrayList<Student> students = new ArrayList<Student>();
	StudentExpel studnetExpel = new StudentExpel();
	
	public static void main(String[] args){
		
		StudentManger manager = new StudentManger();
		
		manager.addStudent("어화", 23, 101010, "전공이 무엇이냐");
		
		System.out.println(manager.students.get(0).getAge());
	}
	
	private void addStudent(String name, int age, int studentNumber, String major){
		
		students.add(new Student(name, age, studentNumber, major));
		System.out.print(name + " 학생 정보 입력 성공!");
	}
}
