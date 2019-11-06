package creational;

public class Room extends MapSite implements Cloneable {

    private int roomNumber;

    private MapSite[] mapSites = new MapSite[4];

    public Room() {}

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public MapSite getSide(Direction direction) {
        return this.mapSites[direction.ordinal()];
    }

    public void setSide(Direction direction, MapSite mapSite) {
        this.mapSites[direction.ordinal()] = mapSite;
    }

    public int getRoomNumber() { return this.roomNumber; }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void enter() {}

}
