import java.util.*;

public class Palindrome {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    int midPoint = (int) Math.floor((A.length() / 2));
    for (int i = 0; i < midPoint; i++) {
      if (A.charAt(i) != A.charAt(A.length() - i - 1)) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }
}
