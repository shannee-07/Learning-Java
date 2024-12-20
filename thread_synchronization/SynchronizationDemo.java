package thread_synchronization;

public class SynchronizationDemo {
    public static void main(String args[]) {
        MathUtil obj = new MathUtil();

        // These two thread are working on the same object
        Thread1 t1 = new Thread1(obj);
        Thread t2 = new Thread(new Thread2(obj));

        t1.start();
        t2.start();
    }
}


