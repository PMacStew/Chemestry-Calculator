import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;

public class ChemistryCalculatorGUI implements ActionListener {
    private final JFrame frame;
    private final JButton back, help, reset, molarMass, molToGram, gramToMol, doubleMolToGram, doubleGramToMol, doubleMolToMol, doubleGramToGram, molarityToMol, molToLiter, molToMolarity, molarityToGram, gramToLiter, gramToMolarity;
    private final JPanel page, top, conversionType, singleColumn, doubleColumn,molaritySingleColumn, molarMassSlide, molToGramSlide, gramToMolSlide;
    private final JLabel singleLabel, doubleLabel, singleMolarityLabel;
    private final LabelTextPanel moleculeMolarMass, moleculeMolToGram, molMolToGram, moleculeGramToMol, gramGramToMol;
    private final ButtonTextPanel resultMolarMass, resultMolToGram, resultGramToMol;
    private final CardLayout cardLayout;
    private final Font font;
    private final DecimalFormat dF;
    private final DoublePanel dMolToGramSlide, dGramToMolSlide, dMolToMolSlide, dGramToGramSlide;
    private final SinglePanel LCTM, MCTL, MLTC, LCTG, GCTL, GLTC;
    private int infoNum;
    public ChemistryCalculatorGUI() {
        dF = new DecimalFormat("#.######");
        infoNum = 1;
        frame = new JFrame("Chemistry Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
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
        molarityToMol = new JButton("Molarity to Moles");
        molToLiter = new JButton("Moles to Liters");
        molToMolarity = new JButton("Moles to Molarity");
        molarityToGram = new JButton("Molarity to Grams");
        gramToLiter = new JButton("Grams to Liters");
        gramToMolarity = new JButton("Grams to Molarity");
        page = new JPanel(new CardLayout());
        top = new JPanel();
        conversionType = new JPanel();
        singleColumn = new JPanel();
        doubleColumn = new JPanel();
        molaritySingleColumn = new JPanel();
        molarMassSlide = new JPanel();
        molToGramSlide = new JPanel();
        gramToMolSlide = new JPanel();
        singleLabel = new JLabel("Single:");
        doubleLabel = new JLabel("Double:");
        singleMolarityLabel = new JLabel("Molarity:");
        moleculeMolarMass = new LabelTextPanel("Enter Molecule", 5);
        moleculeMolToGram = new LabelTextPanel("Enter Molecule", 5);
        molMolToGram = new LabelTextPanel("Enter Moles", 5);
        moleculeGramToMol = new LabelTextPanel("Enter Molecule", 5);
        gramGramToMol = new LabelTextPanel("Enter Grams", 5);
        resultMolarMass = new ButtonTextPanel("Calculate Molar Mass", 5);
        resultMolToGram = new ButtonTextPanel("Calculate Grams", 5);
        resultGramToMol = new ButtonTextPanel("Calculate Moles", 5);
        dMolToGramSlide = new DoublePanel("Moles", "Grams");
        dGramToMolSlide = new DoublePanel("Grams", "Moles");
        dMolToMolSlide = new DoublePanel("Moles", "Moles");
        dGramToGramSlide = new DoublePanel("Grams", "Grams");
        LCTM = new SinglePanel("Liters", "Molarity", "Moles");
        MCTL = new SinglePanel("Moles", "Molarity", "Liters");
        MLTC = new SinglePanel("Moles", "Liters", "Molarity");
        LCTG = new SinglePanel("Liters", "Molarity", "Grams");
        GCTL = new SinglePanel("Grams", "Molarity", "Liters");
        GLTC = new SinglePanel("Grams", "Liters", "Molarity");
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
        molarityToMol.setFont(font);
        molToLiter.setFont(font);
        molToMolarity.setFont(font);
        molarityToGram.setFont(font);
        gramToLiter.setFont(font);
        gramToMolarity.setFont(font);
        singleLabel.setFont(font);
        doubleLabel.setFont(font);
        singleMolarityLabel.setFont(font);
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
        molaritySingleColumn.setLayout(new BoxLayout(molaritySingleColumn, BoxLayout.Y_AXIS));
        molaritySingleColumn.add(singleMolarityLabel);
        molaritySingleColumn.add(molarityToMol);
        molaritySingleColumn.add(molToLiter);
        molaritySingleColumn.add(molToMolarity);
        molaritySingleColumn.add(molarityToGram);
        molaritySingleColumn.add(gramToLiter);
        molaritySingleColumn.add(gramToMolarity);
        conversionType.add(singleColumn);
        conversionType.add(doubleColumn);
        conversionType.add(molaritySingleColumn);
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
        page.add("LCTM", LCTM.getPanel());
        page.add("MCTL", MCTL.getPanel());
        page.add("MLTC", MLTC.getPanel());
        page.add("LCTG", LCTG.getPanel());
        page.add("GCTL", GCTL.getPanel());
        page.add("GLTC", GLTC.getPanel());
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
        molarityToMol.addActionListener(this);
        molToLiter.addActionListener(this);
        molToMolarity.addActionListener(this);
        molarityToGram.addActionListener(this);
        gramToLiter.addActionListener(this);
        gramToMolarity.addActionListener(this);
        LCTM.getButton().addActionListener(this);
        LCTM.getButton().setActionCommand("LCTM");
        MCTL.getButton().addActionListener(this);
        MCTL.getButton().setActionCommand("MCTL");
        MLTC.getButton().addActionListener(this);
        MLTC.getButton().setActionCommand("MLTC");
        LCTG.getButton().addActionListener(this);
        LCTG.getButton().setActionCommand("LCTG");
        GCTL.getButton().addActionListener(this);
        GCTL.getButton().setActionCommand("GCTL");
        GLTC.getButton().addActionListener(this);
        GLTC.getButton().setActionCommand("GLTC");
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
            infoNum = 6;
        } else if (buttonName.equals("Double Calculate Moles")) {
            DoubleConversion moles = new DoubleConversion(0, dGramToMolSlide.getStartingUnit(), dGramToMolSlide.getMolecule1(), dGramToMolSlide.getMolecule2(), dGramToMolSlide.getTopConversion(), dGramToMolSlide.getBottomConversion(), 2);
            dGramToMolSlide.setText(String.valueOf(dF.format(moles.calculateDouble() * 1000)));
        } else if (buttonName.equals("Double Moles to Moles")) {
            cardLayout.show(page, "dMolToMolSlide");
            infoNum = 7;
        } else if (buttonName.equals("Double Calculate Moles 2")) {
            DoubleConversion moles = new DoubleConversion(dMolToMolSlide.getMolecule1(), dMolToMolSlide.getStartingUnit(), dMolToMolSlide.getMolecule2(), dMolToMolSlide.getTopConversion(), dMolToMolSlide.getBottomConversion(), 3);
            dMolToMolSlide.setText(String.valueOf(dF.format(moles.calculateDouble())));
        } else if (buttonName.equals("Double Grams to Grams")) {
            cardLayout.show(page, "dGramToGramSlide");
            infoNum = 8;
        } else if (buttonName.equals("Double Calculate Grams 2")) {
            DoubleConversion grams = new DoubleConversion(0, dGramToGramSlide.getStartingUnit(), dGramToGramSlide.getMolecule1(), dGramToGramSlide.getMolecule2(), dGramToGramSlide.getTopConversion(), dGramToGramSlide.getBottomConversion(), 4);
            dGramToGramSlide.setText(String.valueOf(dF.format(grams.calculateDouble())));
        } else if (buttonName.equals("Molarity to Moles")) {
            cardLayout.show(page, "LCTM");
            infoNum = 9;
        } else if (buttonName.equals("LCTM")) {
            LCTM.setText(String.valueOf(dF.format(LCTM.getFirst() * LCTM.getSecond())));
        } else if (buttonName.equals("Moles to Liters")) {
            cardLayout.show(page, "MCTL");
            infoNum = 10;
        } else if (buttonName.equals("MCTL")) {
            MCTL.setText(String.valueOf(dF.format(MCTL.getFirst() / MCTL.getSecond())));
        } else if (buttonName.equals("Moles to Molarity")) {
            cardLayout.show(page, "MLTC");
            infoNum = 11;
        } else if (buttonName.equals("MLTC")) {
            MLTC.setText(String.valueOf(dF.format(MLTC.getFirst() / MLTC.getSecond())));
        } else if (buttonName.equals("Molarity to Grams")) {
            cardLayout.show(page, "LCTG");
            infoNum = 12;
        } else if (buttonName.equals("LCTG")) {
            MolarMass grams = new MolarMass(LCTG.getMolecule());
            LCTG.setText(String.valueOf(dF.format(grams.getMolarMass() / 1000 * LCTG.getFirst() * LCTG.getFirst())));
        } else if (buttonName.equals("Grams to Liters")) {
            cardLayout.show(page, "GCTL");
            infoNum = 13;
        } else if (buttonName.equals("GCTL")) {
            MolarMass grams = new MolarMass(GCTL.getMolecule());
            GCTL.setText(String.valueOf(dF.format(GCTL.getFirst() / grams.getMolarMass() * 1000 / GCTL.getSecond())));
        } else if (buttonName.equals("Grams to Molarity")) {
            cardLayout.show(page, "GLTC");
            infoNum = 14;
        } else if (buttonName.equals("GLTC")) {
            MolarMass grams = new MolarMass(GLTC.getMolecule());
            GLTC.setText(String.valueOf(dF.format(GLTC.getFirst() / grams.getMolarMass() * 1000 / GLTC.getSecond())));
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
