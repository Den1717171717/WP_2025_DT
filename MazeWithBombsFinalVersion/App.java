package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Builder & Bomber");
            frame.setSize(600, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMyPanel panel = new JMyPanel();
            frame.add(panel, BorderLayout.CENTER);

            JPanel toolBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
            toolBar.setBackground(new Color(50, 50, 50));

            JButton genBtn = createButton("Generate Maze", new Color(60, 179, 113));
            JButton bombBtn = createButton("DETONATE!", new Color(220, 20, 60));

            genBtn.addActionListener(e -> panel.generateMaze());
            bombBtn.addActionListener(e -> panel.detonateBombs());

            toolBar.add(genBtn);
            toolBar.add(bombBtn);
            frame.add(toolBar, BorderLayout.NORTH);

            frame.setVisible(true);
        });
    }

    private static JButton createButton(String text, Color color) {
        JButton b = new JButton(text);
        b.setBackground(color);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.setOpaque(true);
        b.setBorderPainted(false);
        return b;
    }
}