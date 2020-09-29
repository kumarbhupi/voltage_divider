import java.util.List;

public class VoltageDividerCalculation {
  public static void calculate(double voltageDivision, double coincidence, Series s){
    List<Resistor> resistors = s.getResistors();
    int counter = 0;
    double tolerance = voltageDivision*(100-coincidence)/100;
    for(Resistor r1 : resistors){
      for (Resistor r2: resistors){
        double r1r2VoltageDivision = r2.getResistance() / (r1.getResistance()+r2.getResistance());

        if((voltageDivision - tolerance)<= r1r2VoltageDivision & r1r2VoltageDivision <= (voltageDivision + tolerance)){
          counter ++;
          //double r1r2Coincidence = voltageDivision/r1r2VoltageDivision <= 1 ? (voltageDivision/r1r2VoltageDivision)*100 : 100+((1-(voltageDivision/r1r2VoltageDivision))*100);
          double r1r2Coincidence = voltageDivision/r1r2VoltageDivision <= 1 ? (voltageDivision/r1r2VoltageDivision)*100 : (r1r2VoltageDivision/voltageDivision)*100;

          System.out.println(counter+" - R1 = " + r1 + " R2 = " + r2);
          System.out.println("Voltage division " + r1r2VoltageDivision + "\ncoincidence with " +
              voltageDivision+ " : " +
              r1r2Coincidence + "% \n");
        }
      }
    }
  }
}
