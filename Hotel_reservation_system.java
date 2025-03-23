import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }
}

class Hotel {
    private final List<Room> rooms = new ArrayList<>();
    private final Map<Integer, String> reservations = new HashMap<>();

    public Hotel() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("Room " + room.roomNumber + " - " + room.category);
            }
        }
    }

    public void bookRoom(int roomNumber, String guestName) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                room.isAvailable = false;
                reservations.put(roomNumber, guestName);
                System.out.println("Room " + roomNumber + " booked successfully for " + guestName);
                return;
            }
        }
        System.out.println("Room not available or invalid room number.");
    }

    public void viewBookings() {
        System.out.println("Current Bookings:");
        for (Map.Entry<Integer, String> entry : reservations.entrySet()) {
            System.out.println("Room " + entry.getKey() + " - Booked by " + entry.getValue());
        }
    }
}

 class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    hotel.bookRoom(roomNumber, guestName);
                    break;
                case 3:
                    hotel.viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
