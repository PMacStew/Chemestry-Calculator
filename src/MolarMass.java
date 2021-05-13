import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
public class MolarMass {
    private Scanner list;
    private int molarMass;
    private String molecule;
    private String[] atoms;
    public MolarMass(String molecule) {
        try {
            list = new Scanner(new File("files/MolarMass.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        molarMass = 0;
        this.molecule = molecule;
        atoms = this.alphabetize();
        molarMass = this.calculate();
    }
    public String[] alphabetize() {
        ArrayList<String> atoms = new ArrayList();
        String temp = "";
        String start = this.molecule;
        int count = 0;
        int index = 0;
        int amount = 0;
        while (count < start.length()) {
            index = start.charAt(count);
            if (index > 64 && index < 91) {
                if (amount == 0)
                    amount = 1;
                if (count != 0) {
                    for (int i = 0; i < amount; i++) {
                        atoms.add(temp);
                    }
                }
                amount = 0;
                temp = String.valueOf(start.charAt(count));
            }
            if (index > 96 && index < 173) {
                temp += String.valueOf(start.charAt(count));
            }
            if (index > 47 && index < 58) {
                if (amount > 0)
                    amount = (amount * 10) + (index - 48);
                else
                    amount = index - 48;
            }
            count++;
        }
        if (amount == 0)
            amount = 1;
        for (int i = 0; i < amount; i++)
            atoms.add(temp);
        String[] result = new String[atoms.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = atoms.get(i);
        }
        Arrays.sort(result);
        return result;

    }
    public int calculate() {
        int count = 0;
        String line = list.nextLine();
        String temp;
        int amount = 0;
        while (count < this.atoms.length) {
            temp = this.atoms[count];
            if (temp.length() == 1 && temp.equals(line.substring(0, 1))) {
                amount += Integer.valueOf(line.substring(2));
                count++;
            } else if (temp.length() == 2 && temp.equals(line.substring(0, 2))) {
                amount += Integer.valueOf(line.substring(3));
                count++;
            } else
                line = list.nextLine();
        }
        return amount;
    }
    public double getMolarMass() {
        return this.molarMass;
    }
}
