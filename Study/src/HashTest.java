
import java.util.ArrayList;
import java.util.HashMap;

public class HashTest {

   
   
   public static void main(String argsp[])
   {
      //Create Student Data
      Student st1 = new Student("1��°", "����ȣ", 17);
      Student st2 = new Student("2��°", "���¿�", 17);
      Student st3 = new Student("10��°", "äġ��", 19);
      Student st4 = new Student("15��°", "���븸", 19);
      
      
      //Create HashMap and Assign Student No as Key and Student Object as Value
      HashMap<String, Student> hm = new HashMap<String, Student>();
      hm.put("1��°", st1);
      hm.put("2��°", st2);
      hm.put("10��°", st3);
      hm.put("15��°", st4);
      
      //Search 10th Studnet Data
      String search = "10��°";
      Student resultHashTable = null;
      resultHashTable = hm.get(search);
      if(resultHashTable != null)
      {
         System.out.println("HashMap Result : " + resultHashTable.getName());
      }
      
      search = "15��°";
      resultHashTable = null;
      resultHashTable = hm.get(search);
      
      if(resultHashTable != null)
      {
         System.out.println("HashMap Result : " +resultHashTable.getName());
      }

   }
}

class Student{
   private String no;
   private String name;
   private int age;
   
   public Student(String _no, String _name, int _age) 
   {
      this.no = _no;
      this.name = _name;
      this.age = _age;
   }
   
   public String getNo(){
      return no;
   }
   
   public String getName(){
      return name;
   }
   
   public int getAge() {
      return age;
   }
}