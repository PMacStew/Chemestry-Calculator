public class DoubleConversion extends Single {
    private MolarMass molecule2;
    private int topConversion, bottomConversion, type;
    public DoubleConversion(String molecule1, double mol, String molecule2, int topConversion, int bottomConversion, int type) {
        super(molecule2, mol);
        this.molecule2 = new MolarMass(molecule1);
        this.topConversion = topConversion;
        this.bottomConversion = bottomConversion;
        this.type = type;
    }
    public DoubleConversion(int x, double gram, String molecule1, String molecule2, int topConversion, int bottomConversion, int type) {
        super(x, gram, molecule1);
        this.molecule2 = new MolarMass(molecule2);
        this.topConversion = topConversion;
        this.bottomConversion = bottomConversion;
        this.type = type;
    }
    public double calculateDouble() {
        if (type < 3) {
            return this.singleConversion() * (double) this.bottomConversion / (double) this.topConversion;
        } else if (type == 3) {
            return this.getMol() * (double) this.bottomConversion / (double) this.topConversion;
        } else if (type == 4) {
            this.setMol(this.singleConversion());
            this.setGram(0);
            this.setMolecule(molecule2);
            return this.singleConversion() * (double) this.bottomConversion / (double) this.topConversion;
        }
        return 0.0;
    }
}
