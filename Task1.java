

class th1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 1: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class th2 extends Thread {
    public void run() {
        System.out.println("calling thread a2");
    }
}

public class Task1 {
    public static void main(String[] args) {
        th1 a1 = new th1();
        th2 a2 = new th2();
        a1.start();

        try {
            a1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        a2.start();
        try {
            a2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
