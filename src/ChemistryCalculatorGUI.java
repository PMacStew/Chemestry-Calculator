import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;

public class ChemistryCalculatorGUI implements ActionListener {
    private final JFrame frame;
    private final JButton back, help, reset, molarMass, molToGram, gramToMol, doubleMolToGram, doubleGramToMol, doubleMolToMol, doubleGramToGram;
    private final JPanel page, top, conversionType, singleColumn, doubleColumn, molarMassSlide, molToGramSlide, gramToMolSlide;
    private final JLabel singleLabel, doubleLabel;
    private final LabelTextPanel moleculeMolarMass, moleculeMolToGram, molMolToGram, moleculeGramToMol, gramGramToMol;
    private final LabelButtonPanel resultMolarMass, resultMolToGram, resultGramToMol;
    private final CardLayout cardLayout;
    private final Font font;
    private final DecimalFormat dF;
    private final DoublePanel dMolToGramSlide, dGramToMolSlide, dMolToMolSlide, dGramToGramSlide;
    private int infoNum;
    public ChemistryCalculatorGUI() {
        dF = new DecimalFormat("#.###");
        infoNum = 1;
        frame = new JFrame("Chemistry Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        back = new JButton("Back");
        help = new JButton("Help");
        reset = new JButton("Reset");
        molarMass = new JButton("Molar Mass");
        molToGram = new JButton("Moles to Grams");
        gramToMol = new JButton("Grams to Moles");
        doubleMolToGram = new JButton("Moles to Grams");
        doubleGramToMol = new JButton("Grams to Moles");
        doubleMolToMol = new JButton("Moles to Moles");
        doubleGramToGram = new JButton("Grams to Grams");
        page = new JPanel(new CardLayout());
        top = new JPanel();
        conversionType = new JPanel();
        singleColumn = new JPanel();
        doubleColumn = new JPanel();
        molarMassSlide = new JPanel();
        molToGramSlide = new JPanel();
        gramToMolSlide = new JPanel();
        singleLabel = new JLabel("Single");
        doubleLabel = new JLabel("Double");
        moleculeMolarMass = new LabelTextPanel("Enter Molecule", 5);
        moleculeMolToGram = new LabelTextPanel("Enter Molecule", 5);
        molMolToGram = new LabelTextPanel("Enter Moles", 5);
        moleculeGramToMol = new LabelTextPanel("Enter Molecule", 5);
        gramGramToMol = new LabelTextPanel("Enter Grams", 5);
        resultMolarMass = new LabelButtonPanel("Calculate Molar Mass", 5);
        resultMolToGram = new LabelButtonPanel("Calculate Grams", 5);
        resultGramToMol = new LabelButtonPanel("Calculate Moles", 5);
        dMolToGramSlide = new DoublePanel("Moles", "Grams");
        dGramToMolSlide = new DoublePanel("Grams", "Moles");
        dMolToMolSlide = new DoublePanel("Moles", "Moles");
        dGramToGramSlide = new DoublePanel("Grams", "Grams");
        cardLayout = new CardLayout();
        font = new Font("Helvetica Neue", Font.BOLD, 16);
        back.setFont(font);
        help.setFont(font);
        reset.setFont(font);
        molarMass.setFont(font);
        molToGram.setFont(font);
        gramToMol.setFont(font);
        doubleMolToGram.setFont(font);
        doubleGramToMol.setFont(font);
        doubleMolToMol.setFont(font);
        doubleGramToGram.setFont(font);
        singleLabel.setFont(font);
        doubleLabel.setFont(font);
        page.setLayout(cardLayout);
        singleColumn.setLayout(new BoxLayout(singleColumn, BoxLayout.Y_AXIS));
        singleColumn.add(singleLabel);
        singleColumn.add(molarMass);
        singleColumn.add(molToGram);
        singleColumn.add(gramToMol);
        doubleColumn.setLayout(new BoxLayout(doubleColumn, BoxLayout.Y_AXIS));
        doubleColumn.add(doubleLabel);
        doubleColumn.add(doubleMolToGram);
        doubleColumn.add(doubleGramToMol);
        doubleColumn.add(doubleMolToMol);
        doubleColumn.add(doubleGramToGram);
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
        top.add(back);
        top.add(help);
        top.add(reset);
        page.add("conversionType", conversionType);
        page.add("molarMassSlide", molarMassSlide);
        page.add("molToGramSlide", molToGramSlide);
        page.add("gramToMolSlide", gramToMolSlide);
        page.add("dMolToGramSlide", dMolToGramSlide.getPanel());
        page.add("dGramToMolSlide", dGramToMolSlide.getPanel());
        page.add("dMolToMolSlide", dMolToMolSlide.getPanel());
        page.add("dGramToGramSlide", dGramToGramSlide.getPanel());
        frame.add(top, BorderLayout.NORTH);
        frame.add(page, BorderLayout.CENTER);
        frame.setVisible(true);
        back.addActionListener(this);
        help.addActionListener(this);
        reset.addActionListener(this);
        molarMass.addActionListener(this);
        molToGram.addActionListener(this);
        molToGram.setActionCommand("Single Moles to Grams");
        gramToMol.addActionListener(this);
        gramToMol.setActionCommand("Single Grams to Moles");
        doubleMolToGram.addActionListener(this);
        doubleMolToGram.setActionCommand("Double Moles to Grams");
        doubleGramToMol.addActionListener(this);
        doubleGramToMol.setActionCommand("Double Grams to Moles");
        doubleMolToMol.addActionListener(this);
        doubleMolToMol.setActionCommand("Double Moles to Moles");
        doubleGramToGram.addActionListener(this);
        doubleGramToGram.setActionCommand("Double Grams to Grams");
        resultMolarMass.getButton().addActionListener(this);
        resultMolToGram.getButton().addActionListener(this);
        resultMolToGram.getButton().setActionCommand("Single Calculate Grams");
        resultGramToMol.getButton().addActionListener(this);
        resultGramToMol.getButton().setActionCommand("Single Calculate Moles");
        dMolToGramSlide.getButton().addActionListener(this);
        dMolToGramSlide.getButton().setActionCommand("Double Calculate Grams");
        dGramToMolSlide.getButton().addActionListener(this);
        dGramToMolSlide.getButton().setActionCommand("Double Calculate Moles");
        dMolToMolSlide.getButton().addActionListener(this);
        dMolToMolSlide.getButton().setActionCommand("Double Calculate Moles 2");
        dGramToGramSlide.getButton().addActionListener(this);
        dGramToGramSlide.getButton().setActionCommand("Double Calculate Grams 2");
    }
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if (buttonName.equals("Calculate Molar Mass")) {
            MolarMass molecule = new MolarMass(moleculeMolarMass.getString());
            resultMolarMass.setText(String.valueOf((double) molecule.getMolarMass() / 1000));
        } else if (buttonName.equals("Molar Mass")) {
            cardLayout.show(page, "molarMassSlide");
            infoNum = 2;
        } else if (buttonName.equals("Back")) {
            cardLayout.show(page, "conversionType");
            this.setTextFields();
            infoNum = 1;
        } else if (buttonName.equals("Reset")) {
            this.setTextFields();
        } else if (buttonName.equals("Single Moles to Grams")) {
            cardLayout.show(page, "molToGramSlide");
            infoNum = 3;
        } else if (buttonName.equals("Single Calculate Grams")) {
            Single grams = new Single(moleculeMolToGram.getString(), molMolToGram.getDouble());
            resultMolToGram.setText(String.valueOf(dF.format(grams.singleConversion() / 1000)));
        } else if (buttonName.equals("Single Grams to Moles")) {
            cardLayout.show(page, "gramToMolSlide");
            infoNum = 4;
        } else if (buttonName.equals("Single Calculate Moles")) {
            Single moles = new Single(0, gramGramToMol.getDouble(), moleculeGramToMol.getString());
            resultGramToMol.setText(String.valueOf(dF.format(moles.singleConversion() * 1000)));
        } else if (buttonName.equals("Double Moles to Grams")) {
            cardLayout.show(page, "dMolToGramSlide");
            infoNum = 5;
        } else if (buttonName.equals("Help")) {
            Instructions instructions = new Instructions("Main", findText(infoNum));
        } else if (buttonName.equals("Double Calculate Grams")) {
            DoubleConversion grams = new DoubleConversion(dMolToGramSlide.getMolecule1(), dMolToGramSlide.getStartingUnit(), dMolToGramSlide.getMolecule2(), dMolToGramSlide.getTopConversion(), dMolToGramSlide.getBottomConversion(), 1);
            dMolToGramSlide.setText(String.valueOf(dF.format(grams.calculateDouble() / 1000)));
        } else if (buttonName.equals("Double Grams to Moles")) {
            cardLayout.show(page, "dGramToMolSlide");
        } else if (buttonName.equals("Double Calculate Moles")) {
            DoubleConversion moles = new DoubleConversion(0, dGramToMolSlide.getStartingUnit(), dGramToMolSlide.getMolecule1(), dGramToMolSlide.getMolecule2(), dGramToMolSlide.getTopConversion(), dGramToMolSlide.getBottomConversion(), 2);
            dGramToMolSlide.setText(String.valueOf(dF.format(moles.calculateDouble() * 1000)));
        } else if (buttonName.equals("Double Moles to Moles")) {
            cardLayout.show(page, "dMolToMolSlide");
        } else if (buttonName.equals("Double Calculate Moles 2")) {
            DoubleConversion moles = new DoubleConversion(dMolToMolSlide.getMolecule1(), dMolToMolSlide.getStartingUnit(), dMolToMolSlide.getMolecule2(), dMolToMolSlide.getTopConversion(), dMolToMolSlide.getBottomConversion(), 3);
            dMolToMolSlide.setText(String.valueOf(dF.format(moles.calculateDouble())));
        } else if (buttonName.equals("Double Grams to Grams")) {
            cardLayout.show(page, "dGramToGramSlide");
        } else if (buttonName.equals("Double Calculate Grams 2")) {
            DoubleConversion grams = new DoubleConversion(0, dGramToGramSlide.getStartingUnit(), dGramToGramSlide.getMolecule1(), dGramToGramSlide.getMolecule2(), dGramToGramSlide.getTopConversion(), dGramToGramSlide.getBottomConversion(), 4);
            dGramToGramSlide.setText(String.valueOf(dF.format(grams.calculateDouble())));
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
        dMolToGramSlide.setTextNull();
        dGramToMolSlide.setTextNull();
        dMolToMolSlide.setTextNull();
        dGramToGramSlide.setTextNull();
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
