/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelSimulation;

public class Hotel {
    // instance variables
    private String hname;
    private Floor floors[];

    // constructor
    public Hotel(String hname, int numberOfFloor) {
        this.hname = hname;
        // create a new array of floors with the given number of floors
        this.floors = new Floor[numberOfFloor];
    }

    // method to set the number of rooms on a given floor
    public void setFloorRooms(int floorNumber, int numberOfRooms) {
        // check if the given floor number is valid
        if (floorNumber < 1 || floorNumber > floors.length) {
            throw new IllegalArgumentException("Invalid floor number");
        }
        // check if the number of rooms is at least 1
        if (numberOfRooms < 1) {
            throw new IllegalArgumentException("Number of rooms must be at least 1");
        }
        // create a new floor object with the given floor number and number of rooms
        floors[floorNumber - 1] = new Floor(floorNumber, numberOfRooms);
    }

    // method to get a specific floor object
    public Floor getFloor(int floorNum) {
        // check if the given floor number is valid
        if (floorNum < 1 || floorNum > floors.length) {
            throw new IllegalArgumentException("Invalid floor number");
        }
        // return the floor object at the given index
        return floors[floorNum - 1];
    }

    // method to search for an available room on a specific floor
    public Room searchRoom(int floorNum, int beds, int type) {
        // check if the given floor number is valid
        if (floorNum < 1 || floorNum > floors.length) {
            throw new IllegalArgumentException("Invalid floor number");
        }
        // search for an available room on the given floor with the given bed count and room type
        Room r = floors[floorNum - 1].searchRoom(type, beds);
        return r;
    }

    // method to search for an available room on any floor
    public Room searchRoom(int beds, int type) {
        // loop through each floor
        for (Floor f : floors) {
            // search for an available room on the current floor with the given bed count and room type
            Room r = f.searchRoom(type, beds);
            // if an available room is found, return it
            if (r != null) return r;
        }
        // if no available rooms are found, return null
        return null;
    }

    // method to book a room for a client
    public void bookRoom(Room r, Client c, int checkOutDate) {
        // check if the room object is null
        if (r == null) {
            throw new IllegalArgumentException("Cannot book null room");
        }
        // set the client and check-out date for the room
        r.checkIn(c, checkOutDate);
    }

    // method to check out all rooms that are due for check-out on a specific day
    public void emptyRooms(int today) {
        // loop through each floor
        for (Floor f : floors) {
            // check out all rooms that are due for check-out on the current day
            f.emptyRooms(today);
        }
    }

    // method to book a room for a client and assign them to a specific floor (if specified)
    public void serviceClient(Client client, int today) {
        // if the client did not specify a floor, search for an available room on any floor
        if (client.getNUM_FLOORS() == 0) {
            Room r = searchRoom(client.getNumberOfBeds(), client.getRoomType());
            if (r == null) {
                System.out.println("Client " + client.getID() + " leaves no room available");
            } else {
                // if an available room is found, book it for the client
                bookRoom(r, client, today + client.getDays());
            }
        } else {
            // if the client specified a floor, check if the floor number is valid
            if (client.getNUM_FLOORS() < 1 || client.getNUM_FLOORS() > floors.length) {
                throw new IllegalArgumentException("Invalid floor number");
            }
            // search for an available room on the specified floor with the given bed count and room type
            Room r = searchRoom(client.getNUM_FLOORS(), client.getNumberOfBeds(), client.getRoomType());
            if (r == null) {
                System.out.println("Client " + client.getID() + " leaves no room available");
            } else {
                // if an available room is found, book it for the client
                bookRoom(r, client, today + client.getDays());
            }
        }
    }
}


