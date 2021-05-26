import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;

public class ChemistryCalculatorGUI implements ActionListener {
    private final JFrame frame;
    private final JButton back, help, molarMass, molToGram, gramToMol, doubleMolToGram, calculateDMolToGram;
    private final JPanel page, top, conversionType, singleColumn, doubleColumn, molarMassSlide, molToGramSlide, gramToMolSlide, dMolToGramSlide, dGramToMolSlide;
    private final JLabel singleLabel, doubleLabel, enterMolecule1DMolToGram, enterMolecule2DMolToGram, enterMolDMolToGram, conversionDMolToGram, toDMolToGram;
    private final JTextField molecule1DMolToGram, molecule2DMolToGram, molDMolToGram, topDMolToGram, bottomDMolToGram, resultDMolToGram;
    private final LabelTextPanel moleculeMolarMass, moleculeMolToGram, molMolToGram, moleculeGramToMol, gramGramToMol;
    private final LabelButtonPanel resultMolarMass, resultMolToGram, resultGramToMol;
    private final CardLayout cardLayout;
    private final Font font;
    private int infoNum;
    public ChemistryCalculatorGUI() {
        infoNum = 1;
        frame = new JFrame("Chemistry Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        back = new JButton("Back");
        help = new JButton("Help");
        molarMass = new JButton("Molar Mass");
        molToGram = new JButton("Moles to Grams");
        gramToMol = new JButton("Grams to Moles");
        doubleMolToGram = new JButton("Moles to Grams");
        calculateDMolToGram = new JButton("Calculate Grams");
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
        enterMolecule1DMolToGram = new JLabel("Enter Molecule 1");
        enterMolecule2DMolToGram = new JLabel("Enter Molecule 2");
        enterMolDMolToGram = new JLabel("Enter Moles");
        conversionDMolToGram = new JLabel("Conversion Factor");
        toDMolToGram = new JLabel("to");
        molecule1DMolToGram = new JTextField(5);
        molecule2DMolToGram = new JTextField(5);
        molDMolToGram = new JTextField(5);
        topDMolToGram = new JTextField(2);
        bottomDMolToGram = new JTextField(2);
        resultDMolToGram = new JTextField(5);
        moleculeMolarMass = new LabelTextPanel("Enter Molecule", 5);
        moleculeMolToGram = new LabelTextPanel("Enter Molecule", 5);
        molMolToGram = new LabelTextPanel("Enter Moles", 5);
        moleculeGramToMol = new LabelTextPanel("Enter Molecule", 5);
        gramGramToMol = new LabelTextPanel("Enter Grams", 5);
        resultMolarMass = new LabelButtonPanel("Calculate Molar Mass", 5);
        resultMolToGram = new LabelButtonPanel("Calculate Grams", 5);
        resultGramToMol = new LabelButtonPanel("Calculate Moles", 5);
        cardLayout = new CardLayout();
        font = new Font("Helvetica Neue", Font.BOLD, 16);
        back.setFont(font);
        help.setFont(font);
        molarMass.setFont(font);
        molToGram.setFont(font);
        gramToMol.setFont(font);
        doubleMolToGram.setFont(font);
        singleLabel.setFont(font);
        doubleLabel.setFont(font);
        enterMolecule1DMolToGram.setFont(font);
        enterMolecule2DMolToGram.setFont(font);
        enterMolDMolToGram.setFont(font);
        conversionDMolToGram.setFont(font);
        toDMolToGram.setFont(font);
        calculateDMolToGram.setFont(font);
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
        molarMassSlide.add(moleculeMolarMass.getPanel());
        molarMassSlide.add(resultMolarMass.getPanel());
        molToGramSlide.add(moleculeMolToGram.getPanel());
        molToGramSlide.add(molMolToGram.getPanel());
        molToGramSlide.add(resultMolToGram.getPanel());
        gramToMolSlide.add(moleculeGramToMol.getPanel());
        gramToMolSlide.add(gramGramToMol.getPanel());
        gramToMolSlide.add(resultGramToMol.getPanel());
        dMolToGramSlide.add(enterMolecule1DMolToGram);
        dMolToGramSlide.add(molecule1DMolToGram);
        dMolToGramSlide.add(enterMolecule2DMolToGram);
        dMolToGramSlide.add(molecule2DMolToGram);
        dMolToGramSlide.add(enterMolDMolToGram);
        dMolToGramSlide.add(molDMolToGram);
        dMolToGramSlide.add(conversionDMolToGram);
        dMolToGramSlide.add(topDMolToGram);
        dMolToGramSlide.add(toDMolToGram);
        dMolToGramSlide.add(bottomDMolToGram);
        dMolToGramSlide.add(calculateDMolToGram);
        dMolToGramSlide.add(resultDMolToGram);
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
        resultMolarMass.getButton().addActionListener(this);
        resultMolToGram.getButton().addActionListener(this);
        resultMolToGram.getButton().setActionCommand("Single Calculate Grams");
        resultGramToMol.getButton().addActionListener(this);
        resultGramToMol.getButton().setActionCommand("Double Calculate Moles");
        calculateDMolToGram.addActionListener(this);
        calculateDMolToGram.setActionCommand("Double Calculate Grams");
    }
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if (buttonName.equals("Calculate Molar Mass")) {
            MolarMass molecule = new MolarMass(moleculeMolarMass.getString());
            resultMolarMass.setText(String.valueOf((double) molecule.getMolarMass() / 1000));
        } else if (buttonName.equals("Molar Mass")) {
            cardLayout.show(page ,"molarMassSlide");
            infoNum = 2;
        } else if (buttonName.equals("Back")) {
            cardLayout.show(page, "conversionType");
            this.setTextFields();
            infoNum = 1;
        } else if (buttonName.equals("Single Moles to Grams")) {
            cardLayout.show(page, "molToGramSlide");
            infoNum = 3;
        } else if (buttonName.equals("Single Calculate Grams")) {
            Single grams = new Single(moleculeMolToGram.getString(), Double.valueOf(molMolToGram.getDouble()));
            resultMolToGram.setText(String.valueOf(grams.singleConversion() / 1000));
        } else if (buttonName.equals("Single Grams to Moles")) {
            cardLayout.show(page, "gramToMolSlide");
        } else if (buttonName.equals("Double Calculate Moles")) {
            Single moles = new Single(Double.valueOf(gramGramToMol.getDouble()), moleculeGramToMol.getString());
            resultGramToMol.setText(String.valueOf(moles.singleConversion() / 1000));
        } else if (buttonName.equals("Double Moles to Grams")) {
            cardLayout.show(page, "dMolToGramSlide");
        } else if (buttonName.equals("Help")) {
            Instructions instructions = new Instructions("Main", findText(infoNum));
        } else if (buttonName.equals("Double Calculate Grams")) {
            DoubleConversion grams = new DoubleConversion(molecule1DMolToGram.getText(),  Double.valueOf(molDMolToGram.getText()), molecule2DMolToGram.getText(), Integer.valueOf(topDMolToGram.getText()), Integer.valueOf(bottomDMolToGram.getText()), 1);
            resultDMolToGram.setText(String.valueOf(grams.calculateDouble() / 1000));
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
        molecule1DMolToGram.setText("");
        molDMolToGram.setText("");
        molecule2DMolToGram.setText("");
        topDMolToGram.setText("");
        bottomDMolToGram.setText("");
    }
    public String findText(int row) {
        try {
            String line = "";
            Scanner file = new Scanner(new File("files/Instructions"));
            for (int i = 0; i < row; i++) {
                line = file.nextLine();
            }
            return line;
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return "";
    }
}
