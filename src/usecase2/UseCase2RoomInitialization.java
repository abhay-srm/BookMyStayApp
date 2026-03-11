package usecase2;

/**
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Demonstrates abstraction, inheritance, and simple
 * room availability representation.
 *
 * @version 2.0
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Book My Stay App");
        System.out.println("Hotel Booking System v2.0");
        System.out.println("=================================\n");

        // Create room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailability = 10;
        int doubleAvailability = 5;
        int suiteAvailability = 2;

        System.out.println("Available Room Types:\n");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability + "\n");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability + "\n");

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability + "\n");
    }
}