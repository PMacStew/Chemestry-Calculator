import javax.swing.*;
import java.awt.*;

public class LabelButtonPanel {
    private JPanel panel;
    private JButton button;
    private JTextField field;
    public LabelButtonPanel(String name, int size) {
        panel = new JPanel();
        button = new JButton(name);
        field = new JTextField(size);
        panel.add(button);
        panel.add(field);
        button.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
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
        field.setText(text);
    }
    public JButton getButton() {
        return button;
    }
}
