
package farhans.diagram_task2;

import java.util.*;

public class HotelManagement {
    public static void main(String[] args) {
        // Create hotel
        Hotel hotel = new Hotel("Sea View Hotel");

        // Add rooms
        hotel.addRoom(new Room(101, "Single"));
        hotel.addRoom(new Room(102, "Double"));
        hotel.addRoom(new Room(103, "Suite"));

        // Create customer
        Customer customer = new Customer("Mr. Foishal", "017xxxxxxxx");

        // Search for available room
        Room room = hotel.findAvailableRoom("Double");

        if (room != null) {
            // Create reservation
            Date checkIn = new Date(); // current date
            Date checkOut = new Date(checkIn.getTime() + 2 * 24 * 60 * 60 * 1000L); // 2 days later

            Reservation reservation = new Reservation(customer, room, checkIn, checkOut);

            hotel.addReservation(reservation);
            room.setAvailable(false);

            System.out.println("Room " + room.roomNumber + " booked successfully for " + customer.name);
        } else {
            System.out.println("No available room of requested type.");
        }
    }
}

// Hotel class
class Hotel {
    String name;
    List<Room> rooms;
    List<Reservation> reservations;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Room findAvailableRoom(String type) {
        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(type) && room.isAvailable) {
                return room;
            }
        }
        return null;
    }
}

// Room class
class Room {
    int roomNumber;
    String type;
    boolean isAvailable;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = true;
    }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }
}

// Reservation class
class Reservation {
    Customer customer;
    Room room;
    Date checkIn;
    Date checkOut;

    public Reservation(Customer customer, Room room, Date checkIn, Date checkOut) {
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}

// Customer class
class Customer {
    String name;
    String contactInfo;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }
}
