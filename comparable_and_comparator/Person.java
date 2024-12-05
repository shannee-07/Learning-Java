package comparable_and_comparator;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void show(){
        System.out.println(this.name+" "+this.age);
    }
}
