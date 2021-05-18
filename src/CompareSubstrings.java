import java.util.Scanner;

public class CompareSubstrings {

  public static String getSmallestAndLargest(String s, int k) {
    String smallest = "";
    String largest = "";

    String[] strings = splitIntoSubstrings(s, k);
    for (String sub : strings) {
      if (sub.compareTo(smallest) < 0 || smallest.equals("")) {
        smallest = sub;
      }
      if (sub.compareTo(largest) > 0) {
        largest = sub;
      }
    }

    // Complete the function
    // 'smallest' must be the lexicographically smallest substring of length 'k'
    // 'largest' must be the lexicographically largest substring of length 'k'

    return smallest + "\n" + largest;
  }

  private static String[] splitIntoSubstrings(String s, int substringSize) {
    int numberOfSubstrings = calculateNumberOfSubstrings(s, substringSize);
    String[] substrings = new String[numberOfSubstrings];
    if (numberOfSubstrings == 0) return substrings;
    if (numberOfSubstrings == 1) {
      substrings[0] = s;
      return substrings;
    }
    for (int i = 0; i < numberOfSubstrings; i++) {
      String substring = s.substring(i, i + substringSize);
      substrings[i] = substring;
    }
    return substrings;
  }

  private static int calculateNumberOfSubstrings(String s, int substringSize) {
    if (s.length() < substringSize) return 0;
    if (s.length() == substringSize) return 1;
    return s.length() - substringSize + 1;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int k = scan.nextInt();
    scan.close();

    System.out.println(getSmallestAndLargest(s, k));
  }
}
