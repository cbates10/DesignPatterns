package creational;

public class MazeGame {

    static Maze makeMaze() { return new Maze(); }

    static Room makeRoom(int id) { return new Room(id); }

    static Wall makeWall() { return new Wall(); }

    static Door makeDoor(Room room1, Room room2) { return new Door(room1, room2); }

    public static void main(String[] args) {
        Maze maze = createMazeBadDesign();

        maze = createMazeAbstractFactory(new MazeFactory());
        maze = createMazeBuilder(new StandardMazeBuilder());
        maze = createMazeFactory(); // Method uses method calls defined in class. Doesn't take factory as param
        maze = createMazeAbstractFactory(new MazePrototypeFactory(new Maze(), new Wall(), new Room(), new Door()));
    }

    private static Maze createMazeBadDesign() {
        Maze maze = new Maze();
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Door door = new Door(room1, room2);

        maze.addRoom(room1);
        maze.addRoom(room2);

        room1.setSide(Direction.NORTH, new Wall());
        room1.setSide(Direction.SOUTH, new Wall());
        room1.setSide(Direction.EAST, door);
        room1.setSide(Direction.WEST, new Wall());

        room1.setSide(Direction.NORTH, new Wall());
        room1.setSide(Direction.SOUTH, new Wall());
        room1.setSide(Direction.EAST, new Wall());
        room1.setSide(Direction.WEST, door);

        return maze;
    }

    private static Maze createMazeAbstractFactory(MazeFactory factory) {
        Maze maze = factory.makeMaze();
        Room room1 = factory.makeRoom(1);
        Room room2 = factory.makeRoom(2);
        Door door = factory.makeDoor(room1, room2);

        maze.addRoom(room1);
        maze.addRoom(room2);

        room1.setSide(Direction.NORTH, factory.makeWall());
        room1.setSide(Direction.SOUTH, factory.makeWall());
        room1.setSide(Direction.EAST, door);
        room1.setSide(Direction.WEST, factory.makeWall());

        room1.setSide(Direction.NORTH, factory.makeWall());
        room1.setSide(Direction.SOUTH, factory.makeWall());
        room1.setSide(Direction.EAST, factory.makeWall());
        room1.setSide(Direction.WEST, door);

        return maze;
    }

    private static Maze createMazeFactory() {
        Maze maze = makeMaze();

        Room room1 = makeRoom(1);
        Room room2 = makeRoom(2);
        Door door = makeDoor(room1, room2);

        maze.addRoom(room1);
        maze.addRoom(room2);

        room1.setSide(Direction.NORTH, makeWall());
        room1.setSide(Direction.SOUTH, makeWall());
        room1.setSide(Direction.EAST, door);
        room1.setSide(Direction.WEST, makeWall());

        room1.setSide(Direction.NORTH, makeWall());
        room1.setSide(Direction.SOUTH, makeWall());
        room1.setSide(Direction.EAST, makeWall());
        room1.setSide(Direction.WEST, door);

        return maze;
    }

    private static Maze createMazeBuilder(MazeBuilder builder) {
        builder.buildMaze();

        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);

        return builder.getMaze();
    }

}
