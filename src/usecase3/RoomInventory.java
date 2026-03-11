package usecase3;

import java.util.HashMap;
import java.util.Map;

/**
 * RoomInventory manages the centralized availability of rooms.
 * It uses a HashMap to store room type and available count.
 */
public class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor initializes the inventory
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register a room type with its availability
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Retrieve availability for a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("Current Room Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Available: " + entry.getValue());
        }
    }
}