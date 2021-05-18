import java.util.Scanner;

public class Anagrams {
  static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) return false;

    String aToLower = a.toLowerCase();
    String bToLower = b.toLowerCase();

    for (char c : aToLower.toCharArray()) {
      int countInA = countCharInString(c, aToLower);
      int countInB = countCharInString(c, bToLower);
      if (countInA != countInB) return false;
    }

    return true;
  }

  private static int countCharInString(char c, String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    scan.close();
    boolean ret = isAnagram(a, b);
    System.out.println((ret) ? "Anagrams" : "Not Anagrams");
  }
}
