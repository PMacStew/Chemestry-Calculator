public class Single {
    private MolarMass molecule;
    private double mol, gram;

    // mol to gram

    public Single(String molecule, double mol) {
        this.molecule = new MolarMass(molecule);
        this.mol = mol;
        this.gram = 0;
    }

    // gram to mol

    public Single(int x, double gram, String molecule) {
        this.molecule = new MolarMass(molecule);
        this.mol = 0;
        this.gram = gram;
    }

    public double singleConversion() {
        if (this.gram == 0) {
            return this.mol * molecule.getMolarMass();
        } else {
            return this.gram / molecule.getMolarMass();
        }
    }

    public double getMol() {
        return this.mol;
    }
    public void setMol(double mol) {
        this.mol = mol;
    }
    public void setGram(double gram) {
        this.gram = gram;
    }
    public void setMolecule(MolarMass molarMass) {
        this.molecule = molarMass;
    }
}
