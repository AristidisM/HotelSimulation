package HotelSimulation;

/**
 * Class that represents a hotel room.
 */
public class Room {
    private int numberRoom;
    private int numBeds;
    private int type;
    private Client client;
    private int checkOutDate;

    public Room(int numberRoom, int numBeds, int type, Client client, int checkOutDate) {
        this.numberRoom = numberRoom;
        this.numBeds = numBeds;
        this.type = type;
        this.client = client;
        this.checkOutDate = checkOutDate;
    }

    /**
     * Checks a client into the room and sets the checkout date.
     * 
     * @param client the client to check in
     * @param day the day of the checkout date
     */
    public void checkIn(Client client, int day) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null.");
        }
        if (day <= 0) {
            throw new IllegalArgumentException("Checkout day must be greater than 0.");
        }
        setClient(client);
        setCheckoutDate(day);
        System.out.println("Check-in for room " + getNumberRoom() + " has been made by client " + client.getID() + " for " + client.getDays() + " days.");
    }

    /**
     * Checks a client out of the room and sets the client and checkout date to null/0.
     */
    public void checkOut() {
        if (getClient() == null) {
            System.out.println("Room " + getNumberRoom() + " is already empty.");
            return;
        }
        System.out.println("Checkout for room " + getNumberRoom() + " has been made by client " + getClient().getID() + ".");
        setClient(null);
        setCheckoutDate(0);
    }

    /**
     * Returns whether or not the room is empty.
     * 
     * @return 1 if the room is empty, -1 otherwise
     */
    public int isEmpty() {
        if (getClient() == null) {
            System.out.println("Room " + getNumberRoom() + " is empty.");
            return 1;
        }
        System.out.println("Room " + getNumberRoom() + " is not empty.");
        return -1;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client clientx) {
        client = clientx;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public int getType() {
        return type;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setCheckoutDate(int checkOutDatex) {
        checkOutDate = checkOutDatex;
    }

}

