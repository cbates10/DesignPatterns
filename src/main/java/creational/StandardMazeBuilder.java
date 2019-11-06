package creational;

public class StandardMazeBuilder extends MazeBuilder {

    private Maze currentMaze;

    StandardMazeBuilder() {
        this.currentMaze = null;
    }

    @Override
    void buildMaze() {
        this.currentMaze = new Maze();
    }

    @Override
    void buildDoor(int room1id, int room2id) {
        Room room1 = this.currentMaze.getRoom(room1id);
        Room room2 = this.currentMaze.getRoom(room2id);
        Door door = new Door(room1, room2);

        room1.setSide(this.getCommonWall(room1, room2), door);
        room2.setSide(this.getCommonWall(room1, room2), door);

    }

    @Override
    void buildRoom(int id) {
        if(this.currentMaze.getRoom(id) == null) {
            Room room = new Room(id);

            room.setSide(Direction.NORTH, new Wall());
            room.setSide(Direction.SOUTH, new Wall());
            room.setSide(Direction.EAST, new Wall());
            room.setSide(Direction.WEST, new Wall());
            this.currentMaze.addRoom(room);
        }
    }

    @Override
    Maze getMaze() {
        return this.currentMaze;
    }

    Direction getCommonWall(Room room1, Room room2) {
        // TODO refactor to find common wall
        return Direction.NORTH;
    }
}
