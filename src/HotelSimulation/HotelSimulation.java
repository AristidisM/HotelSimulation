package  HotelSimulation;

import java.util.Random;

/**
 * This class contains the main method which runs the simulation of a hotel.
 */
public class HotelSimulation {
    // Constants to set the number of floors and rooms per floor
    private static final int NUM_FLOORS = 4;
    private static final int NUM_FLOOR_ROOMS = 10;

    /**
     * The main method creates a new hotel, sets up the rooms on each floor,
     * and runs a simulation of the hotel over the course of several days.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Create a new hotel
        Hotel h = new Hotel("Hotel ", NUM_FLOORS);

        // Set up the rooms on each floor
        for (int i = 1; i <= NUM_FLOORS; i++) {
            h.setFloorRooms(i, NUM_FLOOR_ROOMS);

            // Get a reference to the current floor
            Floor f = h.getFloor(i);

            // Set the data for the rooms on the current floor
            f.setRoomData(i*100 + 1, 2, 1);
            f.setRoomData(i*100 + 2, 2, 2);
            f.setRoomData(i*100 + 3, 2, 1);
            f.setRoomData(i*100 + 4, 3, 2);
            f.setRoomData(i*100 + 5, i*100 + 10, 2, 2);
        }

        // Run a simulation of the hotel over the course of several days
        for (int day = 1; day < 20; day++) {
            System.out.println(" STARTING DAY " + day);

            // Empty the rooms at the start of each day
            h.emptyRooms(day);

            // Generate a random number of clients for the day
            Client c;
            Random rand = new Random();
            int r = rand.nextInt(10) + 1;

            // Service each client
            for (int i = 0; i < r; i++) {
                // Create a new client and have them decide on a room to book
                c = new Client();
                c.decideBooking(NUM_FLOORS, 2);

                // Have the hotel service the client and book their room
                h.serviceClient(c, day);
            }
        }
    }
}
