import java.util.SortedSet;

public class Client {
  public static void main(String[] args) {
    SeriesCatalog seriesCatalog = new SeriesCatalog();

    double k = 0.5;
    String name = "E24";
    double coincidence = 80.;
    Series series = seriesCatalog.findSeriesByName(name);

    //VoltageDividerCalculation.calculate(k, coincidence, series);
    SortedSet<VoltageDivider> result = VoltageDividerCalculation.calculate(k, coincidence, series);

    for (VoltageDivider voltageDivider: result) {
      System.out.println(voltageDivider.toString());
    }

  }
}
