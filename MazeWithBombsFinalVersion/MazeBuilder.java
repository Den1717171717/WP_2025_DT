package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;


import java.util.*;

public class MazeBuilder {
    private Room[][] rooms = new Room[5][5];
    private List<Door> doors = new ArrayList<>();
    private MazeGameFactory factory;

    public MazeBuilder(MazeGameFactory factory) {
        this.factory = factory;
    }


    public MazeBuilder buildRooms() {
        int num = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                rooms[i][j] = factory.makeRoom(num++);
            }
        }
        return this;
    }

    public MazeBuilder buildConnectivity() {
        List<int[]> walls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j < 4) walls.add(new int[]{i, j, i, j + 1, 0}); // East
                if (i < 4) walls.add(new int[]{i, j, i + 1, j, 1}); // South
            }
        }
        Collections.shuffle(walls);

        int[] parent = new int[26];
        for (int i = 1; i <= 25; i++) parent[i] = i;

        for (int[] w : walls) {
            Room r1 = rooms[w[0]][w[1]];
            Room r2 = rooms[w[2]][w[3]];
            int root1 = find(parent, r1.getRoomNumber());
            int root2 = find(parent, r2.getRoomNumber());

            if (root1 != root2 || Math.random() < 0.2) {
                doors.add(factory.makeDoor(r1, r2));
                if (w[4] == 0) {
                    r1.removeWall(Directions.East);
                    r2.removeWall(Directions.West);
                } else {
                    r1.removeWall(Directions.South);
                    r2.removeWall(Directions.North);
                }
                parent[root1] = root2;
            }
        }
        return this;
    }

    public MazeBuilder buildEntranceAndExit() {
        rooms[0][0].setLabel("ENTRY");
        rooms[0][0].removeWall(Directions.West);
        rooms[4][4].setLabel("EXIT");
        rooms[4][4].removeWall(Directions.East);
        return this;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }

    public Room[][] getRooms() { return rooms; }
    public List<Door> getDoors() { return doors; }
}
