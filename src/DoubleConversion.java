public class DoubleConversion extends Single {
    private String molecule2;
    private int topConversion, bottomConversion, type;
    public DoubleConversion(String molecule1, double mol, String molecule2, int topConversion, int bottomConversion, int type) {
        super(molecule2, mol);
        this.molecule2 = molecule1;
        this.topConversion = topConversion;
        this.bottomConversion = bottomConversion;
        this.type = type;
    }
    public DoubleConversion(double gram, String molecule1, String molecule2, int topConversion, int bottomConversion, int type) {
        super(gram, molecule1);
        this.molecule2 = molecule2;
        this.topConversion = topConversion;
        this.bottomConversion = bottomConversion;
        this.type = type;
    }
    public double calculateDouble() {
        if (type < 3) {
            return this.singleConversion() * this.topConversion / this.bottomConversion;
        } else if (type == 3) {
            MolarMass mass = new MolarMass(this.molecule2);
            return this.singleConversion() * this.topConversion / this.bottomConversion * mass.getMolarMass();
        }
        return 0.0;
    }
}
