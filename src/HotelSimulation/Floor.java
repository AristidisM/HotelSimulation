/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelSimulation;

/**
 * This class represents a floor in a hotel, which contains a number of rooms.
 * The rooms are stored in an array.
 */
public class Floor {
    private int number; // the floor number
    private Room rooms[]; // an array to store the rooms on this floor

    /**
     * Constructor for the Floor class.
     * @param number The number of the floor.
     * @param numberOfRooms The number of rooms on the floor.
     */
    public Floor(int number, int numberOfRooms){
        this.number = number;
        this.rooms = new Room[numberOfRooms];
    }

    /**
     * Sets the data for a room on the floor.
     * @param numberR The number of the room to set.
     * @param numberB The number of beds in the room.
     * @param Type The type of the room.
     */
    public void setRoomData(int numberR, int numberB, int Type){
        // Calculate the index of the room in the rooms array
        int numberRindex = numberR % 100 - 1;
        // Create a new Room object with the given data and add it to the rooms array
        rooms[numberRindex] = new Room(numberR, numberB, Type, null, 0);
    }

    /**
     * Sets the data for a range of rooms on the floor.
     * @param numMin The minimum room number to set.
     * @param numMax The maximum room number to set.
     * @param numberB The number of beds in the rooms.
     * @param Type The type of the rooms.
     */
    public void setRoomData(int numMin, int numMax, int numberB, int Type){
        // Loop through the range of room numbers and call setRoomData for each one
        for(;numMin<=numMax;numMin++){
            setRoomData(numMin, numberB, Type);
        }
    }

    /**
     * Searches for a room on the floor that matches the given type and number of beds, and is currently unoccupied.
     * @param type The type of room to search for.
     * @param beds The number of beds in the room to search for.
     * @return The first unoccupied room that matches the given type and number of beds, or null if no such room is found.
     */
    public Room searchRoom(int type, int beds){
        for(int i=0; i<rooms.length ;i++){
            if(beds==rooms[i].getNumBeds() && type==rooms[i].getType() && rooms[i].getClient()==null )
                return rooms[i];
        }
        // If no matching room is found, return null
        return null;
    }

    /**
     * Checks all the rooms on the floor and checks out any rooms that have a checkout date equal to the given day.
     * @param Day The day to check for checkout dates.
     */
    public void emptyRooms(int Day ){
        for(int i=0; i<rooms.length ;i++){
            if((rooms[i].getCheckOutDate())==Day){
                rooms[i].checkOut();
            }
        }
    }

    /**
     * Converts a room number to an index in the rooms array.
     * @param roomNumber The room number to convert.
     * @return The index in the rooms array corresponding to the given room number, or -1 if the room number is not on this floor.
     */
    public int roomIndexFromNumber(int roomNumber){
        if((number*100)+1 <= roomNumber && (number*100)+rooms.length >= roomNumber){
        roomNumber= (roomNumber%100)-1;
        return roomNumber;}
        else return -1;
        
        
    }
    
}
