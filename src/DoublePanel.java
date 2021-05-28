import javax.swing.JPanel;
import javax.swing.JButton;
public class DoublePanel {
    private JPanel panel;
    private LabelTextPanel molecule1, molecule2, startingUnit, topConversion, bottomConversion;
    private LabelButtonPanel calculate;
    public DoublePanel(String start, String end) {
        panel = new JPanel();
        molecule1 = new LabelTextPanel("Enter Molecule 1", 5);
        molecule2 = new LabelTextPanel("Enter Molecule 2", 5);
        startingUnit = new LabelTextPanel("Enter " + start, 5);
        topConversion = new LabelTextPanel("Conversion Factor", 2);
        bottomConversion = new LabelTextPanel("to", 2);
        calculate = new LabelButtonPanel("Calculate " + end, 5);
        panel.add(molecule1.getPanel());
        panel.add(molecule2.getPanel());
        panel.add(startingUnit.getPanel());
        panel.add(topConversion.getPanel());
        panel.add(bottomConversion.getPanel());
        panel.add(calculate.getPanel());
    }
    public String getMolecule1() {
        return molecule1.getString();
    }
    public String getMolecule2() {
        return molecule2.getString();
    }
    public double getStartingUnit() {
        return startingUnit.getDouble();
    }
    public int getTopConversion() {
        return topConversion.getInt();
    }
    public int getBottomConversion() {
        return bottomConversion.getInt();
    }
    public void setText(String text) {
        calculate.setText(text);
    }
    public JPanel getPanel() {
        return panel;
    }
    public JButton getButton() {
        return calculate.getButton();
    }
    public void setTextNull() {
        molecule1.setText("");
        molecule2.setText("");
        startingUnit.setText("");
        topConversion.setText("");
        bottomConversion.setText("");
        calculate.setText("");
    }
}
