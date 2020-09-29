import java.util.SortedSet;

public class VoltageDivider implements Comparable<VoltageDivider> {
  private Resistor resistor1 = null;
  private Resistor resistor2 = null;
  private double coincidence;


  public VoltageDivider(Resistor resistor1, Resistor resistor2, double coincidence) {
    this.resistor1 = resistor1;
    this.resistor2 = resistor2;
    this.coincidence = coincidence;
  }

  @Override
  public int compareTo(VoltageDivider voltageDivider) {
    return Double.compare(coincidence, voltageDivider.coincidence);
  }

  @Override
  public String toString() {
    return resistor1 + "," + resistor2 + "\nvoltage division "
        + resistor2.getResistance() / (resistor1.getResistance()
        + resistor2.getResistance())
        + "\ncoincidence " + coincidence + "\n";
  }
}
