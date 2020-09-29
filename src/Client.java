import java.util.SortedSet;

public class Client {
  public static void main(String[] args) {
    SeriesCatalog seriesCatalog = new SeriesCatalog();

    double k = 0.5;
    String name = "E6";
    double coincidence = 80.;
    Series series = seriesCatalog.findSeriesByName(name);


    //SortedSet<VoltageDivider> result = VoltageDividerCalculation.linearCalculate(k, coincidence, series);
    SortedSet<VoltageDivider> result = VoltageDividerCalculation.calculate(k, coincidence, series);

    for (VoltageDivider voltageDivider: result) {
      System.out.println(voltageDivider.toString());
    }

  }
}
