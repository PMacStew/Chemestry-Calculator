import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChemistryCalculatorGUI {
    private final JFrame frame;
    private final JButton molarMass, calculateMolarMass;
    private final JPanel conversionType, molarMassSlide;
    private final JLabel enterMoleculeMolarMass;
    private final JTextField moleculeMolarMass, resultMolarMass;
    public ChemistryCalculatorGUI() {
        frame = new JFrame("Chemistry Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new FlowLayout());
        molarMass = new JButton("Molar Mass");
        calculateMolarMass = new JButton("Calculate Molar Mass");
        conversionType = new JPanel();
        molarMassSlide = new JPanel();
        enterMoleculeMolarMass = new JLabel("Enter Molecule");
        moleculeMolarMass = new JTextField(5);
        resultMolarMass = new JTextField(5);
        conversionType.setLayout(new BoxLayout(conversionType, BoxLayout.LINE_AXIS));
        conversionType.add(molarMass);
        molarMassSlide.add(enterMoleculeMolarMass);
        molarMassSlide.add(moleculeMolarMass);
        molarMassSlide.add(calculateMolarMass);
        molarMassSlide.add(resultMolarMass);
        frame.add(conversionType);
        frame.add(molarMassSlide);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if (buttonName.equals("Calculate Molar Mass")) {
            MolarMass molecule = new MolarMass(moleculeMolarMass.getText());
            resultMolarMass.setText(String.valueOf(molecule.getMolarMass()));
        } else if (0==0) {

        }
    }
}
