
package farhans.diagram_task2;

import java.util.*;

public class HotelManagement {
    public static void main(String[] args) {
        // Create hotel
        Hotel hotel = new Hotel("Sea View Hotel");

        // Add rooms
        hotel.addGhor(new Room(101, "Single"));
        hotel.addGhor(new Room(102, "Double"));
        hotel.addGhor(new Room(103, "Suite"));

        // Create customer
        Customer grohok = new Customer("Farhan", "017xxxxxxxx");

        // Search for available room
        Room ghor = hotel.khulaGhorKhujun("Double");

        if (ghor != null) {
            // Create reservation
            Date dhukerTarikh = new Date(); // now
            Date berHobarTarikh = new Date(dhukerTarikh.getTime() + 2 * 24 * 60 * 60 * 1000L); // 2 days later

            Reservation booking = new Reservation(grohok, ghor, dhukerTarikh, berHobarTarikh);

            hotel.addBooking(booking);
            ghor.setKhaliAche(false);

            System.out.println("Ghor " + ghor.ghorNumber + " booked for " + grohok.naam);
        } else {
            System.out.println("Dhoroner kono khali ghor nei.");
        }
    }
}

// Hotel class
class Hotel {
    String naam;
    List<Room> ghorShomuho;
    List<Reservation> bookingShomuho;

    public Hotel(String naam) {
        this.naam = naam;
        this.ghorShomuho = new ArrayList<>();
        this.bookingShomuho = new ArrayList<>();
    }

    public void addGhor(Room ghor) {
        ghorShomuho.add(ghor);
    }

    public void addBooking(Reservation booking) {
        bookingShomuho.add(booking);
    }

    public Room khulaGhorKhujun(String dhoron) {
        for (Room ghor : ghorShomuho) {
            if (ghor.dhoron.equalsIgnoreCase(dhoron) && ghor.khaliAche) {
                return ghor;
            }
        }
        return null;
    }
}

// Room class
class Room {
    int ghorNumber;
    String dhoron;
    boolean khaliAche;

    public Room(int ghorNumber, String dhoron) {
        this.ghorNumber = ghorNumber;
        this.dhoron = dhoron;
        this.khaliAche = true;
    }

    public void setKhaliAche(boolean obostha) {
        this.khaliAche = obostha;
    }
}

// Reservation class
class Reservation {
    Customer grohok;
    Room ghor;
    Date dhukerTarikh;
    Date berHobarTarikh;

    public Reservation(Customer grohok, Room ghor, Date dhukerTarikh, Date berHobarTarikh) {
        this.grohok = grohok;
        this.ghor = ghor;
        this.dhukerTarikh = dhukerTarikh;
        this.berHobarTarikh = berHobarTarikh;
    }
}

// Customer class
class Customer {
    String naam;
    String jogajogTothyo;

    public Customer(String naam, String jogajogTothyo) {
        this.naam = naam;
        this.jogajogTothyo = jogajogTothyo;
    }
}
