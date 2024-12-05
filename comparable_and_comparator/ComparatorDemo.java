package comparable_and_comparator;

import java.util.*;

// It is part of the java.util package and provides a way to control the order of objects during sorting.
// Unlike the Comparable interface, which requires modifying the class itself, Comparator enables defining
// multiple ways to compare objects without altering their source code.
// A Comparator in Java is an interface used to define custom sorting logic for objects.
public class ComparatorDemo {

    public static void comparatorWithInteger() {
//        Comparator<Integer> com = (o1, o2) -> {
//            if (o1 % 2 != 0 && o2 % 2 == 0) {
//                return 1;
//            }
//            return -1;
//        };
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(14);
        list.add(10);
        list.sort((a,b)->{
            if(a>b){
                return 1;
            }
            return -1;
        });
//        Collections.sort(list, com);
        System.out.println(list);
    }
    public static void comparatorWithCustomClass(){

        List<Person> people = new ArrayList<>();
        people.add(new Person("Tony",55));
        people.add(new Person("Bruce",50));
        people.add(new Person("Thor",1500));
        people.add(new Person("Natasha",48));
        people.add(new Person("Steve",100));
        people.sort((p1, p2)-> {
            if(p1.age > p2.age){
                return 1;
            }
            return -1;
        });
        for(Person p: people){
            p.show();
        }
    }

    public static void main(String[] args) {
        // Lambdas, also known as anonymous functions and closures, are blocks of code that can be passed around and executed later.
        // Lambdas are present in Java and most modern programming languages to allow writing more concise code with less boilerplate.
        comparatorWithInteger();
//        comparatorWithCustomClass();
    }
}
