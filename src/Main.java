import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MolarMass mass = new MolarMass("Na10");
        String[] atoms = mass.getAtoms();
        for (int i = 0; i < atoms.length; i++) {
            System.out.println(atoms[i]);
        }
        double x = mass.getMolarMass();
        System.out.println(x);
        ChemistryCalculatorGUI miss = new ChemistryCalculatorGUI();
    }
}
