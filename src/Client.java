import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Client {
  public static void main(String[] args) {
    SeriesCatalog seriesCatalog = new SeriesCatalog();

    double k = 0.5;
    String name = "E6";
    double coincidence = 80.;
    Series series = seriesCatalog.findSeriesByName(name);


    //List<VoltageDivider> result = VoltageDividerCalculation.calculate(k, coincidence, series);
    List<VoltageDivider> result = VoltageDividerCalculation.linearCalculate(k, coincidence, series);

    for (VoltageDivider voltageDivider: result) {
      System.out.println(voltageDivider.toString());
    }

  }
}
