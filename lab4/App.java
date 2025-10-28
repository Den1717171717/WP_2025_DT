package org.den.WP_2025_DT.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JMyPanel panel;

    public App() {
        setTitle("Maze Generator");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JMyPanel();

        JButton button = new JButton("Draw maze");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.generateMaze();
                panel.repaint();
            }
        });

        setLayout(new BorderLayout());
        JPanel menupanel = new JPanel();
        menupanel.add(button);
        add(menupanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
