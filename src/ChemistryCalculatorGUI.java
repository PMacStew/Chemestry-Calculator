import javax.swing.*;

public class ChemistryCalculatorGUI {
    private final JFrame frame;
    private final JButton molarMass;
    public ChemistryCalculatorGUI() {
        frame = new JFrame("Chemistry Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        molarMass = new JButton("Molar Mass");

    }
}
