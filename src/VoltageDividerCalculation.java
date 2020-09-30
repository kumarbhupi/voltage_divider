import java.lang.reflect.Array;
import java.util.*;

public class VoltageDividerCalculation {
  public static List<VoltageDivider> calculate(double voltageDivision, double coincidence, Series s) {
    ArrayList<VoltageDivider> results = new ArrayList<>();
    //SortedSet<VoltageDivider> results = new TreeSet<VoltageDivider>();
    List<Resistor> resistors = s.getResistors();

    for (Resistor r1 : resistors) {
      for (Resistor r2 : resistors) {
        double r1r2VoltageDivision = r2.getResistance() / (r1.getResistance() + r2.getResistance());
        double r1r2Coincidence = voltageDivision/r1r2VoltageDivision <= 1 ? (voltageDivision/r1r2VoltageDivision)*100 : (r1r2VoltageDivision/voltageDivision)*100;

        if(r1r2Coincidence>=coincidence){
          VoltageDivider voltageDivider = new VoltageDivider(r1, r2, r1r2Coincidence);
          results.add(voltageDivider);
        }
      }
    }
    Collections.sort(results);
    return  results;
  }

  public static List<VoltageDivider> linearCalculate(double voltageDivision, double coincidence, Series s) {
    List<Resistor> resistors = s.getResistors();
    Collections.sort(resistors);
    List<VoltageDivider> results = new ArrayList<>();
    int counter = 0;

    double tol = voltageDivision * (100 - coincidence) / 100;

    for (Resistor r1 : resistors) {
      double r2Lower = (voltageDivision - tol) * r1.getResistance() / (1 - (voltageDivision - tol));
      double r2Upper = (voltageDivision + tol) * r1.getResistance() / (1 - (voltageDivision + tol));
      for (Resistor rx : resistors) {
        double r1r2VoltageDivision = rx.getResistance() / (r1.getResistance() + rx.getResistance());
        double r1r2Coincidence = r1r2VoltageDivision / voltageDivision <= 1 ? (r1r2VoltageDivision / voltageDivision) * 100 : (1 + 1 - (r1r2VoltageDivision / voltageDivision)) * 100; // FORMULA PDF
        if (r2Lower <= rx.getResistance()) {
          if (r2Upper >= rx.getResistance()) {
            VoltageDivider voltageDivider = new VoltageDivider(r1, rx, r1r2Coincidence);
            results.add(voltageDivider);

          } else {
            break;
          }
        }
      }
    }
    Collections.sort(results);
    return  results;
  }
}
