package creational;


// Part of AbstractFactory patten. Note that this class is not declared as abstract as it acts as both the concrete
// factory as well as the abstract factory.
public class MazeFactory {

    MazeFactory() {}

    Maze makeMaze() { return new Maze(); }

    public Wall makeWall() { return new Wall(); }

    public Room makeRoom(int id) { return new Room(id); }

    public Door makeDoor(Room room1, Room room2) { return new Door(room1, room2); }

}
