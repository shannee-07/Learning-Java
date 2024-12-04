### **Life Cycle of a Thread**

1. **New**: A thread begins its life in the "New" state when an object of the `Thread` class is created but not started (`Thread t = new Thread();`).
2. **Runnable**: After calling the `start()` method, the thread moves to the "Runnable" state and is ready for execution but not yet running.
3. **Running**: When the thread scheduler selects the thread, it enters the "Running" state and executes its task.
4. **Blocked/Waiting**: If a thread is waiting for a resource or signal, it moves to the "Blocked" or "Waiting" state.
5. **Terminated**: After execution is complete, the thread moves to the "Terminated" state and cannot be restarted.

### Thread Control Methods
- **start()**: Starts the execution of the thread.
- **run()**: Contains the code executed by the thread.
- **sleep(milliseconds)**: Puts the thread to sleep for the specified time.
- **join()**: Waits for a thread to finish execution.
- **yield()**: Allows other threads to execute.
- **setPriority(priority)**: Sets the thread's priority (1 to 10).

### Important points:

- The Runnable interface provides a contract that any class can use to define its run() method. It does not represent a thread itself but rather the task that a thread will execute.
- In my words: When we write extends Thread , then that class becomes a thread itself, but when we implement Runnable, then that class becomes a task that a Thread will execute, so we are passing that task into a thread object
- When you call thread.join(), the calling thread (usually the main thread) will pause and wait until the specified thread finishes executing its run() method.
