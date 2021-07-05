import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SymetricStack {

  public static void main(String[] argh) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      List<Character> stack = new ArrayList<>();
      String input = sc.next();
      char[] chars = input.toCharArray();
      evaluate(chars, stack);
    }
  }

  private static void evaluate(char[] chars, List<Character> stack) {
    for (char c : chars) {
      if (stack.isEmpty()) {
        stack.add(c);
      } else {
        int last = (int) stack.get(stack.size() - 1);
        int current = (int) c;
        if (current == last + 1 || current == last + 2) {
          stack.remove(stack.size() - 1);
        } else {
          stack.add(c);
        }
      }
    }
    if (stack.isEmpty()) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
