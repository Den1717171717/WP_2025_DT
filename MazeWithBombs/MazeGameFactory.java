package org.den.WP_2025_DT.lab4.MazeWithBombs;


public abstract class MazeGameFactory {


    public Maze createMaze() {
        Maze maze = new Maze();
        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);
        maze.addRoom(r1);
        maze.addRoom(r2);

        Door door = makeDoor(r1, r2);


        return maze;
    }

    public abstract Room makeRoom(int n);

    public abstract Wall makeWall();

    public abstract Door makeDoor(Room r1, Room r2);
}