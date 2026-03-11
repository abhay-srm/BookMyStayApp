package usecase5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages incoming booking requests using a FIFO queue.
 */
public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Booking request added for " + reservation.getGuestName());
    }

    // View queue
    public void displayQueue() {
        System.out.println("\nCurrent Booking Requests in Queue:\n");

        for (Reservation r : requestQueue) {
            r.displayReservation();
        }
    }

    // CHECK if queue still has requests
    public boolean hasRequests() {
        return !requestQueue.isEmpty();
    }

    // GET next request in FIFO order
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }
}