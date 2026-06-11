public class DeadlockDemo {

    static Object resource1 = new Object();
    static Object resource2 = new Object();

    public static void main(String[] args) {

        // Thread t1 = new Thread(() -> {
        //     synchronized(resource1) {
        //         System.out.println("T1 locked Resource1");

        //         try {
        //             Thread.sleep(1000);
        //         } catch(Exception e) {}

        //         System.out.println("T1 waiting for Resource2");

        //         synchronized(resource2) {
        //             System.out.println("T1 locked Resource2");
        //         }
        //     }
        // });

        // Thread t2 = new Thread(() -> {
        //     synchronized(resource2) {
        //         System.out.println("T2 locked Resource2");

        //         try {
        //             Thread.sleep(1000);
        //         } catch(Exception e) {}

        //         System.out.println("T2 waiting for Resource1");

        //         synchronized(resource1) {
        //             System.out.println("T2 locked Resource1");
        //         }
        //     }
        // });
        //deadlock  is removed bys keeping the same aquisision order
         Thread t1 = new Thread(() -> {
            synchronized(resource1) {
                System.out.println("T1 locked Resource1");

                try {
                    Thread.sleep(1000);
                } catch(Exception e) {}

                System.out.println("T1 waiting for Resource2");

                synchronized(resource2) {
                    System.out.println("T1 locked Resource2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized(resource1) {
                System.out.println("T2 locked Resource1");

                try {
                    Thread.sleep(1000);
                } catch(Exception e) {}

                System.out.println("T2 waiting for Resource1");

                synchronized(resource2) {
                    System.out.println("T2 locked Resource2");
                }
            }
        });


        t1.start();
        t2.start();
    }
}