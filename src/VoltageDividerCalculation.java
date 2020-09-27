import java.util.List;

public class VoltageDividerCalculation {
  public static void calculate(double voltageDivision, double coincidence, Series s){
    List<Resistor> resistors = s.getResistors();
    for(Resistor r1 : resistors){
      for (Resistor r2: resistors){
        if(false){
          VoltageDivider voltageDivider = new VoltageDivider(r1, r2, coincidence );
        }
        //TODO: Implement pdf formula
        System.out.println("R1=" + r1 + "R2 = " + r2);

      }
    }
  }
}
