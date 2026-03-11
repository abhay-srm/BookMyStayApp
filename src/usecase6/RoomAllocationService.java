package usecase6;

import usecase3.RoomInventory;
import usecase5.Reservation;
import usecase5.BookingRequestQueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Handles reservation confirmation and room allocation.
 */
public class RoomAllocationService {

    private RoomInventory inventory;

    // Track assigned room IDs
    private Set<String> allocatedRoomIds;

    // Map room types to allocated room IDs
    private HashMap<String, Set<String>> roomAssignments;

    public RoomAllocationService(RoomInventory inventory) {
        this.inventory = inventory;
        allocatedRoomIds = new HashSet<>();
        roomAssignments = new HashMap<>();
    }

    public void processBookingQueue(BookingRequestQueue queue) {

        while (queue.hasRequests()) {

            Reservation request = queue.getNextRequest();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                String roomId = generateRoomId(roomType);

                allocatedRoomIds.add(roomId);

                roomAssignments.putIfAbsent(roomType, new HashSet<>());
                roomAssignments.get(roomType).add(roomId);

                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Reservation confirmed for "
                        + request.getGuestName()
                        + " | Room ID: " + roomId);

            } else {
                System.out.println("No rooms available for "
                        + request.getGuestName()
                        + " (" + roomType + ")");
            }
        }
    }

    private String generateRoomId(String roomType) {

        String prefix = roomType.replace(" ", "").substring(0,3).toUpperCase();
        String roomId;

        do {
            roomId = prefix + (allocatedRoomIds.size() + 1);
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}