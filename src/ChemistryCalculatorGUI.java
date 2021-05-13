import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChemistryCalculatorGUI implements ActionListener {
    private final JFrame frame;
    private final JButton back, molarMass, calculateMolarMass, molToGram, calculateMolToGram, gramToMol, calculateGramToMol;
    private final JPanel page, top, conversionType, molarMassSlide, molToGramSlide, gramToMolSlide;
    private final JLabel enterMoleculeMolarMass, enterMolMolToGram, enterMoleculeMolToGram, enterGramGramToMol, enterMoleculeGramToMol;
    private final JTextField moleculeMolarMass, resultMolarMass, moleculeMolToGram, molMolToGram, resultMolToGram, moleculeGramToMol, gramGramToMol, resultGramToMol;
    private final CardLayout cardLayout;
    public ChemistryCalculatorGUI() {
        frame = new JFrame("Chemistry Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());
        back = new JButton("Back");
        molarMass = new JButton("Molar Mass");
        calculateMolarMass = new JButton("Calculate Molar Mass");
        molToGram = new JButton("Moles to Grams");
        calculateMolToGram = new JButton("Calculate Grams");
        gramToMol = new JButton("Grams to Moles");
        calculateGramToMol = new JButton("Calculate Moles");
        page = new JPanel(new CardLayout());
        top = new JPanel();
        conversionType = new JPanel();
        molarMassSlide = new JPanel();
        molToGramSlide = new JPanel();
        gramToMolSlide = new JPanel();
        enterMoleculeMolarMass = new JLabel("Enter Molecule");
        enterMoleculeMolToGram = new JLabel("Enter Molecule");
        enterMolMolToGram = new JLabel("Enter Moles");
        enterMoleculeGramToMol = new JLabel("Enter Molecule");
        enterGramGramToMol = new JLabel("Enter Grams");
        moleculeMolarMass = new JTextField(5);
        resultMolarMass = new JTextField(5);
        moleculeMolToGram = new JTextField(5);
        molMolToGram = new JTextField(5);
        resultMolToGram = new JTextField(5);
        moleculeGramToMol = new JTextField(5);
        gramGramToMol = new JTextField(5);
        resultGramToMol = new JTextField(5);
        cardLayout = new CardLayout();
        page.setLayout(cardLayout);
        conversionType.setLayout(new BoxLayout(conversionType, BoxLayout.LINE_AXIS));
        conversionType.add(molarMass);
        conversionType.add(molToGram);
        conversionType.add(gramToMol);
        molarMassSlide.add(enterMoleculeMolarMass);
        molarMassSlide.add(moleculeMolarMass);
        molarMassSlide.add(calculateMolarMass);
        molarMassSlide.add(resultMolarMass);
        molToGramSlide.add(enterMoleculeMolToGram);
        molToGramSlide.add(moleculeMolToGram);
        molToGramSlide.add(enterMolMolToGram);
        molToGramSlide.add(molMolToGram);
        molToGramSlide.add(calculateMolToGram);
        molToGramSlide.add(resultMolToGram);
        gramToMolSlide.add(enterMoleculeGramToMol);
        gramToMolSlide.add(moleculeGramToMol);
        gramToMolSlide.add(enterGramGramToMol);
        gramToMolSlide.add(gramGramToMol);
        gramToMolSlide.add(calculateGramToMol);
        gramToMolSlide.add(resultGramToMol);
        top.add(back);
        page.add("conversionType", conversionType);
        page.add("molarMassSlide", molarMassSlide);
        page.add("molToGramSlide", molToGramSlide);
        page.add("gramToMolSlide", gramToMolSlide);
        frame.add(top, BorderLayout.NORTH);
        frame.add(page, BorderLayout.CENTER);
        frame.setVisible(true);
        back.addActionListener(this);
        molarMass.addActionListener(this);
        molToGram.addActionListener(this);
        gramToMol.addActionListener(this);
        calculateMolarMass.addActionListener(this);
        calculateMolToGram.addActionListener(this);
        calculateGramToMol.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if (buttonName.equals("Calculate Molar Mass")) {
            MolarMass molecule = new MolarMass(moleculeMolarMass.getText());
            resultMolarMass.setText(String.valueOf((double) molecule.getMolarMass() / 1000));
        } else if (buttonName.equals("Molar Mass")) {
            cardLayout.show(page ,"molarMassSlide");
        } else if (buttonName.equals("Back")) {
            cardLayout.show(page, "conversionType");
            this.setTextFields();
        } else if (buttonName.equals("Moles to Grams")) {
            cardLayout.show(page, "molToGramSlide");
        } else if (buttonName.equals("Calculate Grams")) {
            Single grams = new Single(moleculeMolToGram.getText(), Double.valueOf(molMolToGram.getText()));
            resultMolToGram.setText(String.valueOf(grams.conversion()));
        } else if (buttonName.equals("Grams to Moles")) {
            cardLayout.show(page, "gramToMolSlide");
        } else if (buttonName.equals("Calculate Moles")) {
            Single moles = new Single(Double.valueOf(gramGramToMol.getText()), moleculeGramToMol.getText());
            resultGramToMol.setText(String.valueOf(moles.conversion()));
        }
    }
    public void setTextFields() {
        moleculeMolarMass.setText("");
        resultMolarMass.setText("");
        moleculeMolToGram.setText("");
        molMolToGram.setText("");
        resultMolToGram.setText("");
        moleculeGramToMol.setText("");
        gramGramToMol.setText("");
        resultGramToMol.setText("");
    }
}
