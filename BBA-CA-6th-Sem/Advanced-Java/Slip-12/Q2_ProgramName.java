// Question: Write a program in java which will show lifecycle (creation, sleep, and dead) of a thread. Program should print randomly the name of thread and value of sleep time. The name of the thread should be hard coded through constructor. The sleep time of a thread will be a random integer in the range 0 to 4999. [25 M]
public class Q2_ProgramName {
    static class Worker extends Thread {
        String task;
        Worker(String name, String task) { super(name); this.task = task; }
        public void run() {
            try {
                if ("life".equals(task)) {
                    System.out.println(getName() + " created");
                    Thread.sleep(500);
                    System.out.println(getName() + " running");
                    Thread.sleep(500);
                    System.out.println(getName() + " dead");
                } else if ("numbers".equals(task)) {
                    for (int i = 1; i <= 100; i++) System.out.print(i + " ");
                } else if ("oddprime".equals(task)) {
                    for (int i = 1; i <= 20; i++) if (getName().contains("Odd") ? i % 2 != 0 : isPrime(i)) System.out.print(i + " ");
                } else if ("sync".equals(task)) {
                    for (int i = 0; i < 5; i++) Counter.inc();
                } else {
                    System.out.println(getName() + " running with priority " + getPriority());
                }
            } catch (Exception e) { System.out.println(e); }
        }
    }
    static class Counter {
        static int value = 0;
        synchronized static void inc() { value++; System.out.println(value); }
    }
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
    public static void main(String[] args) throws Exception {
        String mode = "thread_name";
        if ("thread_name".equals(mode)) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName());
            return;
        }
        if ("thread_priority".equals(mode)) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " " + t.getPriority());
            return;
        }
        if ("life_cycle".equals(mode)) {
            new Worker("DemoThread", "life").start();
            Thread.sleep(2000);
            return;
        }
        if ("numbers_thread".equals(mode)) {
            new Worker("Numbers", "numbers").start();
            return;
        }
        if ("odd_prime_threads".equals(mode)) {
            new Worker("OddThread", "oddprime").start();
            new Worker("PrimeThread", "oddprime").start();
            return;
        }
        if ("synchronization".equals(mode)) {
            new Worker("One", "sync").start();
            new Worker("Two", "sync").start();
            return;
        }
        System.out.println("Thread demo for the slip.");
    }
}
