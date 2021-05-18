import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChemistryCalculatorGUI implements ActionListener {
    private final JFrame frame;
    private final JButton back, help, molarMass, calculateMolarMass, molToGram, calculateMolToGram, gramToMol, calculateGramToMol, doubleMolToGram;
    private final JPanel page, top, conversionType, singleColumn, doubleColumn, molarMassSlide, molToGramSlide, gramToMolSlide, dMolToGramSlide, dGramToMolSlide;
    private final JLabel singleLabel, doubleLabel, enterMoleculeMolarMass, enterMolMolToGram, enterMoleculeMolToGram, enterGramGramToMol, enterMoleculeGramToMol, enterMolecule1DMolToGram, enterMolecule2DMolToGram, enterMolDMolToGram;
    private final JTextField moleculeMolarMass, resultMolarMass, moleculeMolToGram, molMolToGram, resultMolToGram, moleculeGramToMol, gramGramToMol, resultGramToMol, molecule1DMolToGram, molecule2DMolToGram, molDMolToGram;
    private final CardLayout cardLayout;
    public ChemistryCalculatorGUI() {
        frame = new JFrame("Chemistry Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        back = new JButton("Back");
        help = new JButton("Help");
        molarMass = new JButton("Molar Mass");
        calculateMolarMass = new JButton("Calculate Molar Mass");
        molToGram = new JButton("Moles to Grams");
        calculateMolToGram = new JButton("Calculate Grams");
        gramToMol = new JButton("Grams to Moles");
        calculateGramToMol = new JButton("Calculate Moles");
        doubleMolToGram = new JButton("Moles to Grams");
        page = new JPanel(new CardLayout());
        top = new JPanel();
        conversionType = new JPanel();
        singleColumn = new JPanel();
        doubleColumn = new JPanel();
        molarMassSlide = new JPanel();
        molToGramSlide = new JPanel();
        gramToMolSlide = new JPanel();
        dMolToGramSlide = new JPanel();
        dGramToMolSlide = new JPanel();
        singleLabel = new JLabel("Single");
        doubleLabel = new JLabel("Double");
        enterMoleculeMolarMass = new JLabel("Enter Molecule");
        enterMoleculeMolToGram = new JLabel("Enter Molecule");
        enterMolMolToGram = new JLabel("Enter Moles");
        enterMoleculeGramToMol = new JLabel("Enter Molecule");
        enterGramGramToMol = new JLabel("Enter Grams");
        enterMolecule1DMolToGram = new JLabel("Enter Molecule 1");
        enterMolecule2DMolToGram = new JLabel("Enter Molecule 2");
        enterMolDMolToGram = new JLabel("Enter Moles");
        moleculeMolarMass = new JTextField(5);
        resultMolarMass = new JTextField(5);
        moleculeMolToGram = new JTextField(5);
        molMolToGram = new JTextField(5);
        resultMolToGram = new JTextField(5);
        moleculeGramToMol = new JTextField(5);
        gramGramToMol = new JTextField(5);
        resultGramToMol = new JTextField(5);
        molecule1DMolToGram = new JTextField(5);
        molecule2DMolToGram = new JTextField(5);
        molDMolToGram = new JTextField(5);
        cardLayout = new CardLayout();
        page.setLayout(cardLayout);
        singleColumn.setLayout(new BoxLayout(singleColumn, BoxLayout.Y_AXIS));
        singleColumn.add(singleLabel);
        singleColumn.add(molarMass);
        singleColumn.add(molToGram);
        singleColumn.add(gramToMol);
        doubleColumn.setLayout(new BoxLayout(doubleColumn, BoxLayout.Y_AXIS));
        doubleColumn.add(doubleLabel);
        doubleColumn.add(doubleMolToGram);
        conversionType.add(singleColumn);
        conversionType.add(doubleColumn);
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
        dMolToGramSlide.add(enterMolecule1DMolToGram);
        dMolToGramSlide.add(molecule1DMolToGram);
        dMolToGramSlide.add(enterMolecule2DMolToGram);
        dMolToGramSlide.add(molecule2DMolToGram);
        dMolToGramSlide.add(enterMolDMolToGram);
        dMolToGramSlide.add(molDMolToGram);
        top.add(back);
        top.add(help);
        page.add("conversionType", conversionType);
        page.add("molarMassSlide", molarMassSlide);
        page.add("molToGramSlide", molToGramSlide);
        page.add("gramToMolSlide", gramToMolSlide);
        page.add("dMolToGramSlide", dMolToGramSlide);
        frame.add(top, BorderLayout.NORTH);
        frame.add(page, BorderLayout.CENTER);
        frame.setVisible(true);
        back.addActionListener(this);
        help.addActionListener(this);
        molarMass.addActionListener(this);
        molToGram.addActionListener(this);
        molToGram.setActionCommand("Single Moles to Grams");
        gramToMol.addActionListener(this);
        gramToMol.setActionCommand("Single Grams to Moles");
        doubleMolToGram.addActionListener(this);
        doubleMolToGram.setActionCommand("Double Moles to Grams");
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
        } else if (buttonName.equals("Single Moles to Grams")) {
            cardLayout.show(page, "molToGramSlide");
        } else if (buttonName.equals("Calculate Grams")) {
            Single grams = new Single(moleculeMolToGram.getText(), Double.valueOf(molMolToGram.getText()));
            resultMolToGram.setText(String.valueOf(grams.singleConversion()));
        } else if (buttonName.equals("Single Grams to Moles")) {
            cardLayout.show(page, "gramToMolSlide");
        } else if (buttonName.equals("Calculate Moles")) {
            Single moles = new Single(Double.valueOf(gramGramToMol.getText()), moleculeGramToMol.getText());
            resultGramToMol.setText(String.valueOf(moles.singleConversion()));
        } else if (buttonName.equals("Double Moles to Grams")) {
            cardLayout.show(page, "dMolToGramSlide");
        } else if (buttonName.equals("Help")) {
            Instructions instructions = new Instructions("Main", "Yo dude what's popping");
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
