package usecase4;

import usecase2.*;
import usecase3.RoomInventory;

public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("Available Rooms:\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvail = inventory.getAvailability("Single Room");
        int doubleAvail = inventory.getAvailability("Double Room");
        int suiteAvail = inventory.getAvailability("Suite Room");

        if (singleAvail > 0) {
            single.displayRoomDetails();
            System.out.println("Available: " + singleAvail + "\n");
        }

        if (doubleAvail > 0) {
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + doubleAvail + "\n");
        }

        if (suiteAvail > 0) {
            suite.displayRoomDetails();
            System.out.println("Available: " + suiteAvail + "\n");
        }
    }
}