
# **Thread Synchronization in Java**

## **Introduction**
Thread synchronization ensures that multiple threads can access shared resources without conflicts, preventing issues like race conditions and data inconsistency.

---

## **Why Synchronization is Needed**
1. **Race Condition:**
    - Occurs when multiple threads modify shared data simultaneously, leading to unpredictable results.

2. **Data Corruption:**
    - Unsynchronized access can leave shared resources in an invalid state.

3. **Thread Interference:**
    - Threads disrupt each other’s operations by modifying shared data unexpectedly.

---

## **Mechanisms for Synchronization in Java**

### 1. **Synchronized Methods**
- Ensures that only one thread can execute the method on the same object at a time.
- **Syntax:**
  ```java
  synchronized void method() {
      // thread-safe code
  }
  ```
- **Example:**
  ```java
  class Counter {
      private int count = 0;

      public synchronized void increment() {
          count++;
      }

      public int getCount() {
          return count;
      }
  }
  ```

---

### 2. **Synchronized Blocks**
- Synchronizes a specific block of code rather than the entire method.
- **Syntax:**
  ```java
  synchronized (lockObject) {
      // thread-safe code
  }
  ```
- **Example:**
  ```java
  class Counter {
      private int count = 0;

      public void increment() {
          synchronized (this) {
              count++;
          }
      }

      public int getCount() {
          return count;
      }
  }
  ```

---

### 3. **Static Synchronization**
- Synchronizes static methods, locking the `ClassName.class` object.
- **Example:**
  ```java
  class SharedResource {
      public static synchronized void printMessage(String message) {
          System.out.println(message);
      }
  }
  ```

---

### 4. **Locks (Using `ReentrantLock`)**
- Provides explicit control over locking using the `java.util.concurrent.locks` package.
- **Example:**
  ```java
  import java.util.concurrent.locks.ReentrantLock;

  class Counter {
      private int count = 0;
      private final ReentrantLock lock = new ReentrantLock();

      public void increment() {
          lock.lock();
          try {
              count++;
          } finally {
              lock.unlock();
          }
      }

      public int getCount() {
          return count;
      }
  }
  ```

---

## **Important Concepts in Synchronization**

### 1. **Intrinsic Lock (Monitor)**
- Every object has an intrinsic lock that threads must acquire to execute synchronized code.

### 2. **Thread Safety**
- A class/method is thread-safe if it functions correctly when accessed by multiple threads simultaneously.

### 3. **Deadlock**
- Occurs when threads wait indefinitely for each other to release locks.

### 4. **Race Condition**
- Happens when threads access shared data without proper synchronization.

---

## **Practical Example: Bank Account Synchronization**
```java
class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds for withdrawal.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class BankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(700), "Thread 1");
        Thread t2 = new Thread(() -> account.withdraw(500), "Thread 2");

        t1.start();
        t2.start();
    }
}
```

**Output:**
```
Thread 1 is withdrawing 700
Thread 1 completed withdrawal. Remaining balance: 300
Thread 2 insufficient funds for withdrawal.
```

---

## **Advantages of Synchronization**
1. Prevents race conditions.
2. Ensures data consistency.
3. Enables thread-safe access to shared resources.

---

## **Drawbacks of Synchronization**
1. **Reduced Performance:**  
   Synchronization adds overhead, especially in high-concurrency scenarios.

2. **Deadlocks:**  
   Improper locking can lead to threads waiting indefinitely.

3. **Complex Debugging:**  
   Multithreaded programs with synchronization are harder to debug.

---

## **Conclusion**
Thread synchronization is crucial in multithreaded programming to ensure data integrity and consistency. Proper use of synchronization mechanisms like synchronized methods, blocks, and explicit locks helps prevent concurrency issues while balancing performance.
