public class Client {
  public static void main(String[] args) {
    SeriesCatalog seriesCatalog = new SeriesCatalog();

    double k = 0.5;
    String name = "E6";
    double coincidence = 80.;
    Series series = seriesCatalog.findSeriesByName(name);

    VoltageDividerCalculation.calculate(k, coincidence, series);
  }
}
