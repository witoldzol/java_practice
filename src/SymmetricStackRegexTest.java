import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymmetricStackRegexTest {

  @Test
  public void notSymmetric() {
    String input = "{([(]))}";
    SymmetricStackRegex stack = new SymmetricStackRegex();
    boolean result = stack.solve(input);
    assertEquals(result, false);
  }

  @Test
  public void returnsTrueWhenSymmetric() {
    String input = "{}()[]";
    SymmetricStackRegex stack = new SymmetricStackRegex();
    boolean result = stack.solve(input);
    assertEquals(result, true);
  }

}
