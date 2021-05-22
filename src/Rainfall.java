import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rainfall {
  public static double mean(String town, String strng) {
    List<Double> temps = parseTemperatures(town, strng);
    return temps.stream().reduce(0d, Double::sum) / temps.size();
  }

  private static List<Double> parseTemperatures(String town, String data) {
    String townData = getTownData(town, data);
    return getTeperatures(townData);
  }

  private static List<Double> getTeperatures(String townData) {
    String regexTemperatures = "((?:\\d{0,3}\\.\\d{0,2})+)";
    Pattern tempPattern = Pattern.compile(regexTemperatures);
    Matcher tempMatcher = tempPattern.matcher(townData);
    List<Double> temperatures = new ArrayList<>();
    while (tempMatcher.find()) {
      temperatures.add(Double.parseDouble(tempMatcher.group()));
    }
    return temperatures;
  }

  private static String getTownData(String town, String data) {
    String cityRegex = town + ".*\\n";
    Pattern cityPattern = Pattern.compile(cityRegex);
    Matcher matcher = cityPattern.matcher(data);
    matcher.find();
    return matcher.group();
  }

  public static double variance(String town, String strng) {
    List<Double> temps = parseTemperatures(town, strng);
    double mean = mean(town, strng);
    return temps.stream()
            .map(x -> Math.pow(x - mean, 2))
            .reduce(0d, Double::sum)
            / temps.size();
  }
}
