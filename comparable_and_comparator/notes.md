
# Notes on `Comparable` and `Comparator` in Java

## `Comparable`
- **Purpose**: Defines a natural ordering for objects of a class.
- **Method**: Contains a `compareTo(T o)` method.
- **Usage**: A class implements `Comparable` to specify how its objects should be compared for sorting.
- **Limitation**: One natural sorting order per class.

### Example:

```java
class Person implements Comparable<Person> {
    String name;
    int age;
    
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);  // Sort by age
    }
}
```

---

## `Comparator`
- **Purpose**: Allows for custom sorting logic, providing multiple ways to compare objects.
- **Method**: Contains a `compare(T o1, T o2)` method.
- **Usage**: Implemented separately, can be passed to sorting methods to define different sorting orders.
- **Flexibility**: Can have multiple sorting logics for the same class.

### Example:

```java
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.age, p2.age);  // Sort by age
    }
}
```

---

## Difference Between `Comparable` and `Comparator`

| Feature            | `Comparable`                          | `Comparator`                        |
|--------------------|---------------------------------------|-------------------------------------|
| **Where Used**      | Inside the class being compared.      | In a separate class or as a lambda. |
| **Sorting Logic**   | One natural order.                    | Multiple sorting logics.            |
| **Method**          | `compareTo(T o)`                      | `compare(T o1, T o2)`               |
| **Usage**           | Used with `Collections.sort()` directly. | Used with `Collections.sort()` or `Arrays.sort()`. |
| **Code Coupling**   | Tightly coupled with the class.       | Loosely coupled.                    |

---

## Conclusion:
- Use `Comparable` when you need a single, natural ordering of objects.
- Use `Comparator` when you need custom or multiple sorting orders.
