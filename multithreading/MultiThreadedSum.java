package multithreading;

class SumCalculator implements Runnable {
    private int start;
    private int end;
    private long sum; // To store the result

    public SumCalculator(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("Sum from " + start + " to " + end + " is: " + sum);
    }
}

public class MultiThreadedSum {
    public static void main(String[] args) {
        // Define ranges for each thread
        SumCalculator calculator1 = new SumCalculator(1, 100);
        SumCalculator calculator2 = new SumCalculator(101, 200);
        SumCalculator calculator3 = new SumCalculator(201, 300);

        // Create threads for each range
        Thread thread1 = new Thread(calculator1);
        Thread thread2 = new Thread(calculator2);
        Thread thread3 = new Thread(calculator3);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calculate the total sum
        long totalSum = calculator1.getSum() + calculator2.getSum() + calculator3.getSum();
        System.out.println("Total sum is: " + totalSum);
    }
}

