import java.util.Stack;

public class SymetricStack {
  public boolean solve(String input) {
    Stack<Character> stack = new Stack<>();
    char[] chars = input.toCharArray();
    return evaluate(chars, stack);
  }

  private boolean evaluate(char[] chars, Stack<Character> stack) {
    for (char c : chars) {
      if (stack.isEmpty()) {
        stack.push(c);
      } else {
        int last = (int) stack.peek();
        int current = (int) c;
        if (current == last + 1 || current == last + 2) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    }
    return stack.isEmpty();
  }
}

class SymmetricStackRegex {
  public boolean solve(String input){
    String res = input.replaceAll("\\{\\}|\\[\\]|\\(\\)","");
    System.out.println("input after replacement " + res);
    return res.isEmpty();
  }
}
