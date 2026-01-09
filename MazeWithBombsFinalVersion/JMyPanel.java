package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class JMyPanel extends JPanel {
    private Room[][] rooms;
    private List<Door> doors = new ArrayList<>();
    private List<Room> solutionPath = new ArrayList<>();
    private MazeGameFactory factory = new BombedMazeGameFactory();

    public void generateMaze() {
        MazeBuilder builder = new MazeBuilder(factory)
                .buildRooms()
                .buildConnectivity()
                .buildEntranceAndExit();

        this.rooms = builder.getRooms();
        this.doors = builder.getDoors();

        calculatePath();
        repaint();
    }

    private void calculatePath() {
        solutionPath.clear();
        Map<Room, Room> prev = new HashMap<>();
        Queue<Room> queue = new LinkedList<>();
        queue.add(rooms[0][0]);
        prev.put(rooms[0][0], null);

        while (!queue.isEmpty()) {
            Room current = queue.poll();
            if (current == rooms[4][4]) break;

            for (Door d : doors) {
                Room next = d.otherSideFrom(current);
                if (next != null && !prev.containsKey(next)) {
                    prev.put(next, current);
                    queue.add(next);
                }
            }
        }

        Room curr = rooms[4][4];
        while (curr != null) {
            solutionPath.add(curr);
            curr = prev.get(curr);
        }
    }

    public void detonateBombs() {
        if (rooms == null) return;
        for (Room[] row : rooms) for (Room room : row) room.explode();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (rooms == null) return;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Room[] row : rooms) for (Room room : row) room.draw(g);
        for (Door door : doors) door.draw(g);

        if (!solutionPath.isEmpty()) {
            g2d.setColor(new Color(255, 100, 0, 150));
            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
            for (int i = 0; i < solutionPath.size() - 1; i++) {
                Room r1 = solutionPath.get(i);
                Room r2 = solutionPath.get(i+1);
                int L = MapSite.LENGTH;
                g2d.drawLine(r1.getX()+L/2, r1.getY()+L/2, r2.getX()+L/2, r2.getY()+L/2);
            }
        }
    }
}