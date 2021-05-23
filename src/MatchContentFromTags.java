import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchContentFromTags {

  public List<String> printInnerText(String[] inputs) {
    List<String> result = new ArrayList<>();

    for (String line : inputs) {
      boolean matchNotFound = true;

      String regex = "<(.+)>([^<]+)</\\1>";
      Pattern tagPattern = Pattern.compile(regex);
      Matcher matcher = tagPattern.matcher(line);

      while (matcher.find()) {
        result.add(matcher.group(2));
        matchNotFound = false;
      }
      if (matchNotFound) {
        result.add("None");
      }
    }

    return result;
  }
}
