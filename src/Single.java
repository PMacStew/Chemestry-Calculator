public class Single {

    private MolarMass molecule;
    private double mol, gram;
    private int conversion;

    // mol to gram

    public Single(String molecule, double mol) {
        int[] arr = this.noDecimal(mol);
        this.molecule = new MolarMass(molecule);
        this.mol = mol;
        this.gram = 0.0;
        this.conversion = arr[1];
    }

    // gram to mol

    public Single(double gram, String molecule) {
        int[] arr = this.noDecimal(gram);
        this.molecule = new MolarMass(molecule);
        this.mol = 0.0;
        this.gram = gram;
        this.conversion = arr[1];
    }

    public double singleConversion() {
        if (this.gram == 0.0) {
            return this.mol * molecule.getMolarMass();
        } else {
            return molecule.getMolarMass() / this.gram;
        }
    }

    public int[] noDecimal(double num) {
        int count = 0;
        while (num % 10 != 0) {
            num *= 10;
            count++;
        }
        int result = 1;
        for (int i = 0; i < count; i++) {
            result *= 10;
        }
        return new int[] {(int) num, result};
    }

    public int getConversion() {
        return this.conversion;
    }
}
