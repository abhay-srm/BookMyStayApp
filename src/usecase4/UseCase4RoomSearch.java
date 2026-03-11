package usecase4;

import usecase3.RoomInventory;

/**
 * Use Case 4: Room Search & Availability Check
 *
 * Demonstrates read-only access to inventory.
 *
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking System v4.0");
        System.out.println("=================================\n");

        // Setup inventory
        RoomInventory inventory = new RoomInventory();

        inventory.addRoomType("Single Room", 10);
        inventory.addRoomType("Double Room", 5);
        inventory.addRoomType("Suite Room", 0); // unavailable example

        // Create search service
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Perform room search
        searchService.searchAvailableRooms();
    }
}