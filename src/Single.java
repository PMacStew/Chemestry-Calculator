public class Single {

    private MolarMass molecule;
    private double mol, gram;

    // mol to gram

    public Single(String molecule, double mol) {
        this.molecule = new MolarMass(molecule);
        this.mol = mol;
        this.gram = 0.0;
    }

    // gram to mol

    public Single(double gram, String molecule) {
        this.molecule = new MolarMass(molecule);
        this.mol = 0.0;
        this.gram = gram;
    }

    public double singleConversion() {
        if (this.gram == 0.0) {
            return this.mol * (molecule.getMolarMass() / 1000);
        } else {
            return this.gram / (molecule.getMolarMass() / 1000);
        }
    }
}
