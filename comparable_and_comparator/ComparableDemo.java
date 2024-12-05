package comparable_and_comparator;


import java.util.ArrayList;
import java.util.List;

public class ComparableDemo{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tony",55));
        students.add(new Student("Bruce",50));
        students.add(new Student("Thor",1500));
        students.add(new Student("Natasha",48));
        students.add(new Student("Steve",100));
        students.sort((s1,s2)-> s1.compareTo(s2));
        for(Student student: students){
            System.out.println(student.toString());
        }
    }
}
