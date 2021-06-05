package practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Duck", 20, "Nghe An");
        Student student2 = new Student("Pea", 21, "Lao");
        Student student3 = new Student("Pig", 2, "Chuong Heo");
        Map<Integer,Student> studentMap = new HashMap<Integer,Student>();
        studentMap.put(1,student1);
        studentMap.put(3,student3);
        studentMap.put(2,student2);
        for (Map.Entry<Integer,Student> student: studentMap.entrySet()
             ) {
            System.out.println(student.toString());
        }
        System.out.println("...................Set");
        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student1);
        studentSet.add(student3);
        studentSet.add(student2);
        for (Student student: studentSet
             ) {
            System.out.println(student.toString());
        }
        ////////////////////////////////////
        List<Student> lists = new ArrayList<Student>();
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println("So sanh theo tuoi:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}
