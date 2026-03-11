package usecase6;

import usecase3.RoomInventory;
import usecase5.Reservation;
import usecase5.BookingRequestQueue;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking System v6.0");
        System.out.println("=================================\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        inventory.addRoomType("Single Room", 2);
        inventory.addRoomType("Double Room", 1);
        inventory.addRoomType("Suite Room", 1);

        // Create booking queue
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Single Room"));
        queue.addRequest(new Reservation("Charlie", "Double Room"));
        queue.addRequest(new Reservation("David", "Suite Room"));
        queue.addRequest(new Reservation("Emma", "Suite Room"));

        // Process bookings
        RoomAllocationService service = new RoomAllocationService(inventory);

        System.out.println("\nProcessing booking requests...\n");

        service.processBookingQueue(queue);
    }
}