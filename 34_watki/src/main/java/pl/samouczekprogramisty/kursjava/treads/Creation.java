package pl.samouczekprogramisty.kursjava.treads;

public class Creation {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I'm inside thread (" + Thread.currentThread().getName() + ")!");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("I'm inside runnable (" + Thread.currentThread().getName() + ")!");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(() -> System.out.println("I'm also inside runnable implemented with lambda (" + Thread.currentThread().getName() + ")!"));

        System.out.println("Am I a thread? (" + Thread.currentThread().getName() + ")");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
