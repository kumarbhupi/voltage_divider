public class Resistor implements Comparable<Resistor> {
  private double resistance;
  private Series series = null;

  public double getResistance() {
    return resistance;
  }

  public Series getSeries() {
    return series;
  }

  public Resistor(double resistance, Series series) {
    this.resistance = resistance;
    this.series = series;
  }

  @Override
  public String toString() {
    return "Resistance " + resistance + ",series " + series.getName() + ", precision " + series.getPrecision();
  }// to print a Resistor with System.out.println

  @Override
  public int compareTo(Resistor resistor) {
    return Double.compare(resistance, resistor.getResistance());
  }
}