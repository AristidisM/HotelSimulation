package HotelSimulation;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Client {
   // Class variables
   private static final String[] FIRST_NAMES = {"Adam", "Bob", "Charlie", "David", "Emily", "Frank", "George", "Hannah", "Isabel", "Jacob", "Kate", "Liam", "Megan", "Natalie", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tyler", "Ursula", "Victoria", "William", "Xavier", "Yvonne", "Zachary", "Avery", "Blake", "Cameron", "Dylan", "Ethan", "Felix", "Gavin", "Harper", "Isaac", "Jackson", "Kaitlyn", "Landon", "Mackenzie", "Noah", "Owen", "Paige", "Quentin", "Riley", "Spencer", "Tristan", "Violet", "Wyatt", "Xander", "Yara", "Zara"};
   private static final String[] LAST_NAMES = {"Anderson", "Brown", "Clark", "Davis", "Edwards", "Fisher", "Garcia", "Harris", "Irwin", "Johnson", "Kennedy", "Lopez", "Miller", "Nelson", "O'Connor", "Parker", "Quinn", "Robinson", "Smith", "Taylor", "Underwood", "Valdez", "Williams", "Xiong", "Young", "Zhang", "Adams", "Baker", "Chen", "Diaz", "Evans", "Ford", "Gomez", "Hernandez", "Ingram", "Jones", "Kim", "Lee", "Martinez", "Nguyen", "Owens", "Patel", "Qin", "Rodriguez", "Sanchez", "Thompson", "Unger", "Vargas", "Wang", "Xiao", "Yang", "Zhou"};
   private String firstName;
   private String lastName;
   private int ID;              // Unique client ID
   private int numberOfBeds;    // Number of beds in the room booked by the client
   private int roomType;        // Type of the room booked by the client
   private int NUM_FLOORS;      // Number of the floor where the room booked by the client is located
   private int Days;            // Number of days the client will stay at the hotel
   
   private static int next = 1; // Static variable to assign unique IDs to clients
    
   // Default constructor
   public Client(){
     // Assigns unique first and last name to the client object
        int firstNameIndex = ThreadLocalRandom.current().nextInt(0, FIRST_NAMES.length);
        int lastNameIndex = ThreadLocalRandom.current().nextInt(0, LAST_NAMES.length);
        this.firstName = FIRST_NAMES[firstNameIndex];
        this.lastName = LAST_NAMES[lastNameIndex];
        this.ID = next++;       // Assigns unique ID to the client object
   } 
   
   // Method to randomly decide the booking details for a client
   public void decideBooking(int floorCount, int typeCount) {
       // Generate a random integer (1 or 2) to decide whether the client will book a room on a floor or not
       int pos = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        
       if (pos == 1) {
           // If pos is 1, then the client will book a room on a floor
           // Generate random values for the number of beds, room type, floor number, and number of days
           int beds = ThreadLocalRandom.current().nextInt(2, 3 + 1);
           numberOfBeds = beds;
           int type = ThreadLocalRandom.current().nextInt(1, 2 + 1);
           roomType = type;
           int floor = ThreadLocalRandom.current().nextInt(1, 4 + 1);
           NUM_FLOORS = floor;
           int day = ThreadLocalRandom.current().nextInt(1, 10 + 1);
           Days = day;
       }
       else {
           // If pos is 2, then the client will book a room without specifying a floor
           // Generate random values for the number of beds, room type, and number of days
           int beds = ThreadLocalRandom.current().nextInt(2, 3 + 1);
           numberOfBeds = beds;
           int type = ThreadLocalRandom.current().nextInt(1, 2 + 1);
           roomType = type;
           int day = ThreadLocalRandom.current().nextInt(1, 10 + 1);
           Days = day;
           NUM_FLOORS = 0;
       }
   }
   
   // Getter methods to access the client's booking details
   public int getNumberOfBeds() {
       return numberOfBeds;
   }
    
   public int getRoomType() {
       return roomType;
   }
    
   public int getDays() {
       return Days;
   }
     
   public int getNUM_FLOORS() {
       return NUM_FLOORS;
   }
     
   public String getID() {
    return firstName + " " + lastName + " (ID: " + ID + ")";
   }

}
