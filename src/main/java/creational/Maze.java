package creational;

import java.util.Hashtable;

public class Maze {

    private Hashtable<Integer, Room> rooms;

    public Maze() { this.rooms = new Hashtable<Integer, Room>(); }

    public void addRoom(Room room) {
        this.rooms.put(room.getRoomNumber(), room);
    }

    public Room getRoom(int id) {
        return this.rooms.get(id);
    }

}
