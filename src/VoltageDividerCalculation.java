import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class VoltageDividerCalculation {
  public static SortedSet<VoltageDivider> calculate(double voltageDivision, double coincidence, Series s){
    SortedSet<VoltageDivider> results = new TreeSet<VoltageDivider>();
    List<Resistor> resistors = s.getResistors();
    int counter = 0;
    double tolerance = voltageDivision*(100-coincidence)/100;

    for(Resistor r1 : resistors){
      for (Resistor r2: resistors){
        double r1r2VoltageDivision = r2.getResistance() / (r1.getResistance()+r2.getResistance());

        //double r1r2Coincidence = voltageDivision/r1r2VoltageDivision <= 1 ? (voltageDivision/r1r2VoltageDivision)*100 : (r1r2VoltageDivision/voltageDivision)*100; // FORMULA WEB
        double r1r2Coincidence = r1r2VoltageDivision/voltageDivision <= 1 ? (r1r2VoltageDivision/voltageDivision)*100 : (1 + 1-(r1r2VoltageDivision/voltageDivision))*100; // FORMULA PDF

        if((voltageDivision - tolerance)<= r1r2VoltageDivision & r1r2VoltageDivision <= (voltageDivision + tolerance)){//PDF
        //if(r1r2Coincidence>=coincidence){ //WEB
          counter ++;
          VoltageDivider voltageDivider = new VoltageDivider(r1, r2, r1r2Coincidence);
          results.add(voltageDivider);
          /*System.out.println(counter+" - R1 = " + r1 + " R2 = " + r2);
          System.out.println("Voltage division " + r1r2VoltageDivision + "\ncoincidence with " +
              voltageDivision+ " : " +
              r1r2Coincidence + "% \n");*/
        }
      }
    }
    return results;
  }
}
