package creational;

public class Door extends MapSite implements Cloneable {

    private boolean isOpen;

    private Room room1;

    private Room room2;

    public Door() {}

    public Door(Room room1, Room room2) {
        this.isOpen = false;
        this.room1 = room1;
        this.room2 = room2;
    }

    void enter() {}

    void intialize(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Door door = (Door)super.clone();
        door.room1 = this.room1 == null ? null : (Room)this.room1.clone();
        door.room2 = this.room2 == null ? null : (Room)this.room2.clone();
        return door;
    }
}
