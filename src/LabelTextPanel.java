import javax.swing.*;
import java.awt.*;


public class LabelTextPanel {
    private JPanel panel;
    private JLabel label;
    private JTextField field;
    public LabelTextPanel(String name, int size) {
        panel = new JPanel();
        label = new JLabel(name);
        field = new JTextField(size);
        panel.add(label);
        panel.add(field);
        label.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
    }

    public String getString() {
        return field.getText();
    }
    public double getDouble() {
        return Double.valueOf(field.getText());
    }
    public int getInt() {
        return Integer.valueOf(field.getText());
    }
    public JPanel getPanel() {
        return panel;
    }
    public void setText(String text) {
        field.setText("");
    }
}
