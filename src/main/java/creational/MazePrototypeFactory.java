package creational;

public class MazePrototypeFactory extends MazeFactory {

    private Maze prototypeMaze;
    private Room prototypeRoom;
    private Wall prototypeWall;
    private Door prototypeDoor;

    MazePrototypeFactory(Maze maze, Wall wall, Room room, Door door) {
        this.prototypeDoor = door;
        this.prototypeMaze = maze;
        this.prototypeRoom = room;
        this.prototypeWall = wall;
    }

    @Override
    Maze makeMaze() {
        return this.prototypeMaze;
    }

    @Override
    public Room makeRoom(int id) {
        Room room = null;
        try {
            room = (Room)this.prototypeRoom.clone();
        } catch(CloneNotSupportedException err) {
            System.out.println("Error cloning");
        }
        return room;
    }

    @Override
    public Wall makeWall() {
        Wall wall = null;
        try {
            wall = (Wall)this.prototypeWall.clone();
        } catch(CloneNotSupportedException err) {
            System.out.println("Error cloning");
        }
        return wall;
    }

    @Override
    public Door makeDoor(Room room1, Room room2) {
        Door door = null;
        try {
            door = (Door)this.prototypeDoor.clone();
            door.intialize(room1, room2);
        } catch(CloneNotSupportedException err) {
            System.out.println("Error cloning");
        }
        return door;
    }

}
