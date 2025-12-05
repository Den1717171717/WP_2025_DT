package org.den.WP_2025_DT.lab4.MazeWithBombs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JMyPanel extends JPanel {

    private Room[][] rooms;
    private List<Door> doors = new ArrayList<>();
    private MazeGameFactory factory = new BombedMazeGameFactory();

    public void generateMaze() {
        rooms = new Room[5][5];
        doors.clear();

        int num = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                rooms[i][j] = factory.makeRoom(num++);
            }
        }

        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {


                if (j < 4 && r.nextInt(100) < 40) {
                    Room a = rooms[i][j];
                    Room b = rooms[i][j + 1];
                    doors.add(factory.makeDoor(a, b));
                    a.removeWall(Directions.East);
                    b.removeWall(Directions.West);
                }


                if (i < 4 && r.nextInt(100) < 40) {
                    Room a = rooms[i][j];
                    Room b = rooms[i + 1][j];
                    doors.add(factory.makeDoor(a, b));
                    a.removeWall(Directions.South);
                    b.removeWall(Directions.North);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (rooms == null) return;

        for (Room[] row : rooms)
            for (Room room : row)
                room.draw(g);

        for (Door door : doors)
            door.draw(g);
    }
}