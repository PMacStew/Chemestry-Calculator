import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MolarMass mass = new MolarMass("NaOH");
        String[] atoms = mass.getAtoms();
        for (int i = 0; i < atoms.length; i++) {
            System.out.println(atoms[i]);
        }
    }
}
