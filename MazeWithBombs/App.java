package org.den.WP_2025_DT.lab4.MazeWithBombs;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Generator");
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMyPanel panel = new JMyPanel();
            frame.add(panel);

            JButton button = new JButton("Generate Maze");
            button.addActionListener(e -> {
                panel.generateMaze();
                panel.repaint();
            });

            JPanel menupanel = new JPanel();
            menupanel.add(button);
            frame.add(menupanel, BorderLayout.NORTH);

            frame.setVisible(true);
        });
    }
}
