package package3;

import java.util.concurrent.atomic.AtomicInteger;

class TicketBooking {
    static AtomicInteger available = new AtomicInteger(10);

    public void bookTicket() {
        if (available.get() > 0) {
            System.out.println("Ticket Booked Successfully");
            available.decrementAndGet();
        } else {
            System.out.println("Sorry, No Tickets Available");
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        Thread t1 = new Thread(() -> {
            booking.bookTicket();
            System.out.println("available tickets: " + TicketBooking.available.get());
        });
        Thread t2 = new Thread(() -> {
            booking.bookTicket();
            System.out.println("available tickets: " + TicketBooking.available.get());
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
