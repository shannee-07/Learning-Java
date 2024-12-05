package thread_synchronization;

public class MathUtil {

    /*The synchronized keyword in Java is a way to ensure that only one thread can access
     * a shared resource at a time*/

    /* This synchronized keyword will lock the method to prevent its access to other threads*/

    /* synchronized */
    void getMultiples(int n) {

        /* If we want to allow some block of code to execute and don't want to apply lock on entire method
         * Then we can use synchronized  */

        /* All the code outside synchronized block will be executed without any lock */

        System.out.println("Unsynchronized block of code");

        /* Applying synchronization/lock on this particular block of code using synchronized keyword*/
        synchronized (this) {

            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
					/* The thread which is running this method will go to sleep for 500 milliseconds means the 
					execution will be paused */
                    Thread.sleep(400);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


    }
    synchronized void method() {
        // thread-safe code
    }

}
