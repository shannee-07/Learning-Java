package co.learning.core;

public class DataTypes {

    static void literals(){
        // Literal is a fixed value that is directly represented in your code.
        // Large numbers can be assigned like this for readability:
        double largeNumber = 10_00_000_000;
        double d = 10.43;

        /* Any floating-point literal you write (e.g., 3.14, 0.5) is treated as a double by default
        *  if you want to assign a floating-point literal to a variable of type float, you need to explicitly
        *  tell the compiler that the literal should be treated as a float rather than a double.
        *  You do this by appending an f or F to the end of the literal.*/
        float f = 10.3f;

        /* Why to use f?
        * 1. Precision Difference: double has a higher precision (64 bits) compared to float (32 bits)
        * 2. Avoiding Implicit Casting*/
    }

    static void typeCasting(){
        // Lower precision data type can be converted to Higher precision data type but vice versa is not true due to data loss

        /* There are two main types of casting:
        * 1. implicit casting (also known as automatic or widening casting)
        * 2. explicit casting (also known as narrowing casting). */

        int myInt = 100;
        long myLong = myInt; // Implicit casting from int to long

        long myLong2 = 100L;
        int myInt2 = (int) myLong2; // Explicit casting from long to int
    }


    public static void main(String[] a){
        literals();
        typeCasting();
    }
}
