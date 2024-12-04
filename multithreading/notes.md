# Thread States

Threads in Java go through various stages or phases in their life cycle. These are different thread states:

## 1. New State

- A thread is in the "new" state when it's created but hasn't started running yet.
- In this state, the thread's code hasn't executed.
- **Example Code**: The `Thread1` and `Thread2` class instances created are in the "new" state initially.

## 2. Runnable State

- A thread is in the "runnable" state when it's ready to run.
- It might actually be executing or waiting for CPU time.
- The thread scheduler allocates time to each runnable thread.
- **Example Code**: After calling `start()`, the threads move to the "runnable" state and compete for CPU time.

## 3. Blocked State

- A thread is in the "blocked" state when it's trying to acquire a lock held by another thread.
- It waits until the lock becomes available.
- **Example Code**: Coming soon...

## 4. Waiting State

- A thread enters the "waiting" state when it calls methods like `wait()` or `join()`.
- It waits for notification from another thread or termination.
- **Example Code**: Coming soon...

## 5. Timed Waiting State

- A thread is in the "timed waiting" state when it calls methods with a timeout parameter (e.g., `sleep` or conditional waits).
- It remains in this state until the timeout expires or it receives a notification.
- **Example Code**: Using `Thread.sleep()`.

## 6. Terminated State

- A thread terminates due to normal completion or exceptional events (e.g., unhandled exceptions).
- In the "terminated" state, the thread has finished executing.
- **Example Code**: Threads eventually reach the "terminated" state after executing their code.
