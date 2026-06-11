package package2;

public class Task2 {
    public static void main(String[] args) {
        String s = "i have to search  something in the string";
        String search = "search";

        String[] words = s.split("\\s+");

        int n = words.length;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < n / 3; i++) {
                if (words[i].equals(search)) {
                    System.out.println("Found at index: " + i);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = n / 3; i < 2 * n / 3; i++) {
                if (words[i].equals(search)) {
                    System.out.println("Found at index: " + i);
                }
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 2 * n / 3; i < n; i++) {
                if (words[i].equals(search)) {
                    System.out.println("Found at index: " + i);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
