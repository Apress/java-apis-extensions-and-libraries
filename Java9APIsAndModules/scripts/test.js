function myRunFunc() {
    print("A thread is running.");
}

// Call Thread(Runnable) constructor and pass the myRunFunc function object //that 
// will serve as an implementation for the run() method of the Runnable //interface.
var thread = new java.lang.Thread(() => print("A thread is running"));
thread.start();
