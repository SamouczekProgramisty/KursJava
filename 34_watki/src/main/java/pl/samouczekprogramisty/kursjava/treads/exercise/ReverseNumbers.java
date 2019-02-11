package pl.samouczekprogramisty.kursjava.treads.exercise;

class ReversedNestedThread extends Thread {
    private final int children;

    ReversedNestedThread(int children) {
        this.children = children;
    }

    @Override
    public void run() {
        if (children > 0) {
            ReversedNestedThread childThread = new ReversedNestedThread(children - 1);
            childThread.start();
            try {
                childThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName());
        }
    }
}

class NestedThread extends Thread {
    private final int children;

    NestedThread(int children) {
        this.children = children;
    }

    @Override
    public void run() {
        if (children > 0) {
            NestedThread childThread = new NestedThread(children - 1);
            System.out.println(getName());
            childThread.start();
        }
    }
}

public class ReverseNumbers {
    public static void main(String[] args) {
        startThreads(3);
        // startReversedThreads(3);
    }

    static void startThreads(int howManyChildren) {
        new NestedThread(howManyChildren).start();
    }

    static void startReversedThreads(int howManyChildren) {
        new ReversedNestedThread(howManyChildren).start();
    }
}
