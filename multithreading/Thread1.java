package multithreading;

public class Thread1 extends Thread {
    //	run method includes all the code which is supposed to run by the thread
    @Override
    public void run() {
        try {
            System.out.println("Thread1 is running");
        } catch (Exception e) {
            System.out.println("Error in Thread1: " + e);
        }
    }
}
