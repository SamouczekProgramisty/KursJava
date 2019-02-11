package pl.samouczekprogramisty.kursjava.treads.exercise;

interface ConsoleWriter {
    void write();
}

class Counter {
    private int count = 0;

    synchronized void increment() {
        count += 1;
        notify();
    }

    synchronized void waitUntil(int desiredCount) {
        try {
            while (desiredCount > count) {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ThreadedHelloWorld {
    private static final int ITERATIONS = 5;

    public static void main(String[] args) {
        Counter helloLock = new Counter();
        Counter worldLock = new Counter();
        Counter exclamationLock = new Counter();

        Thread t1 = new Thread(new SequentialRunnable(helloLock, worldLock, () -> System.out.print("Hello ")));
        Thread t2 = new Thread(new SequentialRunnable(worldLock, exclamationLock, () -> System.out.print("world")));
        Thread t3 = new Thread(new SequentialRunnable(exclamationLock, helloLock, () -> System.out.println("!")));

        t1.start();
        t2.start();
        t3.start();

        helloLock.increment();
    }

    private static class SequentialRunnable implements Runnable {
        private final ConsoleWriter writer;
        private Counter current;
        private Counter next;

        SequentialRunnable(Counter current, Counter next, ConsoleWriter writer) {
            this.current = current;
            this.next = next;
            this.writer = writer;
        }

        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                current.waitUntil(i + 1);
                writer.write();
                next.increment();
            }
        }
    }
}
