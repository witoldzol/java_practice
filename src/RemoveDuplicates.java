import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveDuplicates {
  public static void main(String[] args) {

  }

  public static String removeDuplicates(String s) {
    String regex = "\\b(\\w+)(\\s+\\1\\b)+";
    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    Matcher matcher = pattern.matcher(s);
    while (matcher.find()) {
      s = s.replaceAll(matcher.group(), matcher.group(1));
    }
    return s;
  }
}
