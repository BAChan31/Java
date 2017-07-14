
import java.util.ArrayList;
import java.util.HashMap;

public class HashTest {

   
   
   public static void main(String argsp[])
   {
      //Create Student Data
      Student st1 = new Student("1번째", "강백호", 17);
      Student st2 = new Student("2번째", "서태웅", 17);
      Student st3 = new Student("10번째", "채치수", 19);
      Student st4 = new Student("15번째", "정대만", 19);
      
      
      //Create HashMap and Assign Student No as Key and Student Object as Value
      HashMap<String, Student> hm = new HashMap<String, Student>();
      hm.put("1번째", st1);
      hm.put("2번째", st2);
      hm.put("10번째", st3);
      hm.put("15번째", st4);
      
      //Search 10th Studnet Data
      String search = "10번째";
      Student resultHashTable = null;
      resultHashTable = hm.get(search);
      if(resultHashTable != null)
      {
         System.out.println("HashMap Result : " + resultHashTable.getName());
      }
      
      search = "15번째";
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