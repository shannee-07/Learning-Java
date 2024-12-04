package multithreading;

public class Multithreading {
	public static void call() {
		System.out.println("Multi threading: process and threads");
		for(int i=0;i<10;i++) {
			Thread1 t1 = new Thread1();
			t1.start(); 
			/* start method is not defined in our class, it is the internal 
			method of Thread class which executes the run() method
			This start method changes the state of thread from ready to running*/
			
			// Threads never run in sequence, they run in parallel
			
			
			Thread t2 = new Thread(new Thread2());
			t2.start();
		}
	}

	public static void main(String[] args) {
		call();
	}
}


