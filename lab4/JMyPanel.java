package org.den.WP_2025_DT.lab4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JMyPanel extends JPanel {
    private Room[][] maze;

    public void generateMaze() {
        int rows = 6;
        int cols = 8;
        maze = new Room[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = new Room(j * MapSite.LENGTH + 50, i * MapSite.LENGTH + 50);
            }
        }

        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0 && rand.nextBoolean()) {
                    maze[i][j].removeWall(Directions.North);
                    maze[i-1][j].removeWall(Directions.South);
                }
                if (j < cols - 1 && rand.nextBoolean()) {
                    maze[i][j].removeWall(Directions.East);
                    maze[i][j+1].removeWall(Directions.West);
                }
                if (i < rows - 1 && rand.nextBoolean()) {
                    maze[i][j].removeWall(Directions.South);
                    maze[i+1][j].removeWall(Directions.North);
                }
                if (j > 0 && rand.nextBoolean()) {
                    maze[i][j].removeWall(Directions.West);
                    maze[i][j-1].removeWall(Directions.East);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (maze != null) {
            for (Room[] row : maze)
                for (Room r : row)
                    r.draw(g);
        }
    }
}
