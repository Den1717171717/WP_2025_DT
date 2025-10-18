package labs_WP.lab2;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        for (JButton b : view.numberButtons)
            if (b != null) b.addActionListener(this);

        view.add.addActionListener(this);
        view.sub.addActionListener(this);
        view.mul.addActionListener(this);
        view.div.addActionListener(this);
        view.eq.addActionListener(this);
        view.clear.addActionListener(this);
        view.del.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextPane tf = view.getTextPane();
        JLabel label = view.getLabel();
        Object src = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (src == view.numberButtons[i]) {
                tf.setText(tf.getText() + i);
                return;
            }
        }

        try {
            if (src == view.add) { model.setNum(Double.parseDouble(tf.getText())); model.setOperation(Operation.PLUS); label.setText(tf.getText() + "+"); tf.setText(""); }
            else if (src == view.sub) { model.setNum(Double.parseDouble(tf.getText())); model.setOperation(Operation.MINUS); label.setText(tf.getText() + "-"); tf.setText(""); }
            else if (src == view.mul) { model.setNum(Double.parseDouble(tf.getText())); model.setOperation(Operation.MULTIPLY); label.setText(tf.getText() + "x"); tf.setText(""); }
            else if (src == view.div) { model.setNum(Double.parseDouble(tf.getText())); model.setOperation(Operation.DIVIDE); label.setText(tf.getText() + "/"); tf.setText(""); }

            else if (src == view.eq) {
                double result = model.calculate(Double.parseDouble(tf.getText()));
                result = Math.round(result * 100.0) / 100.0;

                String[] parts = Double.toString(result).split("\\.");
                String intPart = parts[0];

                boolean negative = intPart.startsWith("-");
                if (negative) intPart = intPart.substring(1);

                StyledDocument doc = tf.getStyledDocument();
                try { doc.remove(0, doc.getLength()); } catch (BadLocationException ex) { ex.printStackTrace(); }

                if (intPart.length() > 5) {
                    try { doc.insertString(0, "Error", null); } catch (BadLocationException ex) { ex.printStackTrace(); }
                    view.getLabel().setText("");
                    return;
                }

                SimpleAttributeSet gray = new SimpleAttributeSet();
                StyleConstants.setForeground(gray, Color.GRAY);
                SimpleAttributeSet green = new SimpleAttributeSet();
                StyleConstants.setForeground(green, Color.GREEN);

                try {
                    String intToShow = (negative ? "-" : "") + (intPart.isEmpty() ? "0" : intPart);
                    doc.insertString(doc.getLength(), intToShow + ".", gray);
                    doc.insertString(doc.getLength(), parts.length > 1 ? parts[1] : "0", green);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }

                view.getLabel().setText("");
            }

            else if (src == view.clear) {
                tf.setText("");
                label.setText("");
            } else if (src == view.del) {
                String text = tf.getText();
                if (!text.isEmpty()) tf.setText(text.substring(0, text.length() - 1));
            }
        } catch (NumberFormatException ignored) {}
    }


    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        new CalculatorController(model, view);
        view.show();
    }
}
