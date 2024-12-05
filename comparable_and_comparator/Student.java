package comparable_and_comparator;

public class Student implements Comparable<Student>{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void show(){
        System.out.println(this.name+" "+this.age);
    }

    @Override
    public String toString(){
        return "Student{name=" + name + ", age='" + age + "}";
    }

    @Override
    public int compareTo(Student that) {
        return Integer.compare(this.age, that.age);
    }

}
