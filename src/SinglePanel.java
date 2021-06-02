import javax.swing.*;
public class SinglePanel {
    private JPanel panel;
    private LabelTextPanel molecule, panel1, panel2;
    private ButtonTextPanel answer;
    public SinglePanel(String first, String second, String calculate) {
        panel = new JPanel();
        molecule = new LabelTextPanel("Enter Molecule", 5);
        panel1 = new LabelTextPanel("Enter " + first, 5);
        panel2 = new LabelTextPanel("Enter " + second, 5);
        answer = new ButtonTextPanel("Calculate " + calculate, 5);
        panel.add(molecule.getPanel());
        panel.add(panel1.getPanel());
        panel.add(panel2.getPanel());
        panel.add(answer.getPanel());
    }
    public JPanel getPanel() {
        return this.panel;
    }
    public JButton getButton() {
        return this.answer.getButton();
    }
    public double getFirst() {
        return panel1.getDouble();
    }
    public double getSecond() {
        return panel2.getDouble();
    }
    public String getMolecule() {
        return molecule.getString();
    }
    public void setText(String x) {
        answer.setText(x);
    }
}
