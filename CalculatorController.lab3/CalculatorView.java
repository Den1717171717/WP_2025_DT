package labs_WP.lab2;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class CalculatorView {
    JFrame frame = new JFrame("Calculator");
    JLabel label = new JLabel();
    JTextPane textPane = new JTextPane();
    JButton[] numberButtons = new JButton[10];
    JButton add, sub, mul, div, eq, clear, del;

    public CalculatorView() {
        prepareGUI();
        addComponents();
    }

    private void prepareGUI() {
        frame.setSize(300, 490);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponents() {
        label.setBounds(10, 0, 270, 40);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(label);

        textPane.setBounds(10, 40, 270, 50);
        textPane.setEditable(false);
        textPane.setBackground(Color.BLACK);
        textPane.setFont(new Font("Consolas", Font.BOLD, 26));
        textPane.setForeground(Color.WHITE);
        textPane.setFocusable(false);
        frame.add(textPane);

        int x, y;
        x = 10; y = 170;
        for (int i = 7; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(x, y, 60, 40);
            frame.add(numberButtons[i]);
            x += 70;
        }

        x = 10; y = 230;
        for (int i = 4; i <= 6; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(x, y, 60, 40);
            frame.add(numberButtons[i]);
            x += 70;
        }

        x = 10; y = 290;
        for (int i = 1; i <= 3; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(x, y, 60, 40);
            frame.add(numberButtons[i]);
            x += 70;
        }

        numberButtons[0] = new JButton("0");
        numberButtons[0].setBounds(80, 350, 60, 40);
        frame.add(numberButtons[0]);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("x");
        div = new JButton("/");
        eq = new JButton("=");
        clear = new JButton("C");
        del = new JButton("DEL");

        add.setBounds(220, 290, 60, 40);
        sub.setBounds(220, 170, 60, 40);
        mul.setBounds(220, 230, 60, 40);
        div.setBounds(220, 110, 60, 40);
        eq.setBounds(220, 350, 60, 100);
        clear.setBounds(80, 110, 60, 40);
        del.setBounds(150, 110, 60, 40);

        for (JButton b : new JButton[]{add, sub, mul, div, eq, clear, del}) {
            frame.add(b);
            b.setBackground(Color.DARK_GRAY);
            b.setForeground(Color.BLACK);
            b.setFocusPainted(false);
        }

        for (JButton b : numberButtons) {
            if (b != null) {
                b.setBackground(Color.GRAY);
                b.setForeground(Color.BLACK);
                b.setFocusPainted(false);
            }

        }


    }

    public void show() {
        frame.setVisible(true);
    }

    public JFrame getFrame() { return frame; }
    public JTextPane getTextPane() { return textPane; }
    public JLabel getLabel() { return label; }
}
